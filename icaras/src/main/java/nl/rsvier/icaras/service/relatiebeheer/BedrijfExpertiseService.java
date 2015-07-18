package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.BedrijfExpertise;
import nl.rsvier.icaras.core.relatiebeheer.Expertise;
import nl.rsvier.icaras.dao.relatiebeheer.BedrijfExpertiseDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.ExpertiseDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("IBedrijfExpertiseService")
@Transactional
@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class BedrijfExpertiseService {
	
	@Autowired
	BedrijfExpertiseDaoImpl bedrijfExpertiseDao;
	@Autowired
	ExpertiseDaoImpl expertiseDao;
	
	public void save(BedrijfExpertise be) {
		bedrijfExpertiseDao.save(be);
	}
	
	public void update(BedrijfExpertise be) {
		bedrijfExpertiseDao.update(be);
	}
	
	public void delete(BedrijfExpertise be) {
		bedrijfExpertiseDao.delete(be);
	}
	
	public BedrijfExpertise get(int id) {
		return bedrijfExpertiseDao.getById(id);
	}
	
	public List<BedrijfExpertise> getAll() {
		return bedrijfExpertiseDao.getAll();
	}
	
	public List<Expertise> getAllTypes() {
		return expertiseDao.getAll();
	}
	
	public boolean addExpertise(String expertise, BedrijfExpertise bedrijfExpertise) {
		return expertiseDao.addExpertise(expertise, bedrijfExpertise);
	}
	
}
