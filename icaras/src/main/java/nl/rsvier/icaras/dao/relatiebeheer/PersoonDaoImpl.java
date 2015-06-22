package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.ArrayList;
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
		String va = voornaamAchternaam.trim();
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
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				List<Persoon> returnList = new ArrayList<Persoon>();
				returnList.addAll(query.list());
				for (Object p: query2.list()) {
					if (!returnList.contains(p)) {
						returnList.add((Persoon) p);
					}
				}
				return returnList;
			}
		
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if (query.list().isEmpty() && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return null;
			}
		}
		
		if (isSplit) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.achternaam like :achternaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.achternaam like :achternaam";
			String sql3 = "SELECT p FROM Persoon p WHERE p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql).setParameter("voornaam", part1.trim() + "%")
					.setParameter("achternaam", part2.trim() + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2).setParameter("voornaam", part2.trim() + "%")
					.setParameter("achternaam", part1.trim() + "%");
			Query query3 = getSessionFactory().getCurrentSession()
					.createQuery(sql2).setParameter("tussenvoegsel", part1.trim() + "%")
					.setParameter("achternaam", part2.trim() + "%");
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				List<Persoon> returnList = new ArrayList<Persoon>();
				returnList.addAll(query.list());
				for (Object p: query2.list()) {
					if (!returnList.contains(p)) {
						returnList.add((Persoon) p);
					}
				}
				return returnList;
			}
			
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if (query.list().isEmpty() && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return null;
			}
		}
		return null;
	}
	
	public List<Persoon> searchFullDeluxe(String voornaamAchternaam) {
		String va = voornaamAchternaam.trim();
		String[] parts = null;
		List<Persoon> returnList = new ArrayList<Persoon>();

		if (va.contains(",")) {
			parts = va.split(",");
		} else if (va.contains(" ")) {
			parts = va.split(" ");
		} 
		
		if(parts == null) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.achternaam like :achternaam";
			
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql)
					.setParameter("voornaam", va.trim() + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2)
					.setParameter("achternaam", va.trim() + "%");
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				returnList = new ArrayList<Persoon>();
				returnList.addAll(query.list());
				for (Object p: query2.list()) {
					if (!returnList.contains(p)) {
						returnList.add((Persoon) p);
					}
				}
				return returnList;
			}
		
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if (query.list().isEmpty() && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return returnList;
			}
		}
		
		if (parts != null && parts.length == 2) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.achternaam like :achternaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.achternaam like :achternaam";
			String sql3 = "SELECT p FROM Persoon p WHERE p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql)
					.setParameter("voornaam", parts[0].trim() + "%")
					.setParameter("achternaam", parts[1].trim() + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2)
					.setParameter("voornaam", parts[1].trim() + "%")
					.setParameter("achternaam", parts[0].trim() + "%");
			Query query3 = getSessionFactory().getCurrentSession()
					.createQuery(sql3)
					.setParameter("tussenvoegsel", parts[0].trim() + "%")
					.setParameter("achternaam", parts[1].trim() + "%");
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				
				returnList.addAll(query.list());
				for (Object p: query2.list()) {
					if (!returnList.contains(p)) {
						returnList.add((Persoon) p);
					}
				}
				return returnList;
			}
			
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if (!(query3.list().isEmpty())){
				return query3.list();
			}
			
			if (query.list().isEmpty() && query2.list().isEmpty() && query3.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return returnList;
			}
		}
		
		if (parts != null && parts.length == 3) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql3 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.achternaam like :achternaam";
			
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql)
					.setParameter("voornaam", parts[0].trim() + "%")
					.setParameter("tussenvoegsel", parts[1].trim() + "%")
					.setParameter("achternaam", parts[2].trim() + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2)
					.setParameter("tussenvoegsel", parts[0].trim().concat(" ").concat(parts[1].trim()) + "%")
					.setParameter("achternaam", parts[2].trim() + "%");
			Query query3 = getSessionFactory().getCurrentSession()
					.createQuery(sql3)
					.setParameter("voornaam", parts[0].trim().concat(" ").concat(parts[1].trim()) + "%")
					.setParameter("achternaam", parts[2].trim() + "%");
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				returnList.addAll(query.list());
				for (Object p: query2.list()) {
					if (!returnList.contains(p)) {
						returnList.add((Persoon) p);
					}
				}
				return returnList;
			}
			
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if (!(query3.list().isEmpty())){
				return query3.list();
			}

			if (query.list().isEmpty() && query2.list().isEmpty() && query3.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return returnList;
			}
		}
		
		if (parts != null && parts.length == 4) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql3 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql4 = "SELECT p FROM Persoon p WHERE p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql)
					.setParameter("voornaam", parts[0].trim().concat(" ").concat(parts[1].trim()) + "%")
					.setParameter("tussenvoegsel", parts[2].trim() + "%")
					.setParameter("achternaam", parts[3].trim() + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2)
					.setParameter("voornaam", parts[0].trim() + "%")
					.setParameter("tussenvoegsel", parts[1].trim().concat(" ").concat(parts[2].trim()) + "%")
					.setParameter("achternaam", parts[3].trim() + "%");
			Query query3 = getSessionFactory().getCurrentSession()
					.createQuery(sql3)
					.setParameter("voornaam", parts[0].trim() + "%")
					.setParameter("tussenvoegsel", parts[1].trim() + "%")
					.setParameter("achternaam", parts[2].trim().concat(" ").concat(parts[3].trim()) + "%");
			Query query4 = getSessionFactory().getCurrentSession()
					.createQuery(sql4)
					.setParameter("tussenvoegsel", parts[0].trim().concat(" ").concat(parts[1].trim()).concat(" ").concat(parts[2].trim()) + "%")
					.setParameter("achternaam", parts[3].trim() + "%");
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				
				returnList.addAll(query.list());
				for (Object p: query2.list()) {
					if (!returnList.contains(p)) {
						returnList.add((Persoon) p);
					}
				}
				return returnList;
			}
			
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if (!(query3.list().isEmpty())){
				return query3.list();
			}
			
			if (!(query4.list().isEmpty())){
				return query4.list();
			}
			
			if (query.list().isEmpty() && query2.list().isEmpty() && query3.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return returnList;
			}
		}
		
		if (parts != null && parts.length == 5) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql3 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql4 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql)
					.setParameter("voornaam", parts[0].trim().concat(" ").concat(parts[1].trim()) + "%")
					.setParameter("tussenvoegsel", parts[2].trim().concat(" ").concat(parts[3].trim()) + "%")
					.setParameter("achternaam", parts[4].trim() + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2)
					.setParameter("voornaam", parts[0].trim().concat(" ").concat(parts[1].trim()) + "%")
					.setParameter("tussenvoegsel", parts[2].trim() + "%")
					.setParameter("achternaam", parts[3].trim().concat(" ").concat(parts[4].trim()) + "%");
			Query query3 = getSessionFactory().getCurrentSession()
					.createQuery(sql3)
					.setParameter("voornaam", parts[0].trim() + "%")
					.setParameter("tussenvoegsel", parts[1].trim().concat(" ").concat(parts[2].trim()) + "%")
					.setParameter("achternaam", parts[3].trim().concat(" ").concat(parts[4].trim()) + "%");
			Query query4 = getSessionFactory().getCurrentSession()
					.createQuery(sql4)
					.setParameter("voornaam", parts[0].trim() + "%")
					.setParameter("tussenvoegsel", parts[1].trim().concat(" ").concat(parts[2].trim()).concat(" ").concat(parts[3].trim()) + "%")
					.setParameter("achternaam", parts[4].trim() + "%");
			
			if(!(query.list().isEmpty() && query2.list().isEmpty())) {
				
				returnList.addAll(query.list());
				for (Object p: query2.list()) {
					if (!returnList.contains(p)) {
						returnList.add((Persoon) p);
					}
				}
				return returnList;
			}
			
			if (!(query.list().isEmpty()) && query2.list().isEmpty()) {
				System.out.println("SEARCHFULL query2 is leeg");
				return query.list();
			}
			
			if (query.list().isEmpty() && !(query2.list().isEmpty())) {
				System.out.println("SEARCHFULL query1 is leeg");
				return query2.list();
			}
			
			if (!(query3.list().isEmpty())){
				return query3.list();
			}
			
			if (!(query4.list().isEmpty())){
				return query4.list();
			}
			
			if (query.list().isEmpty() && query2.list().isEmpty() && query3.list().isEmpty()) {
				System.out.println("SEARCHFULL BEIDE QUERIES NULL");
				return returnList;
			}
		}
		
		if (parts != null && parts.length == 6) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql2 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			String sql3 = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql)
					.setParameter("voornaam", parts[0].trim().concat(" ").concat(parts[1].trim()) + "%")
					.setParameter("tussenvoegsel", parts[2].trim().concat(" ").concat(parts[3].trim()) + "%")
					.setParameter("achternaam", parts[4].trim().concat(" ").concat(parts[5].trim()) + "%");
			Query query2 = getSessionFactory().getCurrentSession()
					.createQuery(sql2)
					.setParameter("voornaam", parts[0].trim() + "%")
					.setParameter("tussenvoegsel", parts[1].trim().concat(" ").concat(parts[2].trim()).concat(" ").concat(parts[3].trim()) + "%")
					.setParameter("achternaam", parts[4].trim().concat(" ").concat(parts[5].trim()) + "%");
			Query query3 = getSessionFactory().getCurrentSession()
					.createQuery(sql3)
					.setParameter("voornaam", parts[0].trim().concat(" ").concat(parts[1].trim()) + "%")
					.setParameter("tussenvoegsel", parts[2].trim().concat(" ").concat(parts[3].trim()).concat(" ").concat(parts[4].trim()) + "%")
					.setParameter("achternaam", parts[5].trim() + "%");
			
			
			if (!(query.list().isEmpty())) {
				return query.list();
			}
			
			if (!(query2.list().isEmpty())) {
				return query2.list();
			}
			
			if (!(query3.list().isEmpty())) {
				return query3.list();
			}
			
			if (query.list().isEmpty()) {
				return returnList;
			}
		}	
		
		if (parts != null && parts.length == 7) {
			String sql = "SELECT p FROM Persoon p WHERE p.voornaam like :voornaam AND p.tussenvoegsel like :tussenvoegsel AND p.achternaam like :achternaam";
			
			Query query = getSessionFactory().getCurrentSession()
					.createQuery(sql)
					.setParameter("voornaam", parts[0].trim().concat(" ").concat(parts[1].trim()) + "%")
					.setParameter("tussenvoegsel", parts[2].trim().concat(" ").concat(parts[3].trim()).concat(" ").concat(parts[4].trim()) + "%")
					.setParameter("achternaam", parts[5].trim().concat(" ").concat(parts[6].trim()) + "%");	
			
			if (!(query.list().isEmpty())) {
				return query.list();
			}
		}
		return returnList;
	}
}
