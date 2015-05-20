package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.core.relatiebeheer.PersoonsrolId;
import nl.rsvier.icaras.dao.relatiebeheer.PersoonsrolDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.RolDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("IPersoonsrolService")
@Transactional
@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class PersoonsrolService {
	
	@Autowired
	PersoonsrolDaoImpl persoonsrolDao;
	@Autowired
	RolDaoImpl rolDao;
	
	public void save(Persoonsrol pr) {
		persoonsrolDao.save(pr);
	}
	
	public void update(Persoonsrol pr) {
		persoonsrolDao.update(pr);
	}
	
	public void delete(Persoonsrol pr) {
		persoonsrolDao.delete(pr);
	}
	
	public Persoonsrol getById(PersoonsrolId id) {
		return persoonsrolDao.getById(id);
	}
	
	public List<Persoonsrol> getAll() {
		return persoonsrolDao.getAll();
	}
	
	public boolean addRol(String rol, Persoonsrol pr) {
		return rolDao.addRol(rol, pr);
	}
}
