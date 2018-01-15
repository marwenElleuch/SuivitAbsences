<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="tn.iit.models.*"%>
<%@page import="java.io.IOException"%>
<%@page import="tn.iit.util.*"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seances</title>
<%
	List<SeanceModel> seance = (List<SeanceModel>) session.getAttribute("seances");
	if (seance != null) {
		out.print(seance.size());
	} //else out.print("0");
	
	List<SeanceModel> seances = null;
	try {
		System.out.println("liste de tt les seance");
		seances = GetEntity.getListSeances();
		//out.print(seances.size());
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
%>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand" href="">Suivit Absences</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="SeanceServlet">Seance <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="salle">Salle</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ClientBanqueServlet">niveau</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ClientBanqueServlet">matiere</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ClientBanqueServlet">departement</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ClientBanqueServlet">enseignat</a></li>
		</ul>
	</div>
	</nav>

<div class="container">
<h3><a href="SeanceServlet?action=form">ajouter une nouvelle seance</a></h3>

	<h1>Liste de tout les seance</h1>
	<table>
		<tr>
			<td>Date Seance</td>
			<td>Heure Debut</td>
			<td>Heure Fin</td>
			<td>salle</td>
			<td>niveau</td>
			<td>matiere</td>
			<td>enseignant</td>
			<td>departement</td>
		</tr>
		
	<%
		if (seances != null) {
			for (SeanceModel s : seances) {
	%>
	
		<%-- <c:forEach items="${seanceArray}" var="item"> --%>
		<tr>
			<td>
				<%
					out.print(s.getDateSeance());
				%>
			</td>
			<td>
				<%
					out.print(s.getHeureDebut() + "h");
				%>
			</td>
			<td>
				<%
					out.print(s.getHeureFin() + "h");
				%>
			</td>
			<td>
				<%
					out.print(s.getSalle().getNom());
				%>
			</td>
			<td>
				<%
					out.print(s.getNiveau().getFiliere() + " " + s.getNiveau().getAnnee() + "année");
				%>
			</td>
			<td>
				<%
					out.print(s.getMatiere().getNom());
				%>
			</td>
			<td>
				<%
					out.print(s.getEnseignant().getNom() + " " + s.getEnseignant().getPrenom());
				%>
			</td>
			<td>
				<%
					out.print(s.getDepartement().getNom());
				%>
			</td>

			<td><a href='SeanceServlet?action=editForm&id=<%=s.getId()%>'>Edit</a></td>
			<td><a href='SeanceServlet?action=delete&id=<%=s.getId()%>'>Delete</a></td>
		</tr>
		<%
			}
			} else {
				// aucune seance trouver
		%>
		<tr>
			<h1>Aucune seance trouver</h1>
		</tr>
		<%
			}
		%>
	</table>
</div>

</body>
</html>