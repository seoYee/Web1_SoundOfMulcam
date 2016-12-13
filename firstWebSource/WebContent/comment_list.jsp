<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


		<table border="1">
		<c:if test="${empty requestScope.commentPage}">
				<td colspan="5">업로드된 파일이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty requestScope.commentPage}">
			<c:forEach var="c" items="${commentPage}">
				<tr>
					<td>${c.commentNum}</td>
					<td>${c.musicNum}</td>
					<td>${c.nickname}</td>
					<td>${c.grp}</td>
					<td>${c.seq}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	

</body>
</html>