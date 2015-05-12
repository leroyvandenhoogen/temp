package nl.rsvier.icaras.refactor.dao;

import nl.rsvier.icaras.dao.GenericDaoImpl;
import nl.rsvier.icaras.refactor.core.Adres;

import org.springframework.stereotype.Repository;

@Repository("IAdresDao")//Deze annotatie zorgt ook voor (aanmelding voor) translatie van exceptions naar Spring
public class AdresDaoHibernate extends GenericDaoImpl<Adres> implements IAdresDao {

	public AdresDaoHibernate() {
		super(Adres.class);
	}
}
