package nl.rsvier.icaras.refactor.service;

import java.util.List;

import nl.rsvier.icaras.refactor.core.Aanbieding;

public interface IAanbiedingService {

	public Aanbieding getById(int id);

	public List<Aanbieding> getAll();
}
