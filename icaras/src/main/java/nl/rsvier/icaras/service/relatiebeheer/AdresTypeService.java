package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.dao.relatiebeheer.AdresTypeDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IAdresTypeService")
@Transactional
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdresTypeService {

	@Autowired
	AdresTypeDaoImpl typeDao;

	public List<AdresType> getAllTypes() {
		return typeDao.getAll();
	}

	public void save(AdresType a) {
		if (!getAllTypes().contains(a))
			typeDao.save(a);
	}

	public void saveList(List<AdresType> list) {
		List<AdresType> dbList = getAllTypes();
		for (AdresType type : list) {
			if (!dbList.contains(type))
				typeDao.save(type);
		}
	}
}
