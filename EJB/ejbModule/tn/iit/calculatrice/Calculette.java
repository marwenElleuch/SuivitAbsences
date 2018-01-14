package tn.iit.calculatrice;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class Calculette implements CalculetteLocal {

    public Calculette() { }

	@Override
	public double add(double a, double b) {
		return a+b;
	}

}
