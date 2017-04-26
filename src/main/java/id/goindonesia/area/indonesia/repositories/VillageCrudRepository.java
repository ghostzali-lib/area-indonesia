package id.goindonesia.area.indonesia.repositories;

import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.models.VillageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by ghostzali on 25/04/17.
 */
public interface VillageCrudRepository extends CrudRepository<VillageEntity, Integer> {
    VillageEntity findFirstByCode(Long code);

    Collection<VillageEntity> findAllByNameContaining(String nameKeyword);

    Collection<VillageEntity> findAllByDistrictEquals(DistrictEntity district);
}
