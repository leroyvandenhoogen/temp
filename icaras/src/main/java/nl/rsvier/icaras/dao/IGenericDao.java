package nl.rsvier.icaras.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T getById(int id);
	
	public List<T> getAll();

}
