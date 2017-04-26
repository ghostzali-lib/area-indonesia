package id.goindonesia.area.indonesia.repositories.search.impls;

import id.goindonesia.area.indonesia.models.DistrictEntity;
import id.goindonesia.area.indonesia.repositories.search.DistrictSearchRepository;
import id.goindonesia.area.indonesia.utils.StringChecker;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ghostzali on 25/04/17.
 */
@Repository
@Transactional
public class DistrictSearchRepositoryImpl implements DistrictSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DistrictEntity> search(String keyword) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(DistrictEntity.class).get();
        Query query;
        if (StringChecker.isInteger(keyword))
            query = queryBuilder.keyword().onFields("code").matching(Integer.parseInt(keyword)).createQuery();
        else
            query = queryBuilder.keyword().onFields("name").matching(keyword.toUpperCase()).createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, DistrictEntity.class);
        return jpaQuery.getResultList();
    }

    @Override
    public List<DistrictEntity> search(String keyword, String field) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(DistrictEntity.class).get();
        Query query = queryBuilder.keyword().onField(field).matching(keyword).createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, DistrictEntity.class);
        return jpaQuery.getResultList();
    }

    @Override
    public List<DistrictEntity> search(String keyword, String... fields) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(DistrictEntity.class).get();
        Query query = queryBuilder.keyword().onFields(fields).matching(keyword).createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, DistrictEntity.class);
        return jpaQuery.getResultList();
    }
}
