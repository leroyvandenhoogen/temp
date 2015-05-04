package nl.rsvier.icaras.refactor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import nl.rsvier.icaras.refactor.core.Aanbieding;
import nl.rsvier.icaras.refactor.dao.IAanbiedingDao;
@Service("IAanbiedingService")
@Transactional
//@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AanbiedingService implements IAanbiedingService {

	@Autowired
	private IAanbiedingDao aanbiedingDao;
	@Override
	public Aanbieding getById(int id) {
		return aanbiedingDao.getById(id);
	}

	@Override
	public List<Aanbieding> getAll() {
		return aanbiedingDao.getAll();
	}

}
