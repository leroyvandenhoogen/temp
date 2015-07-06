package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.BedrijfType;
import nl.rsvier.icaras.dao.relatiebeheer.BedrijfDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.BedrijfTypeDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("IBedrijfService")
@Transactional
@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class BedrijfService {

	@Autowired
	BedrijfDaoImpl bedrijfDao;
	@Autowired
	BedrijfTypeDaoImpl bedrijfTypeDao;
	
	public void save(Bedrijf b) {
		bedrijfDao.save(b);
	}
	
	public void update(Bedrijf b) {
		bedrijfDao.update(b);
	}
	
	public void delete(Bedrijf b) {
		bedrijfDao.delete(b);
	}
	
	public Bedrijf get(int id) {
		return bedrijfDao.getById(id);
	}
	
	public List<Bedrijf> getAll() {
		return bedrijfDao.getAll();
	}
	
	public List<Bedrijf> search(String naam) {
		return bedrijfDao.search(naam);
	}
	
	public List<BedrijfType> getAllTypes() {
		return bedrijfTypeDao.getAll();
	}
}
