<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<title>logout</title>
</head>
<body>
<% session.invalidate(); %>

<script>
alert("logout되었습니다.");
	location.href="main.jsp";
</script>

</body>
</html>