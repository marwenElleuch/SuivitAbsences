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
import tn.iit.util.GetEntity;
import tn.iit.util.Util;

/**
 * Servlet implementation class SeanceServlet
 */
@WebServlet("/SeanceServlet")
public class SeanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeanceServlet() {
		super();
	}

	public List<SeanceModel> onLoad() {
		List<SeanceModel> seances = null;
		try {
			System.out.println("liste de tt les seance");
			seances = GetEntity.getListSeances();
			// System.out.println(seances.size());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return seances;
	}

	public SeanceModel seanceToUpdate(long id) {
		SeanceModel s = null;
		try {
			System.out.println("seance id ");
			s = GetEntity.getSeance(id);
			// System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		// System.out.println("********seanceToUpdate************");
		return s;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("int", 5);
		String action = request.getParameter("action");

		if ("load".equals(action)) {
			session.setAttribute("seanceArray", onLoad());
			response.sendRedirect("seances.jsp");
		} else if ("editForm".equals(action)) {
			long id = Long.parseLong(request.getParameter("id"));
			List<SalleModel> salles = GetEntity.getListSalle();
			List<NiveauModel> niveaux = GetEntity.getListNiveaux();
			List<EnseignantModel> enseignants = GetEntity.getListEnseignant();
			List<DepartementModel> departement = GetEntity.getListDepartement();
			List<MatiereModel> matieres = GetEntity.getListMatiere();
			session.setAttribute("niveaux", niveaux);
			session.setAttribute("enseignants", enseignants);
			session.setAttribute("departements", departement);
			session.setAttribute("matieres", matieres);
			session.setAttribute("salles", salles);
			session.setAttribute("s", seanceToUpdate(id));
			response.sendRedirect("updateFormSeance.jsp");
		} else if ("update".equals(action)) {
			System.out.println("passed to update action **********");
			long id = Long.parseLong(request.getParameter("id"));
			String date = request.getParameter("dateSeance");
			int hd = Integer.parseInt(request.getParameter("heureDebut"));
			int hf = Integer.parseInt(request.getParameter("heureFin"));
			long salle = Long.parseLong(request.getParameter("salle"));
			long niveau = Long.parseLong(request.getParameter("niveau"));
			long matiere = Long.parseLong(request.getParameter("matiere"));
			long enseignant = Long.parseLong(request.getParameter("enseignant"));
			long departement = Long.parseLong(request.getParameter("departement"));
			System.out.println(Util.parceDate(date));
			// System.out.println(id);
			// System.out.println(hd);
			// System.out.println(hf);
			// System.out.println(GetEntity.getSalle(salle));
			// System.out.println(GetEntity.getDepartement(departement));
			// System.out.println(GetEntity.getEnseignant(enseignant));
			// System.out.println(GetEntity.getMatiere(matiere));
			// System.out.println(GetEntity.getNiveau(niveau));
			// System.out.println(GetEntity.getSeance(id));
			// do the update action

		} else if ("delete".equals(action)) {
			long id = Long.parseLong(request.getParameter("id"));
			// do the delete action

		} else if ("form".equals(action)) {
			session.setAttribute("niveaux", GetEntity.getListNiveaux());
			session.setAttribute("enseignants", GetEntity.getListEnseignant());
			session.setAttribute("departements", GetEntity.getListDepartement());
			session.setAttribute("matieres", GetEntity.getListMatiere());
			session.setAttribute("salles", GetEntity.getListSalle());
			response.sendRedirect("AddNewSeance.jsp");

		} else if ("ajouter".equals(action)) {
			String date = request.getParameter("dateSeance");
			int hd = Integer.parseInt(request.getParameter("heureDebut"));
			int hf = Integer.parseInt(request.getParameter("heureFin"));
			
			long salle = Long.parseLong(request.getParameter("salle"));
			long niveau = Long.parseLong(request.getParameter("niveau"));
			long matiere = Long.parseLong(request.getParameter("matiere"));
			long enseignant = Long.parseLong(request.getParameter("enseignant"));
			long departement = Long.parseLong(request.getParameter("departement"));
			System.out.println(Util.parceDate(date));
			System.out.println(hd);
			System.out.println(hf);
			System.out.println(GetEntity.getSalle(salle));
			System.out.println(GetEntity.getDepartement(departement));
			System.out.println(GetEntity.getEnseignant(enseignant));
			System.out.println(GetEntity.getMatiere(matiere));
			System.out.println(GetEntity.getNiveau(niveau));
			
			
			// do the add action
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
