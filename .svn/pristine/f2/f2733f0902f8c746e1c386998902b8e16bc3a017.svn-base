<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Cambia Password</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<style>
body{
	background: transparent url('img/healthcare.jpg') no-repeat center center fixed;
	background-size: cover;
	
}

h1 {
color:blue;
}



</style>





</head>
<body>
 
  <br> <br> <br> <br> <br>
 
 

<div class="container">
<div class="row"> <br><br> </div>

<div class="row">
	<div class="col-md-3 colonna" >	</div>
	
	<div class="col-md-6 colonna" >
	<div class="panel panel-default">
			<div class="panel-body" > 
	<form id="identicalForm"  action="ModificaPassword" method="post" >
	  <div class="form-group">
		<label for="InputPwd1">Password</label>
		<input type="password" class="form-control" id="exampleInputPassword1" name="vecchiaPassword"  placeholder="Password" required = "required">
		<small id="emailHelp" class="form-text text-muted">Inserisci la password attuale</small>
	  </div>
	  <div class="form-group">
		<label for="exampleInputEmail2">Nuova Password</label>
		<input type="password" class="form-control" id="exampleInputPassword2" name="password" placeholder="Nuova Password" required = "required">
		<small id="emailHelp" class="form-text text-muted">Inserisci la nuova password</small>
	  </div>	  
	  <div class="form-group">
		<label for="exampleInputEmail3">Ripeti Nuova Password</label>
		<input type="password" class="form-control" id="exampleInputPassword3" name="confirmPassword" placeholder="Ripeti Nuova Password" required = "required">
		<small id="emailHelp" class="form-text text-muted">Inserisci la nuova password</small>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">
                     Cambia
                   </button>
	</form>

	</div>
      </div>
	    </div>
	
	<div class="col-md-3 colonna" >	</div>
     </div>
     </div>


<script>
$(document).ready(function() {
    $('#identicalForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            confirmPassword: {
                validators: {
                    identical: {
                        field: 'password',
                        message: 'The password and its confirm are not the same'
                    }
                }
            }
        }
    });
});
</script>











</body>
</html>