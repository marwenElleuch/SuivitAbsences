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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
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
	<%
		SeanceModel sun = (SeanceModel) session.getAttribute("s");
		List<SalleModel> salles = (List<SalleModel>) session.getAttribute("salles");
		List<NiveauModel> niveaux = (List<NiveauModel>) session.getAttribute("niveaux");
		List<MatiereModel> matieres = (List<MatiereModel>) session.getAttribute("matieres");
		List<EnseignantModel> enseignants = (List<EnseignantModel>) session.getAttribute("enseignants");
		List<DepartementModel> departements = (List<DepartementModel>) session.getAttribute("departements");
	%>
	<br><br>
	<center>
	<h3>Insérer une nouvelle Seance :</h3>
	<form action="SeanceServlet" method="post">
		<table>
			<tr>
				<td>Date Seance</td>
				<td><input type="date" name="dateSeance"></td>
			</tr>
			
			<tr>
				<td>Heure Debut</td>
				<td><input type="number" name="heureDebut"></td>
			</tr>
			<tr>
				<td>Heure Fin</td>
				<td><input type="number" name="heureFin"></td>
			</tr>
			<tr>
				<td>salle</td>
				<td><select name="salle">
				<%for(SalleModel s : salles){ %>
					<option value="<%out.print(s.getId());%>"><%out.print(s.getNom());%></option>
				<%} %>
				</select></td>

			</tr>
			<tr>
				<td>niveau</td>
				<td><select name="niveau">
				<%for(NiveauModel s : niveaux){ %>
					<option value="<%out.print(s.getId());%>"><%out.print(s.getFiliere() + " " + s.getAnnee() + "année");%></option>
				<%} %>
				</select></td>

			</tr>
			<tr>
				<td>matiere</td>
				<td><select name="matiere">
				<%for(MatiereModel s : matieres){ %>
					<option value="<%out.print(s.getId());%>"><%out.print(s.getNom());%></option>
				<%} %>
				</select></td>

			</tr>
			<tr>
				<td>enseignant</td>
				<td><select name="enseignant">
				<%for(EnseignantModel s : enseignants){ %>
					<option value="<%out.print(s.getId());%>"><%out.print(s.getNom()+" "+s.getPrenom());%></option>
				<%} %>
				</select></td>

			</tr>
			<tr>
				<td>departement</td>
				<td><select name="departement">
				<%for(DepartementModel s : departements){ %>
					<option value="<%out.print(s.getId());%>"><%out.print(s.getNom());%></option>
				<%} %>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="ajouter"></td>
			</tr>
		</table>
	</form>

</center>
</div>
</body>
</html>