package id.goindonesia.area.indonesia.services.impls;

import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.repositories.DistrictCrudRepository;
import id.goindonesia.area.indonesia.repositories.RegencyCrudRepository;
import id.goindonesia.area.indonesia.repositories.search.DistrictSearchRepository;
import id.goindonesia.area.indonesia.services.DistrictService;
import id.goindonesia.area.indonesia.views.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
@Component
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private RegencyCrudRepository regencyCrudRepository;

    @Autowired
    private DistrictCrudRepository districtCrudRepository;

    @Autowired
    private DistrictSearchRepository districtSearchRepository;

    @Override
    public Area findByCode(Integer code) {
        return Area.create(districtCrudRepository.findFirstByCode(code));
    }

    @Override
    public List<Area> findAll() {
        return Area.createListFromDistricts((List<DistrictEntity>) districtCrudRepository.findAll());
    }

    @Override
    public List<Area> findByKeyword(String keyword) {
        return Area.createListFromDistricts(districtSearchRepository.search(keyword));
    }

    @Override
    public List<Area> findByKeywordFromField(String keyword, String field) {
        return Area.createListFromDistricts(districtSearchRepository.search(keyword, field));
    }

    @Override
    public List<Area> findByKeywordFromFields(String keyword, String... fields) {
        return Area.createListFromDistricts(districtSearchRepository.search(keyword, fields));
    }

    @Override
    public List<Area> findByParent(Integer parentCode) {
        return Area.createListFromDistricts(regencyCrudRepository.findFirstByCode(parentCode).getDistricts());
    }
}
