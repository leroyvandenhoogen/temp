package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.ArrayList;
import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("IBedrijfDao")
public class BedrijfDaoImpl extends GenericDaoImpl<Bedrijf> implements
		IBedrijfDao {

	private String[] parts;
	List<Bedrijf> bedrijfLijst;
	List<Bedrijf> adresLijst;
	List<Bedrijf> returnLijst;
	List<Bedrijf> mergeLijst1;
	List<Bedrijf> mergeLijst2;

	public BedrijfDaoImpl() {
		super(Bedrijf.class);
	}

	public List<Bedrijf> search(String string) {
		bedrijfLijst = queryNaam(string.trim());
		adresLijst = queryPlaats(string.trim());
		if (bedrijfLijst != null && adresLijst != null) {
			return mergeLists(bedrijfLijst, adresLijst);
		} else if (bedrijfLijst != null && adresLijst == null) {
			return bedrijfLijst;
		} else if (bedrijfLijst == null && adresLijst != null) {
			return adresLijst;
		}

		if (!isSplit(string))
			return null;

		parts = split(string);

		if (parts.length == 2)
			mergeLijst1 = queryNaamPlaats(parts[0], parts[1]);
			mergeLijst2 = queryNaamPlaats(parts[1], parts[0]);
			return mergeLists(mergeLijst1, mergeLijst2);
	}

	private List<Bedrijf> mergeLists(List<Bedrijf> lijst1, List<Bedrijf> lijst2) {
		if (lijst1 != null && lijst2 != null) {
			for (Bedrijf b : lijst2) {
				if (!lijst1.contains(b))
					lijst1.add(b);
			}
			return lijst1;
		} else if (lijst1 != null && lijst2 == null)
			return lijst1;
		else if (lijst1 == null && lijst2 != null)
			return lijst2;
		else
			return null;
	}

	private List<Bedrijf> queryNaamPlaats(String string1, String string2) {
		String sql = "select p from Bedrijf p, Adres a WHERE a.bedrijf.id = p.id AND p.naam like :string1 AND a.plaats like :string2";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string1", string1.trim() + "%").setParameter("string2", string2.trim() + "%");
	if (query.list().isEmpty())
		return null;
	return query.list();
	}

	private List<Bedrijf> queryNaam(String string) {
		String sql = "SELECT p FROM Bedrijf p WHERE p.naam like :string";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string", string.trim() + "%");
		if (query.list().isEmpty()) {
			return null;
		}
		return query.list();
	}

	private List<Bedrijf> queryPlaats(String string) {
		String sql = "SELECT p FROM Adres p WHERE p.plaats like :string AND p.bedrijf is not null";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string", string.trim() + "%");
		if (query.list().isEmpty()) {
			return null;
		} else {
			List<Bedrijf> lijst = new ArrayList<>();
			for (Object adres : query.list()) {
				lijst.add(((Adres) adres).getBedrijf());
			}
			return lijst;
		}
	}

	public String[] split(String string) {
		parts = string.trim().split("[ ,]");
		return parts;
	}

	private boolean isSplit(String string) {
		if (string.trim().contains(",") || string.trim().contains(" "))
			return true;
		return false;
	}

}
