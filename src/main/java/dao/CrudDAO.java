package dao;

import java.util.List;

public interface CrudDAO<T, K> {
	int create(T entity);
	int update(T entity);
	int delete(K id);
	List<T> findAll();
	T findById(K id);
}
