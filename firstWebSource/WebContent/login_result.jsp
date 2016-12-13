<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>login_result</title>
</head>
<body>
<c:if test="${not empty sessionScope.loginId }">
	<script type="text/javascript">
		alert("로그인 성공!")
		location.href="main.jsp";
	</script>
</c:if>

<c:if test="${empty sessionScope.loginId }">
	<script type="text/javascript">
		alert("로그인 실패!")
		location.href="login_form.jsp";
	</script>
</c:if>

</body>
</html>