package id.goindonesia.area.indonesia.services.impls;

import id.goindonesia.area.indonesia.repositories.search.DistrictSearchRepository;
import id.goindonesia.area.indonesia.repositories.search.ProvinceSearchRepository;
import id.goindonesia.area.indonesia.repositories.search.RegencySearchRepository;
import id.goindonesia.area.indonesia.repositories.search.VillageSearchRepository;
import id.goindonesia.area.indonesia.services.MergedSearchService;
import id.goindonesia.area.indonesia.views.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghostzali on 26/04/17.
 */
@Component
public class MergedSearchServiceImpl implements MergedSearchService {

    @Autowired
    private ProvinceSearchRepository provinceSearchRepository;

    @Autowired
    private RegencySearchRepository regencySearchRepository;

    @Autowired
    private DistrictSearchRepository districtSearchRepository;

    @Autowired
    private VillageSearchRepository villageSearchRepository;

    @Override
    public List<Area> searchFromAll(String keyword) {
        List<Area> results = new ArrayList<>();
        results.addAll(Area.createListFromProvinces(provinceSearchRepository.search(keyword)));
        results.addAll(Area.createListFromRegencies(regencySearchRepository.search(keyword)));
        results.addAll(Area.createListFromDistricts(districtSearchRepository.search(keyword)));
        results.addAll(Area.createListFromVillages(villageSearchRepository.search(keyword)));
        return results;
    }
}
