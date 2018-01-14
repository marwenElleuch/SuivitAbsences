package tn.iit.models;

import java.io.Serializable;

public class MatiereModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	private float coefficient;
//	private Seance seance;

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

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", coefficient=" + coefficient + "]";
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
		MatiereModel other = (MatiereModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
