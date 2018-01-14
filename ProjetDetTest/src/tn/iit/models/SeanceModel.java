package tn.iit.models;

import java.io.Serializable;
import java.util.Date;

public class SeanceModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private Date dateSeance;
	private int heureDebut;
	private int heureFin;
	private SalleModel salle;
	private NiveauModel niveau;
	private MatiereModel matiere;
	private EnseignantModel enseignant;
	private DepartementModel departement;

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

	public SalleModel getSalle() {
		return salle;
	}

	public void setSalle(SalleModel salle) {
		this.salle = salle;
	}

	public NiveauModel getNiveau() {
		return niveau;
	}

	public void setNiveau(NiveauModel niveau) {
		this.niveau = niveau;
	}

	public MatiereModel getMatiere() {
		return matiere;
	}

	public void setMatiere(MatiereModel matiere) {
		this.matiere = matiere;
	}

	public EnseignantModel getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(EnseignantModel enseignant) {
		this.enseignant = enseignant;
	}

	public DepartementModel getDepartement() {
		return departement;
	}

	public void setDepartement(DepartementModel departement) {
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
		SeanceModel other = (SeanceModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seance [id=" + id + ", dateSeance=" + dateSeance + ", heureDebut=" + heureDebut + ", heureFin="
				+ heureFin + ",\n+++" + salle.toString() + ",\n+++" + niveau.toString() + ",\n+++" + matiere.toString()
				+ ",\n+++" + enseignant.toString() + ",\n+++" + departement.toString() + "]***";
	}

}
