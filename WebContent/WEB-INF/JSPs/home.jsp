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

	<c:forEach var="row" items="${offers}">
    ID: ${row.id}<br />
    Name: ${row.name}<br />
    Email: ${row.email}<br />
    Text: ${row.text}<br />
	</c:forEach>

</body>
</html>