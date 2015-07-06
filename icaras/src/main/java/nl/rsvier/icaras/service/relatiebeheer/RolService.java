package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Rol;
import nl.rsvier.icaras.dao.relatiebeheer.RolDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IRolService")
@Transactional
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RolService {

	@Autowired
	RolDaoImpl rolDao;

	public List<Rol> getAllTypes() {
		return rolDao.getAll();
	}

	public void save(Rol r) {
		if (!getAllTypes().contains(r))
			rolDao.save(r);
	}

	public void update(Rol r) {
		rolDao.update(r);
	}

	public void delete(Rol r) {
		rolDao.delete(r);
	}

	public Rol getById(int id) {
		return rolDao.getById(id);
	}

	public void updateList(List<Rol> list) {
		for (Rol type : list) {
			rolDao.save(type);
		}
	}

}