package core.commonapp.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.BaseDao;


public abstract class BaseDaoJpaImpl<T> implements BaseDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<T> findAll() {
		Query query = getEntityManager().createQuery("from " 
    			+ getPersistClass().getSimpleName());
		return query.getResultList();
    }

    @Override
	public T findById(Integer id) {
    	return getEntityManager().find(getPersistClass(), id);
    }
    
	public EntityManager getEntityManager() {
		return entityManager;
	}
    
    @Override
	public abstract Class<T> getPersistClass();
    
    @Override
	@Transactional
    public T save(T object)
    {
        getEntityManager().persist(object);
        return object;
    }
    
    @Override
	@Transactional
    public void saveAll(List<T> objects) {
    	for (T object : objects) {
    		save(object);
    	}
    }

    
}
