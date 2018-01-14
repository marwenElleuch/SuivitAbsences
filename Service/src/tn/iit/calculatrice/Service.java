package tn.iit.calculatrice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.iit.gestabs.entites.Salle;
import tn.iit.gestabs.services.SalleServicesLocal;

@Stateless
@LocalBean
@Path("/Services")
public class Service {
	@EJB
	private CalculetteLocal calcul;
	@EJB 
	private SalleServicesLocal s;
	

	public Service() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Path("/{a}/{b}")
	@Produces(MediaType.APPLICATION_JSON)
	public double add(@PathParam("a") double a, @PathParam("b") double b) {
		return calcul.add(a, b);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Salle> get() {
		return s.getAll();
	}
	
	
}
