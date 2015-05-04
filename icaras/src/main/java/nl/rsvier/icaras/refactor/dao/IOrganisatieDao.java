package nl.rsvier.icaras.refactor.dao;

import java.util.List;

import nl.rsvier.icaras.dao.IGenericDao;
import nl.rsvier.icaras.refactor.core.Organisatie;

public interface IOrganisatieDao extends IGenericDao<Organisatie> {

	public Organisatie getByIdMetAdressenEnNfaLijst(int id);
	
	/**
	 * initialiseert ook de lijst met contactpersonen
	 */
	public Organisatie getByIdMetRollen(int id);

	/**
	 * 
	 * @param id
	 *            De id van de op te vragen Organisatie
	 * @return Organisatie met Rollen, adressen en Nfalijst
	 */
	public Organisatie getByIdCompleet(int id);
	
	public List<Organisatie> getAllMetAdressenenNfaLijst();

	/**
	 * initialiseert ook de lijst met contactpersonen
	 */
	public List<Organisatie> getAllMetRollen();
	
	/**
	 * 
	 * @return Lijst met alle Organisatie-instanties uit de database met Rollen,
	 *         adressen en Nfalijst
	 */
	public List<Organisatie> getAllCompleet();
	
	public List<Organisatie> getAllMetBedrijfsrol();
}
