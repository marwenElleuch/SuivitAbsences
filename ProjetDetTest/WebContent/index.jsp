<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<br><br><br>
<center>
<h1>Seléctioner une Date</h1>
<form action="SeanceServlet" method="Post">
	<input type="date" name="daydate">
	<br><br>
	<input type="hidden" name="action" value="load">
	<input type="submit" value="commencer">
</form>
</center>
</div>
</body>
</html>