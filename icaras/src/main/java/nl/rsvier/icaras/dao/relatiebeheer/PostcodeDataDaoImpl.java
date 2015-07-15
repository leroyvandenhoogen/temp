package nl.rsvier.icaras.dao.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.PostcodeData;
import nl.rsvier.icaras.dao.GenericDaoImpl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("IPostcodeDataDao")
public class PostcodeDataDaoImpl extends GenericDaoImpl<PostcodeData> implements
		IPostcodeDataDao {

	public PostcodeDataDaoImpl() {
		super(PostcodeData.class);
	}

	@Override
	public Adres zoekAdres(String postcode) {
		List<PostcodeData> pDataLijst = zoekAdressen(postcode);
		Adres adres = new Adres();
		PostcodeData pData = pDataLijst.get(0);
		adres.setPostcode(pData.getPostcode());
		adres.setPlaats(pData.getStad());
		adres.setProvincie(pData.getProvincie());
		adres.setStraat(pData.getStraat());

		return adres;

	}

	public Adres zoekAdres(String postcode, int nummer) {
		String type = "even";
		if (nummer % 2 == 1)
			type = "odd";

		List<PostcodeData> pDataLijst = zoekAdressen(postcode);
		for (PostcodeData pData : pDataLijst) {
			if ((pData.getNummertype().equals("mixed") || pData.getNummertype()
					.equals(type))
					&& pData.getMinnumber() <= nummer
					&& pData.getMaxnumber() >= nummer) {
				Adres adres = new Adres();
				adres.setPostcode(pData.getPostcode());
				adres.setPlaats(pData.getStad());
				adres.setProvincie(pData.getProvincie());
				adres.setStraat(pData.getStraat());
				return adres;
			}

		}
		return null;
	}

	public PostcodeData zoekPostcodeData(String postcode) {
		List<PostcodeData> pDataLijst = zoekAdressen(postcode);

		return pDataLijst.get(0);
	}

	public PostcodeData zoekPostcodeData(String postcode, int nummer) {
		String type = "even";
		if (nummer % 2 == 1)
			type = "odd";

		List<PostcodeData> pDataLijst = zoekAdressen(postcode);
		for (PostcodeData pData : pDataLijst) {
			if ((pData.getNummertype().equals("mixed") || pData.getNummertype()
					.equals(type))
					&& pData.getMinnumber() <= nummer
					&& pData.getMaxnumber() >= nummer)
				return pData;
		}

		return null;
	}

	private List<PostcodeData> zoekAdressen(String postcode) {
		String sql = "SELECT p FROM PostcodeData p WHERE p.postcode like :string";
		Query query = getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("string", postcode.trim());

		if (query.list().isEmpty()) {
			return null;
		}
		return query.list();
	}
}
