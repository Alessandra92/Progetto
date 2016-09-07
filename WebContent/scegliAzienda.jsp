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

		<title>Scegli Azienda</title>

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
			
			.tabella{
				background-color:white;
				color:black;
						
			}
			
			.intestazione{
				background-color: silver;
				color:white;
			}
			
			.bottone{
					background-color: white;
				    color: grey;
				    border: 2px solid grey;
					width: 250px;
					align:center;
									
					}
					
					.bottone:hover {
				    background-color: silver; /* Green */
				    color: white;
					border: 2px solid white;
					box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
				}
			
			
		</style>
	</head>
<body>


<br>

<h1> Scegli Azienda nella città di <c:out value="${cit}"/> </h1>

<br><br>


<div class="row" >
<div class="colonna col-lg-2 col-md-3">
</div>
<div class="colonna col-lg-8 col-md-6">
<table class=" table table-bordered table-hover tabella">
  <thead class="intestazione">
    <tr>
      <th>#</th>
      <th>Azienda</th>
      <th>Indirizzo</th>
      <th>Email</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listaAziende}" var="azienda" varStatus="status">
		<tr>
			<td><c:out value="${status.count}"/></td> 
			<td> <c:out value="${azienda.nome}"/></td>
			<td> <c:out value="${azienda.indirizzo}"/></td>
			<td> <c:out value="${azienda.email}"/></td>
			<td><a href="">

					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				
				</a>
			</td>	
			
		</tr>
	</c:forEach>
   
  </tbody>
</table>
	<br>
	 <a class="btn btn-lg bottone center-block "  href="CercaAzienda" role="button">Cerca un'altra città</a>

</div>
<div class="colonna col-lg-2 col-md-3">
</div>
</div>




</body>
</html>