package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.dao.GenericDaoImpl;

@Repository("IPersoonDao")
public class PersoonDaoImpl extends GenericDaoImpl<Persoon> implements
		IPersoonDao {

	public PersoonDaoImpl() {
		super(Persoon.class);
	}

	public List<Persoon> search(String voornaam, String achternaam) {
		String sql = "SELECT p FROM Persoon p WHERE p.voornaam = :voornaam AND p.achternaam = :achternaam";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("voornaam", voornaam)
				.setParameter("achternaam", achternaam);
		if (query.list().isEmpty()) {
			return null;
		}
		return query.list();
	}

	public List<Persoon> searchFull(String voornaamAchternaam) {
		String va = voornaamAchternaam;
		String part1 = null;
		String part2 = null;
		boolean isSplit = false;

		if (va.contains(",")) {
			String[] parts = va.split(",");
			part1 = parts[0];
			part2 = parts[1];
			isSplit = true;
		} else if (va.contains(" ")) {
			String[] parts = va.split(" ");
			part1 = parts[0];
			part2 = parts[1];
			isSplit = true;
		}
		
		if(!isSplit) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.achternaam like :achternaam";
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql).setParameter("voornaam", va.trim() + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2).setParameter("achternaam", va.trim() + "%");
			if (query.list().isEmpty() && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return null;
			}
			
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				for (Object p: query2.list()) {
					if (!query.list().contains(p)) {
						query.list().add(p);
					}
				}
				return query.list();
			}
		}
		
		
		if (isSplit) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.achternaam like :achternaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.achternaam like :achternaam";
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql).setParameter("voornaam", part1.trim() + "%")
					.setParameter("achternaam", part2.trim() + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2).setParameter("voornaam", part2.trim() + "%")
					.setParameter("achternaam", part1.trim() + "%");
			if (query.list().isEmpty() && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return null;
			}
			
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				for (Object p: query2.list()) {
					if (!query.list().contains(p)) {
						query.list().add(p);
					}
				}
				return query.list();
			}
		}
		return null;
	}
}
