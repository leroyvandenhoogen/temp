package nl.rsvier.icaras.refactor.dao;

import java.util.List;

import nl.rsvier.icaras.dao.IGenericDao;
import nl.rsvier.icaras.refactor.core.Persoon;

public interface IPersoonDao extends IGenericDao<Persoon> {

	public Persoon getByIdMetAdressenEnNfaLijst(int id);
	
	public Persoon getByIdMetRollen(int id);
	
	/**
	 * 
	 * @param id
	 *            De id van de op te vragen Persoon
	 * @return Persoon met Rollen, adressen en Nfalijst
	 */
	public Persoon getByIdCompleet(int id);

	public List<Persoon> getAllMetAdressenEnNfaLijst();
	
	public List<Persoon> getAllMetRollen();

	/**
	 * 
	 * @return Lijst met alle Persoon-instanties uit de database met Rollen,
	 *         adressen en Nfalijst
	 */
	public List<Persoon> getAllCompleet();
	
	public List<Persoon> getAllMetKandidaat();
	
	public List<Persoon> getAllMetWerknemerEnKandidaat();
	
	public List<Persoon> getAllMetContactPersoon();
}
