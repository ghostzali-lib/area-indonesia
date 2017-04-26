package id.goindonesia.area.indonesia.repositories;

import id.goindonesia.area.indonesia.models.ProvinceEntity;
import id.goindonesia.area.indonesia.models.RegencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by ghostzali on 25/04/17.
 */
@Transactional
public interface ProvinceCrudRepository extends CrudRepository<ProvinceEntity, Integer> {
    ProvinceEntity findFirstByCode(Integer code);

    ProvinceEntity findFirstByRegenciesContains(RegencyEntity regency);

    Collection<ProvinceEntity> findAllByNameContaining(String nameKeyword);
}
