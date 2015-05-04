package nl.rsvier.icaras.refactor.dao;

import java.util.List;

import nl.rsvier.icaras.dao.IGenericDao;
import nl.rsvier.icaras.refactor.core.Relatie;


public interface IRelatieDao extends IGenericDao<Relatie> {
	
	/**
	 * @return lijst met alle relaties in db, in elke relatie is ook de
	 *         adreslijst geinstantieerd
	 */
	public List<Relatie> getAllMetAdressen();
	//TODO methodeNaam aanpassen Adressen wordt Adreslijst
	//ook voor onderstaande methode en dus bijbehorende 
	// implementatie en ook in servicelaag
	/**
	 * @return Relatie uit database met geinitialiseerde adressenlijst
	 * @param de id van de op te vragen relatie
	 */
	public Relatie getByIdMetAdres(int id);

}
