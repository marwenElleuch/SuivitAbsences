package tn.iit.models;

import java.io.Serializable;

public class NiveauModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String filiere;
	private int annee;
	//private Seance seance;

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Niveau [id=" + id + ", filiere=" + filiere + ", annee=" + annee + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NiveauModel other = (NiveauModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

}