package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.dao.relatiebeheer.PersoonsrolDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.RolDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("persoonsrolService")
@Transactional
public class PersoonsrolService {

	@Autowired
	private PersoonsrolDaoImpl dao;
	@Autowired
	private RolDaoImpl rolDao;
	
	public void save(Persoonsrol persoonsrol) {
		dao.save(persoonsrol);
	}
	
	public void addRol(String rol, Persoonsrol persoonsrol) {
		rolDao.addRol(rol, persoonsrol);
	}
	
	public Persoonsrol get(Integer id) {
		return dao.getById(id);
	}
	
	public void update(Persoonsrol persoonsrol) {
		dao.update(persoonsrol);
	}
	
	public void delete(Persoonsrol persoonsrol) {
		dao.delete(persoonsrol);
	}
	
	public List<Persoonsrol> getAll() {
		return dao.getAll();
	}
	
}
