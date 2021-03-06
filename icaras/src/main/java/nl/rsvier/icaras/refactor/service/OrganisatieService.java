package nl.rsvier.icaras.refactor.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import nl.rsvier.icaras.refactor.core.Aanbieding;
import nl.rsvier.icaras.refactor.core.Arbeidsovereenkomst;
import nl.rsvier.icaras.refactor.core.Bedrijf;
import nl.rsvier.icaras.refactor.core.Kandidaat;
import nl.rsvier.icaras.refactor.core.Organisatie;
import nl.rsvier.icaras.refactor.core.Persoon;
import nl.rsvier.icaras.refactor.core.Vacature;
import nl.rsvier.icaras.refactor.dao.IOrganisatieDao;

@Service("IOrganisatieService")
@Transactional
//@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class OrganisatieService implements IOrganisatieService {

	@Autowired
	private IOrganisatieDao organisatieDao;

	@Override
	public void save(Organisatie organisatie) {
		organisatieDao.save(organisatie);
	}

	@Override
	public void delete(Organisatie organisatie) {
		organisatie = this.getByIdCompleet(organisatie.getId());
		// verwijder de bidirectionele relaties met Contactpersoon
		HashSet<Persoon> contactpersonen = new HashSet<Persoon>();
		contactpersonen.addAll(organisatie.getContactpersonen());
		for (Persoon c : contactpersonen) {
			organisatie.removeContactpersoon(c);
		}
		// als de organisatie een bedrijf is worden alle bidirectionele
		// relaties die Bedrijf heeft verwijderd
		if (organisatie.heeftRol(Bedrijf.class)) {
			// Verwijder alle arbeidsovereenkomsten van Bedrijf
			// deze hashSet wordt aangemaakt om ConcurrentModicificationError in
			// for loop
			// te omzeilen
			HashSet<Arbeidsovereenkomst> arbeidsovereenkomsten = new HashSet<Arbeidsovereenkomst>();
			arbeidsovereenkomsten.addAll(organisatie.getBedrijf()
					.getArbeidsovereenkomsten());
			for (Arbeidsovereenkomst a : arbeidsovereenkomsten) {
				organisatie.getBedrijf().removeArbeidsovereenkomst(a);
			}
			// verwijder alle vacatures van bedrijf
			HashSet<Vacature> vacatures = new HashSet<Vacature>();
			vacatures.addAll(organisatie.getBedrijf().getVacatures());
			for (Vacature v : vacatures) {
				organisatie.getBedrijf().removeVacature(v);
			}
			// Verwijder aanbiedingen van Bedrijf
			HashSet<Aanbieding> aanbiedingen = new HashSet<Aanbieding>();
			aanbiedingen.addAll(organisatie.getBedrijf().getAanbiedingen());
			for (Aanbieding a : aanbiedingen) {
				organisatie.getBedrijf().removeAanbieding(a);
			}
			// Verwijder medewerkers van bedrijf
			HashSet<Persoon> medewerkers = new HashSet<Persoon>();
			medewerkers.addAll(organisatie.getBedrijf().getMedewerkers());
			for (Persoon m : medewerkers) {
				organisatie.getBedrijf().removeMedewerker(m);
			}
		}
		// na het verwijderen van alle bidirectionele relaties verwijderen we
		// persoon
		// alle niet bidirectionele relaties van Organisatie worden via
		// OrphanRemove verwijderd
		organisatieDao.delete(organisatie);
	}

	@Override
	public void update(Organisatie organisatie) {
		organisatieDao.update(organisatie);
	}

	@Override
	public Organisatie getById(int id) {
		return organisatieDao.getById(id);
	}

	@Override
	public Organisatie getByIdMetAdressenEnNfaLijst(int id) {
		return organisatieDao.getByIdMetAdressenEnNfaLijst(id);
	}

	@Override
	public Organisatie getByIdMetRollen(int id) {
		return organisatieDao.getByIdMetRollen(id);
	}

	@Override
	public Organisatie getByIdCompleet(int id) {
		return organisatieDao.getByIdCompleet(id);
	}

	@Override
	public List<Organisatie> getAll() {
		return organisatieDao.getAll();
	}

	@Override
	public List<Organisatie> getAllMetAdressenEnNfaLijst() {
		return organisatieDao.getAllMetAdressenenNfaLijst();
	}

	@Override
	public List<Organisatie> getAllMetRollen() {
		return organisatieDao.getAllMetRollen();
	}

	@Override
	public List<Organisatie> getAllCompleet() {
		return organisatieDao.getAllCompleet();
	}

	public List<Organisatie> getAllMetBedrijfsrol() {
		return organisatieDao.getAllMetBedrijfsrol();
	}

	public List<Organisatie> getAllAanTeBiedenOrganisaties(Persoon persoon) {
		List<Organisatie> organisatiesVoorKandidaat = new ArrayList<Organisatie>();
		organisatiesVoorKandidaat.addAll(getAllMetBedrijfsrol());
		if (persoon.heeftRol(Kandidaat.class)) {
			for (Organisatie o : organisatieDao.getAllMetBedrijfsrol()) {
				for (Aanbieding a : persoon.getKandidaat().getAanbiedingen()) {
					if (o.getBedrijf().heeftAanbieding(a)) {
						organisatiesVoorKandidaat.remove(o);
					}
				}
			}
		} else {
			organisatiesVoorKandidaat = organisatieDao.getAllMetBedrijfsrol();
		}
		return organisatiesVoorKandidaat;
	}
}
