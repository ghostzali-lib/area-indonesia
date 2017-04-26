package id.goindonesia.area.indonesia.setup.impls;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.models.ProvinceEntity;
import id.goindonesia.area.indonesia.models.RegencyEntity;
import id.goindonesia.area.indonesia.models.VillageEntity;
import id.goindonesia.area.indonesia.repositories.DistrictCrudRepository;
import id.goindonesia.area.indonesia.repositories.ProvinceCrudRepository;
import id.goindonesia.area.indonesia.repositories.RegencyCrudRepository;
import id.goindonesia.area.indonesia.repositories.VillageCrudRepository;
import id.goindonesia.area.indonesia.setup.DataImport;
import id.goindonesia.area.indonesia.setup.data.DistrictImport;
import id.goindonesia.area.indonesia.setup.data.ProvinceImport;
import id.goindonesia.area.indonesia.setup.data.RegencyImport;
import id.goindonesia.area.indonesia.setup.data.VillageImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghostzali on 25/04/17.
 */
@Component
public class DataImportImpl implements DataImport {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProvinceCrudRepository provinceCrudRepository;
    @Autowired
    private RegencyCrudRepository regencyCrudRepository;
    @Autowired
    private DistrictCrudRepository districtCrudRepository;
    @Autowired
    private VillageCrudRepository villageCrudRepository;

    @Override
    public void start() throws IOException {
        Gson gson = new Gson();
        Reader readerProvinces = new InputStreamReader(getClass().getResourceAsStream("/json/provinces.json"));
        List<ProvinceImport> provinces = gson.fromJson(readerProvinces, new TypeToken<ArrayList<ProvinceImport>>() {
        }.getType());
        Reader readerRegencies = new InputStreamReader(getClass().getResourceAsStream("/json/regencies.json"));
        List<RegencyImport> regencies = gson.fromJson(readerRegencies, new TypeToken<ArrayList<RegencyImport>>() {
        }.getType());
        Reader readerDistricts = new InputStreamReader(getClass().getResourceAsStream("/json/districts.json"));
        List<DistrictImport> districts = gson.fromJson(readerDistricts, new TypeToken<ArrayList<DistrictImport>>() {
        }.getType());
        Reader readerVillages = new InputStreamReader(getClass().getResourceAsStream("/json/villages.json"));
        List<VillageImport> villages = gson.fromJson(readerVillages, new TypeToken<ArrayList<VillageImport>>() {
        }.getType());

        List<ProvinceEntity> provinceEntities = new ArrayList<>();
        List<RegencyEntity> regencyEntities = new ArrayList<>();
        List<DistrictEntity> districtEntities = new ArrayList<>();
        List<VillageEntity> villageEntities = new ArrayList<>();
        provinces.forEach(p -> {
            provinceEntities.add((ProvinceEntity) p.create());
            logger.info("Add province : " + p.getName());
        });

        provinceEntities.forEach(p -> {
            List<RegencyEntity> rs = new ArrayList<>();
            regencies.forEach(r -> {
                if (r.getProvince().equals(p.getCode())) {
                    rs.add((RegencyEntity) r.create().setProvince(p));
                    logger.info("Add regency : " + r.getName() + " into province " + p.getName());
                }
            });
            //regencyCrudRepository.save(rs);

            rs.forEach(r -> {
                List<DistrictEntity> ds = new ArrayList<>();
                districts.forEach(d -> {
                    if (d.getRegency().equals(r.getCode())) {
                        ds.add((DistrictEntity) d.create().setRegency(r));
                        logger.info("Add district : " + d.getName() + " into regency " + r.getName());
                    }
                });
                //districtCrudRepository.save(ds);

                ds.forEach(d -> {
                    List<VillageEntity> vs = new ArrayList<>();
                    villages.forEach(v -> {
                        if (v.getDistrict().equals(d.getCode())) {
                            vs.add((VillageEntity) v.create().setDistrict(d));
                            logger.info("Add village : " + v.getName() + " into district " + d.getName());
                        }
                    });
                    //villageCrudRepository.save(vs);
                    villageEntities.addAll(vs);
                });
                districtEntities.addAll(ds);
            });
            regencyEntities.addAll(rs);
        });

        provinceCrudRepository.save(provinceEntities);
        regencyCrudRepository.save(regencyEntities);
        districtCrudRepository.save(districtEntities);
        villageCrudRepository.save(villageEntities);


    }

}
