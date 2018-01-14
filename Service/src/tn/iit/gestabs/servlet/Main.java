package tn.iit.gestabs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */

@WebServlet("/m")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("im here mother fucker in Service");
		//response.sendRedirect("c.jsp");
		
		RequestDispatcher r = getServletContext().getRequestDispatcher("/c.jsp");
		r.forward(request, response);
		//request.getRequestDispatcher("/WEB-INF/c.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("im hereeeeeeee in doGet ");
//		RequestDispatcher r = getServletContext().getRequestDispatcher("/"
//				+ ""
//				+ "WEB-INF/c.jsp");
//		r.forward(request, response);
//		service(request, response);	//	request.getRequestDispatcher("/WEB-INF/c.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.sendRedirect("c.jsp");
	}

}
