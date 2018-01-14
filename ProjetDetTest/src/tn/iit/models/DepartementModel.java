package tn.iit.models;

import java.io.Serializable;

public class DepartementModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	// private Seance seance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + "]";
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
		DepartementModel other = (DepartementModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

}