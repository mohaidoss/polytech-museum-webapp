<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./styleOeuvres.css" type="text/css">
<title>Les oeuvres</title>

</head>

<body>
  <section>
  	<ul>
  		<b>${requestScope.message}</b>
  		<c:forEach var="oeuvre" items="${oeuvre}">
  			<li>
  				<div id="titre">${oeuvre.titre} (${oeuvre.annee}) par ${oeuvre.artiste.prenom} ${oeuvre.artiste.nom}<br>
  				<div id="avis"> (J'aime : ${oeuvre.aime} - Je n'aime pas : ${oeuvre.aimepas} - Sans avis : ${oeuvre.sansavis}) </div>
  				</div><br>
  				<table>
  					<tbody>
  						<tr>
  							<td><img src=${oeuvre.URL} alt="image non reconnue" width="200"></td>
              				<td><h1>Score : <span class="score">${oeuvre.score}</span></h1></td>
         				</tr>
  					</tbody>
  				</table>
  				<br>
          		<form action="avis" method="get">
          		<input type="hidden" name="categ" value=${Categories}>
          		<input type="hidden" name="id" value=${oeuvre.id}>
          		J'aime:<input type="radio" name="avis" value="1">
          		J'aime pas:<input type="radio" name="avis" value="2">
          		Sans Avis:<input type="radio" name="avis" value="3">
          		<input type="submit" value="Go">
          		</form>
          		<br> 
  			</li>
  		</c:forEach>
  	</ul>
</section>
</body>
</html>