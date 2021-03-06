package tn.iit.gestabs.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.ejb.EJB;
//import tn.iit.gestabs.control.SalleService;
//import tn.iit.gestabs.services.SalleServicesLocal;
import javax.servlet.http.HttpSession;

import tn.iit.gestabs.control.SalleService;
import tn.iit.gestabs.entites.Salle;

/**
 * Servlet implementation class SSERVLET
 */

@WebServlet("/SSERVLET")
public class SSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SalleService servicesLocal;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SSERVLET() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		Salle retour = servicesLocal.getById((long) 1);
		System.out.println("type de retour :" + servicesLocal.getById((long) 1)
				.getClass().getTypeName() + "************");
		response.getWriter().append(retour.toString());

		HttpSession session = request.getSession();
		session.setAttribute("s", retour);
		
		// response.sendRedirect("a.jsp");
		// System.out.println(servicesLocal.getById((long)
		// 1).toString()+"******");
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

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
}
