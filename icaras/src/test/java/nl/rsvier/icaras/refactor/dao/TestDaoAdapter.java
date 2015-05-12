package nl.rsvier.icaras.refactor.dao;

import java.util.List;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.IEntity;

public class TestDaoAdapter<T extends IEntity> {

	Class<T> type;
	
	GenericDaoImpl<?> dao;
	public TestDaoAdapter(Class<T> type, GenericDaoImpl<?> dao) {
		this.type = type;
		this.dao = dao;
	}
	
	public void flush() {
		dao.getHibernateTemplate().flush();
	}
	
	public void clear() {
		dao.getHibernateTemplate().clear();
	}
	
	public void evict(Object obj) {
		dao.getHibernateTemplate().evict(obj);
	}
	
	//Generieke methode werkt onafhankelijk van Generieke type van de klasse
//	@SuppressWarnings("unchecked")
//	public <E extends IEntity> E get(E entity) {
//		return (E) dao.getHibernateTemplate().get(entity.getClass(), entity.getId());
//	}
	
	@SuppressWarnings("unchecked")
	public T getAnEntityById(T entity) {
		return (T) dao.getHibernateTemplate().get(entity.getClass(), entity.getId());
	}

	public void save(T entity) {
		dao.getHibernateTemplate().save(entity);		
	}

	public void update(T entity) {
		dao.getHibernateTemplate().update(entity);		
	}

	public void delete(T entity) {
		dao.getHibernateTemplate().delete(entity);		
	}
	
	public T getById(int id) {
		return (T) dao.getHibernateTemplate().get(type, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return (List<T>) dao.getHibernateTemplate().find("from " + type.getName());
	}	
}
