package id.goindonesia.area.indonesia.repositories;

import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.models.ProvinceEntity;
import id.goindonesia.area.indonesia.models.RegencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by ghostzali on 25/04/17.
 */
@Transactional
public interface RegencyCrudRepository extends CrudRepository<RegencyEntity, Integer> {
    RegencyEntity findFirstByCode(Integer code);

    RegencyEntity findFirstByDistrictsContains(DistrictEntity district);

    Collection<RegencyEntity> findAllByNameContaining(String nameKeyword);

    Collection<RegencyEntity> findAllByProvinceEquals(ProvinceEntity province);
}
