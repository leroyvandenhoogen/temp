package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Expertise;
import nl.rsvier.icaras.dao.relatiebeheer.ExpertiseDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.RolDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IExpertiseService")
@Transactional
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ExpertiseService {

	@Autowired
	ExpertiseDaoImpl expertiseDao;

	public List<Expertise> getAllTypes() {
		return expertiseDao.getAll();
	}

	public void save(Expertise e) {
		if (!getAllTypes().contains(e))
			expertiseDao.save(e);
	}

	public void update(Expertise e) {
		expertiseDao.update(e);
	}

	public void delete(Expertise e) {
		expertiseDao.delete(e);
	}

	public Expertise getById(int id) {
		return expertiseDao.getById(id);
	}

	public void updateList(List<Expertise> list) {
		for (Expertise type : list) {
			expertiseDao.save(type);
		}
	}

}
