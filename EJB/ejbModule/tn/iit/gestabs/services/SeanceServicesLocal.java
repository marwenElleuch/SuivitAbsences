package tn.iit.gestabs.services;

import java.util.List;
import javax.ejb.Local;

import tn.iit.gestabs.entites.Seance;

@Local
public interface SeanceServicesLocal {
	List<Seance> getAll();

	Seance getById(long id);

	void add(Seance s);

	void delete(long id);

	void modifier(Seance s);

	List<Seance> getByDate(String date);
}
