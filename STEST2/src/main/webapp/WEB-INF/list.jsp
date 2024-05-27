<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var = "t" items="${list}">
	<b>${t.gcode}</b> 
	<b>${t.gname}</b>
	<b>${t.gprice}</b>
	<b>${t.gtotal}</b>
	<br/>
</c:forEach>
</body>
</html>