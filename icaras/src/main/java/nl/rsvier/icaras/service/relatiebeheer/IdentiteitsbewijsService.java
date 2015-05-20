package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;
import nl.rsvier.icaras.dao.relatiebeheer.IdentiteitsbewijsDaoImpl;
import nl.rsvier.icaras.dao.relatiebeheer.IdentiteitsbewijsTypeDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("IIdentiteitsbewijsService")
@Transactional
@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class IdentiteitsbewijsService {
	
	@Autowired
	IdentiteitsbewijsDaoImpl idDao;
	@Autowired
	IdentiteitsbewijsTypeDaoImpl idTypeDao;
	
	public void save(Identiteitsbewijs idBewijs) {
		idDao.save(idBewijs);
	}
	
	public void update(Identiteitsbewijs idBewijs) {
		idDao.update(idBewijs);
	}
	
	public void delete(Identiteitsbewijs idBewijs) {
		idDao.delete(idBewijs);
	}
	
	public Identiteitsbewijs get(String id) {
		return idDao.getById(id);
	}
	
	public Identiteitsbewijs getEager(String id) {
		return idDao.getByIdEager(id);
	}
	
	public boolean addIdentiteitsbewijsType(String idBewijsType, Identiteitsbewijs idBewijs) {
		return idTypeDao.addIdentiteitsbewijsType(idBewijsType, idBewijs);
	}
	
	public List<Identiteitsbewijs> getAll() {
		return idDao.getAll();
	}
}
