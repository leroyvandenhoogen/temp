package nl.rsvier.icaras.service.relatiebeheer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.dao.relatiebeheer.AdresDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.AdresTypeDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.DigitaalAdresDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.DigitaalAdresTypeDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.IdentiteitsbewijsDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.IdentiteitsbewijsTypeDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.PersoonDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.PersoonsrolDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.RolDaoImpl;

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
	@Autowired
	AdresDaoImpl adresDao;
	@Autowired
	AdresTypeDaoImpl adresTypeDao;
	@Autowired
	DigitaalAdresDaoImpl digitaalAdresDao;
	@Autowired
	DigitaalAdresTypeDaoImpl digitaalAdresTypeDao;
	@Autowired
	PersoonsrolDaoImpl persoonsrolDao;
	@Autowired
	RolDaoImpl rolDao;
	@Autowired
	IdentiteitsbewijsDaoImpl identiteitsbewijsDao;
	@Autowired
	IdentiteitsbewijsTypeDaoImpl identiteitsbewijsTypeDao;
	
	public void save(Persoon persoon) {
		persoonDao.save(persoon);
	}
	
	public void update(Persoon persoon) {
		persoonDao.update(persoon);
	}
	
	public void delete(Persoon persoon) {
		persoonDao.delete(persoon);
	}
	
	public Persoon get(int id) {
		return persoonDao.getById(id);
	}
	
	public List<Persoon> getAll() {
		return persoonDao.getAll();
	}
	
	public List<Adres> getAllAdressen(Persoon persoon) {
		List<Adres> temp = persoon.getAdressen();
		List<Adres> adressen = new ArrayList<Adres>();
		for(Adres o: temp) {
			if(o.getId() != null) {
			adresDao.getById(o.getId());
			adressen.add(o);
			}
		}
		return adressen;
	}
	
	public List<DigitaalAdres> getAllDigitaleAdressen(Persoon persoon) {
		List<DigitaalAdres> temp = persoon.getDigitaleAdressen();
		List<DigitaalAdres> digitaleAdressen = new ArrayList<DigitaalAdres>();
		for(DigitaalAdres o: temp) {
			if(o.getId() != null) {
			digitaalAdresDao.getById(o.getId());
			digitaleAdressen.add(o);
			}
		}
		return digitaleAdressen;
	}
	
	public List<Persoonsrol> getAllPersoonsrollen(Persoon persoon) {
		List<Persoonsrol> temp = persoon.getPersoonsrollen();
		List<Persoonsrol> persoonsrollen = new ArrayList<Persoonsrol>();
		for(Persoonsrol o: temp) {
			if(o.getId() != null) {
			persoonsrolDao.getById(o.getId());
			persoonsrollen.add(o);
			}
		}
		return persoonsrollen;
	}
}
