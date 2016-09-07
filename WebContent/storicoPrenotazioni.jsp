<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery.min.js"></script>

<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />


<title>Storico Prenotazioni</title>

<style>
	body{margin:0 0 0 0; 
		background: url(img/back.png) no-repeat ;
		background-attachment:fixed; 
		 
		
		color: white;}
	h1{
		font-family:Monotype Corsiva, Times, serif;
		color: white;
		text-align:center;
		opacity:1;
		font-size: 3.3em;
		}
		
	h2 {
		text-align:center;
		color:white;
	}	
	
		
	.navbar-custom {
    background-color:white;
    color:blue;
    border-radius:0;
	}

	.navbar-custom .navbar-nav > li > a {
		color:black;
	}
	.navbar-custom .navbar-nav > .active > a, .navbar-nav > .active > a:hover, .navbar-nav > .active > a:focus {
		color:white;
		background-color:gray;
	}
	.navbar-custom .navbar-brand {
		
	}	
	
	.padding{
	padding-top:50px;
	}
	
	.tabella{
	background-color:white;
	color:black;
	
	
	}
	
	.intestazione{
	background-color: silver;
	color:white;
	}
	
</style>

</head>
<body>

<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
  <div class="container-fluid">
    
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="homePaziente.jsp">Logo</a>
    </div>

    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-left">
	  
        <li class="active "><a href="homePaziente.jsp">Home <span class="sr-only">(current)</span></a></li>
		
        
		
        <li class="dropdown">
          <a href="" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Gestione Profilo Utente<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="ModificaDati">Modifica Dati</a></li>
            <li><a href="ModificaPassword">Modifica Password</a></li>
			<li><a href="ElencoPrenotazioni">Storico Prenotazioni</a></li>
			<li><a href="PrenotazioniAttive">Prenotazioni Attive</a></li>
			
           </ul>
        </li>
		
		<li><a  href="CercaEsame">Cerca Esame</a></li>
		<li><a  href="CercaAzienda">Cerca Azienda</a></li>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
		<li><a href="Logout"><c:out value="${nome}"/> Logout</a></li>
		</ul>
      
      
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div style="padding-top:50px">
</div>


	<h1>Sanitaria.it</h1>
	<h2>Elenco Storico Prenotazioni</h2>

<br>

<div class="row" >
<div class="colonna col-lg-2 col-md-3">
</div>
<div class="colonna col-lg-8 col-md-6">
<table class=" table table-bordered table-hover tabella">
  <thead class="intestazione">
    <tr>
      <th>#</th>
      <th>Esame</th>
      <th>Azienda</th>
      <th>Costo</th>
      <th>Data Visita</th>
      <th>Feedback</th>
      <th>Stampa</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${storicoPrenotazioni}" var="prenotazione" varStatus="status">
		<tr>
			<td><c:out value="${status.count}"/></td> 
			<td> <c:out value="${prenotazione.nomeEsame}"/></td>
			<td> <c:out value="${prenotazione.nomeAzienda}"/></td>
			
			<td> <c:out value="${prenotazione.costoEsame}"/></td>
			<td> <c:out value="${prenotazione.dataEsame}"/></td>
			 <td><a href="">
					<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
  				</a>
			</td>
      <td><a href="">
					<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
				</a>
			</td>
			
		</tr>
	</c:forEach>
   
  </tbody>
</table>
</div>
<div class="colonna col-lg-2 col-md-3">
</div>
</div>
		

</body>

<script src="js/bootstrap.min.js" >
</script>


</html>