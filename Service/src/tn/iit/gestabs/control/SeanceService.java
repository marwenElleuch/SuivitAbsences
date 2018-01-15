package tn.iit.gestabs.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import tn.iit.gestabs.entites.Seance;
import tn.iit.gestabs.services.SeanceServicesLocal;

@Stateless
@LocalBean
@Path("/seance")
public class SeanceService {
	@EJB
	private SeanceServicesLocal services;

	public SeanceService() {}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seance> getAll() {
		return services.getAll();
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void add(Seance seance) {
		System.out.println("this is a salle pased from postman :" + seance.toString());
		services.add(seance);
	}

//	@POST
//	@Path("/ad/{seance}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void add2(Seance seance) {
//		System.out.println("this is a seance pased from postman :" + seance.toString());
//		services.add(seance);
//	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Seance getById(@PathParam("id") Long id) {
		System.out.println(services.getById(id).toString());
		return services.getById(id);
	}

	@GET
	@Path("/byDate/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seance> getByDate(@PathParam("date") String date) {
		return services.getByDate(date);
	}

	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void edit(@PathParam("id") Long id, Seance seance) {
		seance.setId(id);
		services.modifier(seance);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") Long id) {
		services.delete(id);
	}
}
