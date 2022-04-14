package model;

import javax.persistence.Entity;

@Entity
public class Societa {
	
	private String ragioneSociale;
	
	private String sede;
	
	private Integer telefono;

	public Societa() {
		
	}

	public Societa(String ragioneSociale, String sede, Integer telefono) {
		this.ragioneSociale = ragioneSociale;
		this.sede = sede;
		this.telefono = telefono;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

}
