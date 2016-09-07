<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
		<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
		<script src="js/bootstrap.min.js"></script>

		<title>Cerca Azienda per Città</title>

		<style>
			body{
				background: transparent url('img/healthcare.png') no-repeat center center fixed;
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
			
			
		</style>
	</head>
<body>
<br>

<h1> Cerca Azienda</h1>

<br><br>

		<div class="row" style="opacity:0.9">
			<div class="col-md-3 colonna" >
			</div>
			<div class="col-md-6 colonna" >
<!-- 				<div class="panel panel-default"> -->
					<div class="panel-body"> 
		  	
					<form>

                      <div class="form-group">
						<label for="exampleSelect1">
						<h1> Scegli la città</h1>					
						</label>
						<select class="form-control" id="exampleSelect1" required = "required">
						
						<c:forEach items="${listaCitta}" var="i" varStatus="status">
						
						  <option value="${i.idCitta}"><c:out value="${i.nome}"/></option>
						 		  
						</c:forEach>			
						  
						</select>
								
					  </div> 
					  <a href="listaAzienda">
					   <button type="submit" style="width: 30%; font-size:1.1em;" class="btn btn-primary " ><b>Cerca</b></button>
					  </a>
					  			</form>
					  			 </div>  </div>  </div>  

  










</body>
</html>