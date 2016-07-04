<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="TestServlet">Test !</a>

<c:forEach items="${dest }" var="destination">
	${destination.region}
	${destination.description}
	${destination.images[0]}
	<br/>
</c:forEach>


<c:forEach items="${dates }" var="date">
	${date.dateDepart} - ${date.dateRetour}
	<br/>
</c:forEach>

</body>
</html>