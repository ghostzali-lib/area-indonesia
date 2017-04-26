package id.goindonesia.area.indonesia.repositories.search.impls;

import id.goindonesia.area.indonesia.models.VillageEntity;
import id.goindonesia.area.indonesia.repositories.search.VillageSearchRepository;
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
public class VillageSearchRepositoryImpl implements VillageSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VillageEntity> search(String keyword) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(VillageEntity.class).get();
        Query query;
        if (StringChecker.isLong(keyword))
            query = queryBuilder.keyword().onFields("code").matching(Long.parseLong(keyword)).createQuery();
        else
            query = queryBuilder.keyword().onFields("name").matching(keyword.toUpperCase()).createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, VillageEntity.class);
        return jpaQuery.getResultList();
    }

    @Override
    public List<VillageEntity> search(String keyword, String field) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(VillageEntity.class).get();
        Query query = queryBuilder.keyword().onField(field).matching(keyword).createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, VillageEntity.class);
        return jpaQuery.getResultList();
    }

    @Override
    public List<VillageEntity> search(String keyword, String... fields) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(VillageEntity.class).get();
        Query query = queryBuilder.keyword().onFields(fields).matching(keyword).createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, VillageEntity.class);
        return jpaQuery.getResultList();
    }
}
