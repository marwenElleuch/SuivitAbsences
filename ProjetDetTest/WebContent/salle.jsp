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
<%
	/* List<SalleModel> seance = 
	(List<SalleModel>) session.getAttribute("salleArray");
	if (seance != null) {
		out.print(seance.size());
	} else
		out.print("0");
	 */
	 
	List<SalleModel> salles = null;
	try {
		//System.out.println("liste de tt les salles");
		salles = GetEntity.getListSalle();
		//out.print(seances.size());
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>salle</title>
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
				href="CompteBancaireServlet?load=load">Seance <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="ClientBanqueServlet">Salle</a></li>
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
<h3><a href="salle?action=form">ajouter une nouvelle Salle</a></h3>
	<h1>Liste de tout les salle</h1>
	<table>
		<tr>
			<td>Nom salle</td>
		</tr>
	<%
		if (salles != null) {
			for (SalleModel s : salles) {
	%>
		<tr>
			<td>
				<%
					out.print(s.getNom());
				%>
			</td>
			
			<td><a href='salle?action=editForm&id=<%=s.getId()%>'>Edit</a></td>
			<td><a href='salle?action=delete&id=<%=s.getId()%>'>Delete</a></td>
		</tr>
		<%
			}
			} else {
				// aucune seance trouver
		%>
		<tr>
			<h1>Aucune salle trouver</h1>
		</tr>
		<%
			}
		%>
	</table>
</div>
</body>
</html>