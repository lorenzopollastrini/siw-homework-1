package model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {

	private String nome;
	
	private String cognome;
	
	private LocalDate dataDiNascita;
	
	@Id
	private Long partitaIva;
	
	/*
	 * Fetch: LAZY (default). Motivo: non è detto che quando si prende un docente si vogliano conoscere i suoi corsi.
	 * Nessuna cascade. Motivo: altrimenti si persisterebbero o rimuoverebbero corsi esistenti.
	 */
	@OneToMany(mappedBy = "docente")
	private Set<Corso> corsi;
	
	public Docente() {
		
	}

	public Docente(String nome, String cognome, LocalDate dataDiNascita, Long partitaIva, Set<Corso> corsi) {
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

	public Long getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(Long partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Set<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(partitaIva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docente other = (Docente) obj;
		return Objects.equals(partitaIva, other.partitaIva);
	}
	
}
