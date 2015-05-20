package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.dao.relatiebeheer.PersoonDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("IPersoonService")
@Transactional
@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class PersoonService {
	
	@Autowired
	PersoonDaoImpl persoonDao;
	
	public void save(Persoon p) {
		persoonDao.save(p);
	}
	
	public void update(Persoon p) {
		persoonDao.update(p);
	}
	
	public void delete(Persoon p) {
		persoonDao.delete(p);
	}
	
	public Persoon getById(int id) {
		return persoonDao.getById(id);
	}
	
	public List<Persoon> getAll() {
		return persoonDao.getAll();
	}
}
