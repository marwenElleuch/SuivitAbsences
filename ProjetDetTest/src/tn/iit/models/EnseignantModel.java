package tn.iit.models;

import java.io.Serializable;

public class EnseignantModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String cin;
	private String nom;
	private String prenom;
	private String email;
	private long tel;
	private String grade;
	// private Seance seance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", tel=" + tel + ", grade=" + grade + "]";
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
		EnseignantModel other = (EnseignantModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
