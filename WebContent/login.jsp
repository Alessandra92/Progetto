<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>


<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

<style type="text/css">

body{
	background: transparent url('img/back.png') no-repeat center center fixed;
	background-size: cover;			
}
h1 {
	text-align:center;
	color:white;
}
			
h2 {
	text-align:center;
	color:white;
}

#pannello {
border-radius: 12px;
}

</style>




<title>Login</title>
</head>

<body>
	 <h1>Sanitaria</h1>
	<h2>Login</h2>
	
<div class="row"> <br><br> </div>

<div class="row">
	<div class="col-md-3 colonna" >	</div>
	
	<div class="col-md-6 colonna" >
		<div class="panel panel-default" id="pannello">
			<div class="panel-body"> 
			<form method="post" action="Login">
			  <div class="form-group">
				<label for="exampleInputEmail1">Indirizzo e-mail</label>
				<input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email">
				<small id="emailHelp" class="form-text text-muted">Inserici l'indirizzo e-mail usato per la registrazione</small>
			  </div>
			  <div class="form-group">
				<label for="exampleInputPassword1">Password</label>
				<input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
				<small id="emailHelp" class="form-text text-muted">Non ricordi la tua password? <a href="recuperaPwd.jsp">Recupera Password</a></small>
			  </div>
			  <button type="submit" class="btn btn-primary">Entra</button>
			</form>
			</div>
		</div>
	</div>
	
	<div class="col-md-3 colonna" >	</div>
</div>
	
</body>
</html>
