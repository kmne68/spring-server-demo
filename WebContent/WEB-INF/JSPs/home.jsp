<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Server</title>
</head>
<body>
	Hello World!

	<!-- Don't do this in real applications! -->
	<!-- p>Session: <!-- %= session.getAttribute("name") %-->
	<!-- /p-->

	<!-- Request: <!--%= session.getAttribute("name") %></p-->

	<!-- p>Request (using EL): ${name}</p-->

	<p>
		<c:out value="${name}"></c:out>
	</p>

	<sql:query var="rs" dataSource="jdbc/spring">
select id, name, email, text from offers
</sql:query>

	<c:forEach var="row" items="${rs.rows}">
    ID ${row.id}<br />
    Name ${row.name}<br />
	</c:forEach>

</body>
</html>