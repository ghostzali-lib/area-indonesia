package id.goindonesia.area.indonesia.services.impls;

import id.goindonesia.area.indonesia.models.VillageEntity;
import id.goindonesia.area.indonesia.repositories.DistrictCrudRepository;
import id.goindonesia.area.indonesia.repositories.VillageCrudRepository;
import id.goindonesia.area.indonesia.repositories.search.VillageSearchRepository;
import id.goindonesia.area.indonesia.services.VillageService;
import id.goindonesia.area.indonesia.views.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
@Component
public class VillageServiceImpl implements VillageService {

    @Autowired
    private DistrictCrudRepository provinceCrudRepository;

    @Autowired
    private VillageCrudRepository villageCrudRepository;

    @Autowired
    private VillageSearchRepository VillageSearchRepository;

    @Override
    public Area findByCode(Long code) {
        return Area.create(villageCrudRepository.findFirstByCode(code));
    }

    @Override
    public List<Area> findAll() {
        return Area.createListFromVillages((List<VillageEntity>) villageCrudRepository.findAll());
    }

    @Override
    public List<Area> findByKeyword(String keyword) {
        return Area.createListFromVillages(VillageSearchRepository.search(keyword));
    }

    @Override
    public List<Area> findByKeywordFromField(String keyword, String field) {
        return Area.createListFromVillages(VillageSearchRepository.search(keyword, field));
    }

    @Override
    public List<Area> findByKeywordFromFields(String keyword, String... fields) {
        return Area.createListFromVillages(VillageSearchRepository.search(keyword, fields));
    }

    @Override
    public List<Area> findByParent(Integer parentCode) {
        return Area.createListFromVillages(provinceCrudRepository.findFirstByCode(parentCode).getVillages());
    }
}
