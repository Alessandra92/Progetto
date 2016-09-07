<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js"></script>

<script src="js/jquery.min.js"></script>

<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Conferma Prenotazione</title>
<style>
body {
	background: transparent url('img/esami.jpg') no-repeat center center
		fixed;
	background-size: cover;
}

h1 {
	text-align: center;
	color: white;
}

h2 {
	text-align: center;
	color: white;
}
</style>
</head>
<body>
<body>
	<h1>Sanitaria</h1>
	<br>
	<br>
	<br>
	<h2>Conferma Prenotazione</h2>
	<br>
	<br>


	<div class="row" style="opacity: 1">
		<div class="col-md-3 colonna"></div>
		<div class="col-md-6 colonna">
			<div class="panel panel-default">
				<div class="panel-body">
					
					<form action="PrenotazioneEsame" method="post">
						<div class="form-group">
							<label>Seleziona Esame</label>
							<h4>Informazioni Esame</h4>
							<b>Nome:</b>
							<c:out value="${esame.nome}" />
							<br> <b>Descrizione:</b>
							<c:out value="${esame.note}" />
							<br> <b>Costo:</b>
							<c:out value="${costo}" />
							<input type="hidden" name="idAzienda" value="${azienda.idAzienda }"/>
							<input type="hidden" name="idEsame" value="${esame.idEsame }"/>
							<hr>
							<h4>Informazioni Azienda</h4>
							<b>Nome:</b>
							<c:out value="${azienda.nome}" />
							<br> <b>Email:</b>
							<c:out value="${azienda.email}" />
							<br> <b>Indirizzo:</b>
							<c:out value="${azienda.indirizzo}" />
							<br> <b>Città:</b>
							<c:out value="${citta.nome}" />
							,
							<c:out value="${regione.nome}" />



							<hr>
							<label>Data Prenotazione</label>
							<div>
								<input type="date" class="form-control" name="dataEsame"
									placeholder="mm/dd/yyyy" required="required">
							</div>

						</div>
						<button type="submit" class="btn btn-primary">Invio</button>
						<button type="reset" class="btn btn-primary">Reset</button>
					</form>
				</div>

			</div>

		</div>
		<a class="btn btn-lg bottone center-block " href="CercaEsame"
			role="button">Torna a Cerca Esame Medico</a>

		<div class="col-md-3 colonna"></div>
	</div>

	</div>
</body>
</html>