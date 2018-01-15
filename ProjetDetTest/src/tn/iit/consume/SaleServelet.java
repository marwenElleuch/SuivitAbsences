package tn.iit.consume;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.models.DepartementModel;
import tn.iit.models.EnseignantModel;
import tn.iit.models.MatiereModel;
import tn.iit.models.NiveauModel;
import tn.iit.models.SalleModel;
import tn.iit.models.SeanceModel;
import tn.iit.util.DeleteEntity;
import tn.iit.util.GetEntity;
import tn.iit.util.Util;

/**
 * Servlet implementation class SaleServelet
 */

@WebServlet("/salle")
// @SessionScoped
public class SaleServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void method(HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("new method");
		// System.out.println(GetEntity.get(Salle.class,
		// "http://localhost:8080/Service/salle/get/1"));
		// System.out.println("type de retour :" + salle.getById((long)
		// 1).getClass().getTypeName() + "************");
		// response.getWriter().append(salle.getById((long) 1).toString());

		// try {
		// System.out.println("niveau id ");
		// System.out.println(GetEntity.getNiveau((long) 2));
		// } catch (IOException e) {
		// e.printStackTrace();
		// System.out.println(e.getMessage());
		// }

		try {
			System.out.println("salle id 2");
			System.out.println(GetEntity.getSalle((long) 2));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("************************");

		// try {
		// System.out.println("liste de tt les salle");
		// List<SalleModel> salles = GetEntity.getListSalle();
		// for (SalleModel s : salles) {
		// System.out.println(s);
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// System.out.println(e.getMessage());
		// }

		System.out.println("************************");
		try {
			System.out.println("departement id 1");
			System.out.println();
			DepartementModel one = GetEntity.getDepartement((long) 2);
			if (one != null) {
				response.getWriter().append(one.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		System.out.println("************************");
		try {
			System.out.println("liste de tt les departement");
			List<DepartementModel> salles = GetEntity.getListDepartement();
			for (DepartementModel s : salles) {
				// System.out.println(s);
				response.getWriter().append(s.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at:").append(request.getContextPath()).append("");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action == null) {
			session.setAttribute("salleArray", GetEntity.getListSalle());
			response.sendRedirect("salle.jsp");
		
		} else if ("editForm".equals(action)) {
			long id = Long.parseLong(request.getParameter("id"));
			session.setAttribute("salle", GetEntity.getSalle(id));
			response.sendRedirect("updateFormSalle.jsp");
		} else if ("update".equals(action)) {
			System.out.println("passed to update action **********");
			long id = Long.parseLong(request.getParameter("id"));
			// do the update action

		} else if ("delete".equals(action)) {
			long id = Long.parseLong(request.getParameter("id"));
			// do the delete action
			System.out.println(id+"to delete");
			DeleteEntity.deleteSalle(id);
			response.sendRedirect("salle.jsp");
			
		} else if ("form".equals(action)) {
			response.sendRedirect("AddNewSalle.jsp");
			
		} else if ("ajouter".equals(action)) {
			// do the add action
			String nom = request.getParameter("nom");
			SalleModel salle = new SalleModel();
			salle.setNom(nom);
			response.sendRedirect("salle.jsp");
		}
		
		
	}// do get

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public SaleServelet() {
		super();
	}
}
