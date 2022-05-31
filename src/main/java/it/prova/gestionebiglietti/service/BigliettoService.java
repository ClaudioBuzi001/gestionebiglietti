package it.prova.gestionebiglietti.service;

import java.util.List;

import it.prova.gestionebiglietti.dao.BigliettoDAO;
import it.prova.gestionebiglietti.model.Biglietto;

public interface BigliettoService {
	
	public void setBigliettoDAO(BigliettoDAO bigliettoDAO);
	
	//Implemento la firma dei metodi
	public List<Biglietto> listaTutti() throws Exception;
	
	public Biglietto caricaSingoloElemento(Long id) throws Exception;
	
	public void aggiorna(Biglietto input) throws Exception;
	
	public void inserisciNuovo(Biglietto input) throws Exception;
	
	public void rimuovi(Biglietto input) throws Exception;
	
	//TODO findByExample
	public List<Biglietto> trova(Biglietto input) throws Exception ;
}
