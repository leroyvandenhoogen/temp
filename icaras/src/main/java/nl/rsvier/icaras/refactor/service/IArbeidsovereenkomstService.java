package nl.rsvier.icaras.refactor.service;

import java.util.List;

import nl.rsvier.icaras.refactor.core.Arbeidsovereenkomst;

public interface IArbeidsovereenkomstService {

	public Arbeidsovereenkomst getById(int id);

	public List<Arbeidsovereenkomst> getAll();
}
