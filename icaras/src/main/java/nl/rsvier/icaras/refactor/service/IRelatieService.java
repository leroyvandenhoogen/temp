package nl.rsvier.icaras.refactor.service;

import java.util.List;

import nl.rsvier.icaras.refactor.core.Relatie;


public interface IRelatieService  {
	
	public List<Relatie> getAll();
	
	public void save(Relatie r);
	
	public void update(Relatie r);
	
	public Relatie getById(int id);
	//TODO getAllMetCorrespondentieAdres ipv onderstaande.
	public List<Relatie> getAllMetAdres();	
	
	public Relatie getByIdMetAdres(int id);
}
