package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Docente {

	private String nome;
	
	private String cognome;
	
	private LocalDate dataDiNascita;
	
	private Integer partitaIva;
	
	/*
	 * Fetch: LAZY (default). Motivo: non è detto che quando si prende un docente si vogliano conoscere i suoi corsi.
	 * Nessuna cascade. Motivo: altrimenti si persisterebbero o rimuoverebbero corsi esistenti.
	 */
	@OneToMany(mappedBy = "docente")
	private Set<Corso> corsi;
	
	public Docente() {
		
	}

	public Docente(String nome, String cognome, LocalDate dataDiNascita, Integer partitaIva, Set<Corso> corsi) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.partitaIva = partitaIva;
		this.corsi = corsi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Integer getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(Integer partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Set<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}
	
}
