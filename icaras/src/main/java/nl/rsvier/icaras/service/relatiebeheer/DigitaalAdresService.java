package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;
import nl.rsvier.icaras.dao.relatiebeheer.DigitaalAdresDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.DigitaalAdresTypeDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("IDigitaalAdresService")
@Transactional
@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DigitaalAdresService {
	
	@Autowired
	DigitaalAdresDaoImpl digitaalAdresDao;
	@Autowired
	DigitaalAdresTypeDaoImpl digitaalAdresTypeDao;
	
	public void save(DigitaalAdres da) {
		digitaalAdresDao.save(da);
	}
	
	public void update(DigitaalAdres da) {
		digitaalAdresDao.update(da);
	}
	
	public void delete(DigitaalAdres da) {
		digitaalAdresDao.delete(da);
	}
	
	public DigitaalAdres get(int id) {
		return digitaalAdresDao.getById(id);
	}
	
	public List<DigitaalAdres> getAll() {
		return digitaalAdresDao.getAll();
	}
	
	public List<DigitaalAdresType> getAllTypes() {
		return digitaalAdresTypeDao.getAll();
	}
	
	public boolean addAdresType(String adresType, DigitaalAdres digitaalAdres) {
		return digitaalAdresTypeDao.addDigitaalAdresType(adresType, digitaalAdres);
	}
	
}
