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
<p>
名前を入力してください<br>
<html:text property="name" />
<!-- 名前<input type="text" name="first_name"><br>
苗字<input type="text" name="last_name"><br> -->
<s:submit property="echo" value="送信"/><br>
</p>
</s:form>
</body>
</html>
