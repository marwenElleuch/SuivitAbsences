package tn.iit.calculatrice;

import javax.ejb.Local;

@Local
public interface CalculetteLocal {
	double add(double a,double b);
}
