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
</head>
<body>
	<%
		SeanceModel sun = (SeanceModel) session.getAttribute("s");
		List<SalleModel> salles = (List<SalleModel>) session.getAttribute("salles");
		List<NiveauModel> niveaux = (List<NiveauModel>) session.getAttribute("niveaux");
		List<MatiereModel> matieres = (List<MatiereModel>) session.getAttribute("matieres");
		List<EnseignantModel> enseignants = (List<EnseignantModel>) session.getAttribute("enseignants");
		List<DepartementModel> departements = (List<DepartementModel>) session.getAttribute("departements");
	%>
	
	<form action="SeanceServlet" method="post">
		<input type="hidden" name="id" value="<%out.print(sun.getId());%>">
		<table>
			<tr>
				<td>Date Seance</td>
				<td><input type="date" name="dateSeance"
					value="<%out.print(sun.getDateSeance());%>"></td>
			</tr>
			<tr>
				<td>Heure Debut</td>
				<td><input type="text" name="heureDebut"
					value="<%out.print(sun.getHeureDebut());%>"></td>
			</tr>
			<tr>
				<td>Heure Fin</td>
				<td><input type="text" name="heureFin"
					value="<%out.print(sun.getHeureFin());%>"></td>
			</tr>
			<tr>
				<td>salle</td>
				<td><select name="salle">
						<%
							for (SalleModel s : salles) {
						%>
						<option value="<%out.print(s.getId());%>">
							<%
								out.print(s.getNom());
							%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>
			<tr>
				<td>niveau</td>
				<td><select name="niveau">
						<%
							for (NiveauModel s : niveaux) {
						%>
						<option value="<%out.print(s.getId());%>">
							<%
								out.print(s.getFiliere() + " " + s.getAnnee() + "ann�e");
							%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>
			<tr>
				<td>matiere</td>
				<td><select name="matiere">
						<%
							for (MatiereModel s : matieres) {
						%>
						<option value="<%out.print(s.getId());%>">
							<%
								out.print(s.getNom());
							%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>
			<tr>
				<td>enseignant</td>
				<td><select name="enseignant">
						<%
							for (EnseignantModel s : enseignants) {
						%>
						<option value="<%out.print(s.getId());%>">
							<%
								out.print(s.getNom() + " " + s.getPrenom());
							%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>
			<tr>
				<td>departement</td>
				<td><select name="departement">
						<%
							for (DepartementModel s : departements) {
						%>
						<option value="<%out.print(s.getId());%>">
							<%
								out.print(s.getNom());
							%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="update"></td>
			</tr>
		</table>
	</form>




	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



</body>
</html>