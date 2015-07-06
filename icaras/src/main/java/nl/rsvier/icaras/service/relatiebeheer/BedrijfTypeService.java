package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.BedrijfType;
import nl.rsvier.icaras.dao.relatiebeheer.BedrijfTypeDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IBedrijfTypeService")
@Transactional
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BedrijfTypeService {

	@Autowired
	BedrijfTypeDaoImpl bedrijfTypeDao;

	public List<BedrijfType> getAllTypes() {
		return bedrijfTypeDao.getAll();
	}

	public void save(BedrijfType bt) {
		if (!getAllTypes().contains(bt))
			bedrijfTypeDao.save(bt);
	}

	public void update(BedrijfType bt) {
		bedrijfTypeDao.update(bt);
	}

	public void delete(BedrijfType bt) {
		bedrijfTypeDao.delete(bt);
	}

	public BedrijfType getById(int id) {
		return bedrijfTypeDao.getById(id);
	}

	public void updateList(List<BedrijfType> list) {
		for (BedrijfType type : list) {
			bedrijfTypeDao.save(type);
		}
	}

}