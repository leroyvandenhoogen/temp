package nl.rsvier.icaras.refactor.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import nl.rsvier.icaras.refactor.core.Aanbieding;
import nl.rsvier.icaras.refactor.core.Arbeidsovereenkomst;
import nl.rsvier.icaras.refactor.core.Contactpersoon;
import nl.rsvier.icaras.refactor.core.Kandidaat;
import nl.rsvier.icaras.refactor.core.Organisatie;
import nl.rsvier.icaras.refactor.core.Persoon;
import nl.rsvier.icaras.refactor.core.Werknemer;
import nl.rsvier.icaras.refactor.dao.IPersoonDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("IPersoonService")
@Transactional
@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class PersoonService implements IPersoonService {

	@Autowired
	IPersoonDao persoonDao;

	@Override
	public void save(Persoon persoon) {
		persoonDao.save(persoon);
	}

	@Override
	public void delete(Persoon persoon) {
		persoon = getByIdCompleet(persoon.getId());
		if (persoon.heeftRol(Werknemer.class)) {
			HashSet<Arbeidsovereenkomst> arbeidsovereenkomsten = new HashSet<Arbeidsovereenkomst>();
			arbeidsovereenkomsten.addAll(persoon.getWerknemer()
					.getArbeidsovereenkomsten());
			for (Arbeidsovereenkomst ao : arbeidsovereenkomsten) {
				persoon.getWerknemer().removeArbeidsovereenkomst(ao);
			}
		}
		if (persoon.heeftRol(Kandidaat.class)) {
			HashSet<Aanbieding> aanbiedingen = new HashSet<Aanbieding>();
			aanbiedingen.addAll(persoon.getKandidaat().getAanbiedingen());
			for (Aanbieding a : aanbiedingen) {
				persoon.getKandidaat().removeAanbieding(a);
			}
		}
		if (persoon.heeftRol(Contactpersoon.class)) {
			List<Organisatie> organisaties = new ArrayList<Organisatie>();
			organisaties.addAll(persoon.getContactpersoon().getOrganisaties());
			for (Organisatie o : organisaties) {
				o.removeContactpersoon(persoon);
			}
		}
		persoonDao.delete(persoon);
	}

	@Override
	public void update(Persoon persoon) {
		// controleren of er aanbiedingen etc zijn die afwijken van de db?
		// Methode saveAanbieding en saveArbeidsovereenkomst ect maken hiervoor?
		persoonDao.update(persoon);
	}

	@Override
	public Persoon getById(int id) {
		return persoonDao.getById(id);
	}

	@Override
	public Persoon getByIdMetAdressenEnNfaLijst(int id) {
		return persoonDao.getByIdMetAdressenEnNfaLijst(id);
	}

	@Override
	public Persoon getByIdMetRollen(int id) {
		return persoonDao.getByIdMetRollen(id);
	}

	@Override
	public Persoon getByIdCompleet(int id) {
		return persoonDao.getByIdCompleet(id);
	}

	@Override
	public List<Persoon> getAll() {
		return persoonDao.getAll();
	}

	@Override
	public List<Persoon> getAllMetAdressenEnNfaLijst() {
		return persoonDao.getAllMetAdressenEnNfaLijst();
	}

	@Override
	public List<Persoon> getAllMetRollen() {
		return persoonDao.getAllMetRollen();
	}

	@Override
	public List<Persoon> getAllCompleet() {
		return persoonDao.getAllCompleet();
	}

	public List<Persoon> getAllMetKandidaat() {
		return persoonDao.getAllMetKandidaat();
	}

	public List<Persoon> getAllMetWerknemerEnKandidaat() {
		return persoonDao.getAllMetWerknemerEnKandidaat();
	}

	public List<Persoon> getAllMetContactPersoon() {
		return persoonDao.getAllMetContactPersoon();
	}
}
