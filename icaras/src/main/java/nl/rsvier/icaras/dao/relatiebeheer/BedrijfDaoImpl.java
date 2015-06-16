package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("IBedrijfDao")
public class BedrijfDaoImpl extends GenericDaoImpl<Bedrijf> implements IBedrijfDao {

	public BedrijfDaoImpl() {
		super(Bedrijf.class);
	}

	public List<Bedrijf> search(String naam) {
		String sql = "SELECT p FROM Bedrijf p WHERE p.naam like :naam";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql).setParameter("naam", naam.trim() +"%");
		if(query.list().isEmpty()) {
			return null;
		}		
		return query.list();
	}
	
}
