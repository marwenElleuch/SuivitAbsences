package tn.iit.gestabs.entites;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date dateSeance;
	private int heureDebut;
	private int heureFin;

	@OneToOne
	@JoinColumn(name = "id_salle")
	private Salle salle;

	@OneToOne
	@JoinColumn(name = "id_niveux")
	private Niveau niveau;

	@OneToOne
	@JoinColumn(name = "id_matiere")
	private Matiere matiere;

	@OneToOne
	@JoinColumn(name = "id_enseignant")
	private Enseignant enseignant;

	@OneToOne
	@JoinColumn(name = "id_dept")
	private Departement departement;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}

	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
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
		Seance other = (Seance) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seance [id=" + id + ", dateSeance=" + dateSeance + ", heureDebut=" + heureDebut + ", heureFin="
				+ heureFin + ",\n" + salle.toString() + ",\n" + niveau.toString() + ",\n"
				+ matiere.toString() + ",\n" + enseignant.toString() + ",\n"
				+ departement.toString() + "\n]***";
	}

}
