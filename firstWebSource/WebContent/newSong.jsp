<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>newSong</title>
<style type="text/css">


.newsong table img{
    width: 100%;
}

.newsong table{
    align-self: center;
    border: none;
    width: 95%;
    margin: auto;
    font-size: 10pt;
    border-collapse: collapse;
}

.newsong table tr{
    height: 100px;
}

.newsong table td{
	width:20%;
}

</style>
</head>
<body>
<%String a = "files/"; %>

<div class="newsong">
<img src="main_new.png"><br><br>

<table>
		<c:if test="${empty requestScope.newList}">
			<tr>
				<td colspan="8">¿À·ù³µ¾î</td>
			</tr>
		</c:if>
		<c:if test="${not empty requestScope.newList}">
		<tr>
			<c:forEach var="file" items="${newList}" varStatus="status">
				<c:if test="${status.count=='6'}"></tr><tr></c:if>
				<td><a href="subpage.do?action=selected&num=${file.fileNum}"><img src="<%=a %>${file.fileName}"></a></td>
			</c:forEach>
		</c:if>
	</tr>
</table>

        <br>
        <button id="more">view more</button>
</div>
</body>
</html>