package main;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Allievo;
import model.Corso;
import model.Docente;
import model.Indirizzo;
import model.Societa;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("homework-1-unit");
		EntityManager em = emf.createEntityManager();
		
		/* Oggetti di esempio */
		
		Allievo allievo = new Allievo();
		allievo.setNome("Mario");
		allievo.setCognome("Rossi");
		allievo.setDataDiNascita(LocalDate.of(2000, 1, 1));
		allievo.setLuogoDiNascita("Roma");
		allievo.setMatricola(123456);
		allievo.setEmail("mario.rossi@outlook.com");
		
		Set<Allievo> allievi = new HashSet<>();
		allievi.add(allievo);
		
		Societa societa = new Societa();
		societa.setRagioneSociale("Consulenza");
		societa.setTelefono("1234567890");
		
		Indirizzo sede = new Indirizzo();
		sede.setVia("Via Bruxelles");
		sede.setCivico("79");
		sede.setComune("Roma");
		sede.setCap("00100");
		sede.setProvincia("RM");
		
		societa.setSede(sede);
		
		allievo.setSocieta(societa);
		
		Docente docente = new Docente();
		docente.setNome("Paolo");
		docente.setCognome("Bianchi");
		docente.setDataDiNascita(LocalDate.of(1970, 1, 1));
		docente.setPartitaIva(12345678901L);
		
		Corso corso = new Corso();
		corso.setNome("Sistemi Informativi su Web");
		corso.setDataDiInizio(LocalDate.of(2022, 3, 1));
		corso.setDurataInMesi(4);
		
		Set<Corso> corsi = new HashSet<>();
		corsi.add(corso);
		
		corso.setAllievi(allievi);
		allievo.setCorsi(corsi);
		docente.setCorsi(corsi);
		corso.setDocente(docente);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(allievo);
		em.persist(societa);
		em.persist(docente);
		em.persist(corso);
		tx.commit();
		
		em.close();
		emf.close();
	}
	
}
