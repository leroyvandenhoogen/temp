package nl.rsvier.icaras.service.relatiebeheer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import nl.rsvier.icaras.core.arbeidsmarkt.Arbeidsovereenkomst;
import nl.rsvier.icaras.dao.relatiebeheer.IArbeidsovereenkomstDao;
@Service("IArbeidsovereenkomstService")
@Transactional
//@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ArbeidsovereenkomstService implements IArbeidsovereenkomstService {

	@Autowired
	private IArbeidsovereenkomstDao arbeidsovereenkomstDao;
	@Override
	public Arbeidsovereenkomst getById(int id) {
		return arbeidsovereenkomstDao.getById(id);
	}

	@Override
	public List<Arbeidsovereenkomst> getAll() {
		return arbeidsovereenkomstDao.getAll();
	}

}
