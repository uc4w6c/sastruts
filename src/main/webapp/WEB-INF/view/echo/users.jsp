<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- JSTLのタグで表示 --%>
<c:forEach items="${users}" var="user">
名前：<c:out value="${user}"/><br>
</c:forEach>

</body>
</html>