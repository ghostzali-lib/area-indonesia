package id.goindonesia.area.indonesia.services.impls;

import id.goindonesia.area.indonesia.models.RegencyEntity;
import id.goindonesia.area.indonesia.repositories.ProvinceCrudRepository;
import id.goindonesia.area.indonesia.repositories.RegencyCrudRepository;
import id.goindonesia.area.indonesia.repositories.search.RegencySearchRepository;
import id.goindonesia.area.indonesia.services.RegencyService;
import id.goindonesia.area.indonesia.views.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
@Component
public class RegencyServiceImpl implements RegencyService {

    @Autowired
    private ProvinceCrudRepository provinceCrudRepository;

    @Autowired
    private RegencyCrudRepository RegencyCrudRepository;

    @Autowired
    private RegencySearchRepository RegencySearchRepository;

    @Override
    public Area findByCode(Integer code) {
        return Area.create(RegencyCrudRepository.findFirstByCode(code));
    }

    @Override
    public List<Area> findAll() {
        return Area.createListFromRegencies((List<RegencyEntity>) RegencyCrudRepository.findAll());
    }

    @Override
    public List<Area> findByKeyword(String keyword) {
        return Area.createListFromRegencies(RegencySearchRepository.search(keyword));
    }

    @Override
    public List<Area> findByKeywordFromField(String keyword, String field) {
        return Area.createListFromRegencies(RegencySearchRepository.search(keyword, field));
    }

    @Override
    public List<Area> findByKeywordFromFields(String keyword, String... fields) {
        return Area.createListFromRegencies(RegencySearchRepository.search(keyword, fields));
    }

    @Override
    public List<Area> findByParent(Integer parentCode) {
        return Area.createListFromRegencies(provinceCrudRepository.findFirstByCode(parentCode).getRegencies());
    }
}
