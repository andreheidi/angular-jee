package me.moriya.repository;

import me.moriya.entity.Model;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by andre on 6/4/16.
 */
public class Repository<T extends Model<ID>, ID extends Serializable> implements GenericRepository<T, ID>{

    private Class<T> entity;

    @Inject
    private Logger log;

    @PersistenceContext
    private EntityManager entityManager;

    protected Repository() {
        Class<?> clazz = this.getClass();
        do {
            if (clazz.getSuperclass().equals(Repository.class)) {
                break;
            }
        } while ((clazz = clazz.getSuperclass()) != null);

        this.entity = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
        log.info("Successfully initialized repository");
    }

    public Repository(Class<T> entity) {
        this.entity = entity;
    }

    public T find(ID id) {
        return this.entityManager.find(this.entity, id);
    }

    public List<T> list() {
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.entity);
        Root<T> root = query.from(this.entity);
        CriteriaQuery<T> select = query.select(root);
        TypedQuery<T> typedQuery = this.entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    @Transactional
    public T save(T entity) {
        if(entity.getId() == null)
            this.entityManager.persist(entity);
        else
            this.entityManager.merge(entity);

        return entity;
    }

    @Transactional
    public void delete(T entity) {
        this.entityManager.remove(entity);
    }
}
