package core.commonapp.client.dao;

import java.util.List;

public interface BaseDao<T> {

	public List<T> findAll();

	public T findById(Integer id);

	public Class<T> getPersistClass();

	public T save(T object);

	public void saveAll(List<T> objects);
}
