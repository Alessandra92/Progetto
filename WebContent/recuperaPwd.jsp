<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recupera Password</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

<style>
body{
	background: transparent url('img/healthcare.png') no-repeat center center fixed;
	background-size: cover;
	
}

h1 {
color:white;
}


.bottone:hover {
	background-color: white;
	color: blue;
	border: 2px solid blue;
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
		}	
		
		
</style>






</head>
<body onload="viewError()">

 
 <br> <br> <br> <br>
 <div>
 <center>
 	 <h1>Recupera Password</h1> </center>
 
 </div>
<div class="container">
<div class="row"> <br><br> </div>

<div class="row">
	<div class="col-md-3 colonna" >	</div>
	
	<div class="col-md-6 colonna" >
	<div class="panel panel-default">
	<div class="panel-body"> 
	
	<form action="RecuperaPassword" method="post">
	 <center><font color="#a94442"><label class="control-label" id="errore"></label> </font></center>
		<div class="form-group" id="email">
		 	<label class="control-label" >Indirizzo e-mail</label>
			<input  type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="e-mail" required="required"></input>
			<small id="emailHelp" class="form-text text-muted">Inserisci l'indirizzo e-mail di registrazione</small>
	  	</div>
	  <button type="submit" class="btn btn-primary pull-left">Recupera</button>	 			
	</form>
		<form action="Login" method="get">
		<button type="submit" class="btn btn-primary pull-right">Login</button>
		</form>
	</div>
      </div>
	    </div>
	
	<div class="col-md-3 colonna" >	</div>
     </div>
     </div>


</body>

<script>
		function viewError(){
			
			var vuota = "${vuota}"; //email vuota
			var errata = "${errata}"; //email formato errato;
			var inviata = "${inviata}";
			var nonInviata = "${nonInviata}";
			document.getElementById('errore').innerHTML = '';
			
			if(vuota){
				document.getElementById('email').className="form-group has-error has-feedback";
				document.getElementById('errore').innerHTML = 'Campo email vuoto';
			}
					
			else if(errata){
				document.getElementById('email').className="form-group has-error has-feedback";
				document.getElementById('errore').innerHTML = 'Email errata';
			}
			
			else if(nonInviata){
				document.getElementById('errore').innerHTML = 'Email non inviata';
			}
			else if(inviata){
				document.getElementById('errore').innerHTML = 'Email inviata';
			}
			
		}
	</script>	



</html>