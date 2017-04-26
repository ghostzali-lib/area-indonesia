package id.goindonesia.area.indonesia.repositories;

import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.models.RegencyEntity;
import id.goindonesia.area.indonesia.models.VillageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by ghostzali on 25/04/17.
 */
public interface DistrictCrudRepository extends CrudRepository<DistrictEntity, Integer> {
    DistrictEntity findFirstByCode(Integer code);

    DistrictEntity findFirstByVillagesContains(VillageEntity village);

    Collection<DistrictEntity> findAllByNameContaining(String nameKeyword);

    Collection<DistrictEntity> findAllByRegencyEquals(RegencyEntity regency);
}
