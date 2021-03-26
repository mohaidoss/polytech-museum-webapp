<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./styleCategories.css" type="text/css">
<title>Les oeuvres</title>

</head>

<body>
  <header> Le Musée virtuel </header>
	<nav>
		<h2>Les categories</h2>
			<ul>
				<c:forEach var="cat" items="${Categories}">
					<li><a href="vueOeuvres?categ=${cat.intitule }" target="contenu">
						${cat.intitule }</a></li>
				</c:forEach>
			</ul>
	</nav>
<section>
<iframe id="contenu" name="contenu" src="vueOeuvres" frameborder="0">
</iframe>
</section>
</body>
</html>