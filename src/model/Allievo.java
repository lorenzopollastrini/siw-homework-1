package model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {
	
	private String nome;
	
	private String cognome;
	
	private LocalDate dataDiNascita;
	
	private String luogoDiNascita;
	
	@Id
	private Integer matricola;
	
	private String email;
	
	/*
	 * Motivo del fetch: non è detto che quando si prende un allievo si voglia conoscere la società per cui lavora.
	 * Nessuna cascade. Motivo: altrimenti si persisterebbero o rimuoverebbero società esistenti.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Societa societa;
	
	/*
	 * Fetch: LAZY (default). Motivo: non è detto che quando si prende un allievo si voglia conoscere i corsi a cui è iscritto.
	 * Nessuna cascade. Motivo: altrimenti si persisterebbero o rimuoverebbero corsi esistenti.
	 */
	@ManyToMany
	private Set<Corso> corsi;

	public Allievo() {
		
	}

	public Allievo(String nome, String cognome, LocalDate dataDiNascita, String luogoDiNascita, Integer matricola,
			String email, Societa societa, Set<Corso> corsi) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
		this.matricola = matricola;
		this.email = email;
		this.societa = societa;
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

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public Set<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricola);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Allievo other = (Allievo) obj;
		return Objects.equals(matricola, other.matricola);
	}

}
