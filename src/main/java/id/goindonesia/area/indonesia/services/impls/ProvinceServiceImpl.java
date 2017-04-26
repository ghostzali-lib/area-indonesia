package id.goindonesia.area.indonesia.services.impls;

import id.goindonesia.area.indonesia.models.ProvinceEntity;
import id.goindonesia.area.indonesia.repositories.ProvinceCrudRepository;
import id.goindonesia.area.indonesia.repositories.search.ProvinceSearchRepository;
import id.goindonesia.area.indonesia.services.ProvinceService;
import id.goindonesia.area.indonesia.views.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
@Component
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceCrudRepository provinceCrudRepository;

    @Autowired
    private ProvinceSearchRepository provinceSearchRepository;

    @Override
    public Area findByCode(Integer code) {
        return Area.create(provinceCrudRepository.findFirstByCode(code));
    }

    @Override
    public List<Area> findAll() {
        return Area.createListFromProvinces((List<ProvinceEntity>) provinceCrudRepository.findAll());
    }

    @Override
    public List<Area> findByKeyword(String keyword) {
        return Area.createListFromProvinces(provinceSearchRepository.search(keyword));
    }

    @Override
    public List<Area> findByKeywordFromField(String keyword, String field) {
        return Area.createListFromProvinces(provinceSearchRepository.search(keyword, field));
    }

    @Override
    public List<Area> findByKeywordFromFields(String keyword, String... fields) {
        return Area.createListFromProvinces(provinceSearchRepository.search(keyword, fields));
    }
}
