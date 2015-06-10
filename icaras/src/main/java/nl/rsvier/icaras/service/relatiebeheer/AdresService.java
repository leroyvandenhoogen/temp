package nl.rsvier.icaras.service.relatiebeheer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.dao.relatiebeheer.AdresDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.AdresTypeDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("IAdresService")
@Transactional
@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AdresService {
	
	@Autowired
	AdresDaoImpl adresDao;
	@Autowired
	AdresTypeDaoImpl typeDao;
	
	public void save(Adres a) {
		adresDao.save(a);
	}
	
	public void save(String adresType, Adres a) {
		if(addAdresType(adresType, a)) {
			adresDao.save(a);
		}
	}
	
	public void update(Adres a) {
		adresDao.update(a);
	}
	
	public void delete(Adres a) {
		adresDao.delete(a);
	}
	
	public Adres get(int id) {
		return adresDao.getById(id);
	}
	
	public List<Adres> getAll() {
		return adresDao.getAll();
	}
	
	public List<Adres> getAll(Persoon persoon) {
		List<Adres> temp = persoon.getAdressen();
		List<Adres> adressen = new ArrayList<Adres>();
		for(Adres a: temp) {
			if(a.getId() != null) {
			get(a.getId());
			adressen.add(a);
			}
		}
		return adressen;
	}
	
	public List<AdresType> getAllTypes() {
		return typeDao.getAll();
	}
	
	public boolean addAdresType(String adresType, Adres adres) {
		return typeDao.addAdresType(adresType, adres);
	}
}
