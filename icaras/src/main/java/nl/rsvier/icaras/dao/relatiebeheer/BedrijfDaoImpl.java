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
	List<Bedrijf> lijst1;
	List<Bedrijf> lijst2;
	List<Bedrijf> lijst3;
	List<Bedrijf> mergeLijst1;
	List<Bedrijf> mergeLijst2;

	public BedrijfDaoImpl() {
		super(Bedrijf.class);
	}

	public List<Bedrijf> search(String string) {
		lijst1 = queryNaam(string.trim());
		lijst2 = queryPlaats(string.trim());
		lijst3 = queryOpmerking(string.trim());

		if (isNotEmpty(lijst1, lijst2, lijst3)) {
			return merge3Lists(lijst1, lijst2, lijst3);
		}

		if (!isSplit(string))
			return null;

		parts = split(string);

		if (parts.length == 2) {
			lijst1 = queryNaamPlaats(parts[0], parts[1]);
			lijst2 = queryNaamPlaats(parts[1], parts[0]);
			lijst3 = queryNaamOpmerking(parts[0], parts[1]);
			if (isNotEmpty(lijst1, lijst2, lijst3))
				mergeLijst1 = merge3Lists(lijst1, lijst2, lijst3);
			lijst1 = queryNaamOpmerking(parts[1], parts[0]);
			lijst2 = queryOpmerkingPlaats(parts[0], parts[1]);
			lijst2 = queryOpmerkingPlaats(parts[1], parts[0]);
			if (isNotEmpty(lijst1, lijst2, lijst3))
				mergeLijst1 = merge3Lists(lijst1, lijst2, lijst3);
			if (isNotEmpty(mergeLijst1, mergeLijst2))
				return merge2Lists(mergeLijst1, mergeLijst2);
			else return null;
		}
		return null;
	}

	private boolean isNotEmpty(List<Bedrijf> lijst1, List<Bedrijf> lijst2) {
		if (lijst1 != null || lijst2 != null)
			return true;
		return false;
	}

	private boolean isNotEmpty(List<Bedrijf> lijst1, List<Bedrijf> lijst2,
			List<Bedrijf> lijst3) {
		if (lijst1 != null || lijst2 != null || lijst3 != null)
			return true;
		return false;
	}

	private List<Bedrijf> merge3Lists(List<Bedrijf> lijst1,
			List<Bedrijf> lijst2, List<Bedrijf> lijst3) {
		if (lijst1 != null && lijst2 != null && lijst3 != null) {
			for (Bedrijf b : lijst2) {
				if (!lijst1.contains(b))
					lijst1.add(b);
			}
			for (Bedrijf b : lijst3) {
				if (!lijst1.contains(b))
					lijst1.add(b);
			}
			return lijst1;
		} else if (lijst1 == null)
			return merge2Lists(lijst2, lijst3);
		else if (lijst2 == null)
			return merge2Lists(lijst1, lijst3);
		else
			return merge2Lists(lijst1, lijst2);
	}

	private List<Bedrijf> merge2Lists(List<Bedrijf> lijst1, List<Bedrijf> lijst2) {
		if (lijst1 != null && lijst2 != null) {
			for (Bedrijf b : lijst2) {
				if (!lijst1.contains(b))
					lijst1.add(b);
			}
			return lijst1;
		} else if (lijst1 != null)
			return lijst1;
		else
			return lijst2;
	}

	private List<Bedrijf> queryNaamOpmerking(String naam, String opmerking) {
		String sql = "SELECT p FROM Bedrijf p WHERE p.naam like :string1 AND p.opmerking like :string2";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string1", naam.trim() + "%")
				.setParameter("string2", opmerking.trim() + "%");
		if (query.list().isEmpty())
			return null;
		return query.list();
	}

	private List<Bedrijf> queryOpmerkingPlaats(String opmerking, String plaats) {
		String sql = "select p from Bedrijf p, Adres a WHERE a.bedrijf.id = p.id AND p.opmerking like :string1 AND a.plaats like :string2";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string1", opmerking.trim() + "%")
				.setParameter("string2", plaats.trim() + "%");
		if (query.list().isEmpty())
			return null;
		return query.list();
	}

	private List<Bedrijf> queryNaamPlaats(String naam, String plaats) {
		String sql = "select p from Bedrijf p, Adres a WHERE a.bedrijf.id = p.id AND p.naam like :string1 AND a.plaats like :string2";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string1", naam.trim() + "%")
				.setParameter("string2", plaats.trim() + "%");
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

	private List<Bedrijf> queryOpmerking(String string) {
		String sql = "SELECT p FROM Bedrijf p WHERE p.opmerking like :string";
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
