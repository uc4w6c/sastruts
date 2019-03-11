<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<html:errors/>
<s:form method="POST">
	お名前をどうぞ！
	<html:text property="name" />
	<s:submit property="echo" value="送信"/>
</s:form>
</body>
</html>