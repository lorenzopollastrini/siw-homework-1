package model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private LocalDate dataDiInizio;
	
	private Integer durataInMesi;
	
	/* Fetch: LAZY (default). Motivo: non è detto che si vogliano conoscere tutti gli allievi quando si prende un corso.
	 * Nessuna cascade. Motivo: altrimenti si persisterebbero o rimuoverebbero allievi esistenti.
	 */
	@ManyToMany(mappedBy = "corsi")
	private Set<Allievo> allievi;
	
	/*
	 * Motivo del fetch: non è detto che si voglia conoscere il docente quando si prende un corso.
	 * Nessuna cascade. Motivo: altrimenti si persisterebbero o rimuoverebbero docenti esistenti.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Docente docente;
	
	public Corso() {
		
	}

	public Corso(String nome, LocalDate dataDiInizio, Integer durataInMesi, Set<Allievo> allievi, Docente docente) {
		this.nome = nome;
		this.dataDiInizio = dataDiInizio;
		this.durataInMesi = durataInMesi;
		this.allievi = allievi;
		this.docente = docente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDiInizio() {
		return dataDiInizio;
	}

	public void setDataDiInizio(LocalDate dataDiInizio) {
		this.dataDiInizio = dataDiInizio;
	}

	public Integer getDurataInMesi() {
		return durataInMesi;
	}

	public void setDurataInMesi(Integer durataInMesi) {
		this.durataInMesi = durataInMesi;
	}

	public Set<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(Set<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(id, other.id);
	}

}
