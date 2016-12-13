<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>file_list.jsp</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>파일번호</th>
			<th>파일이름</th>
			<th>저장경로</th>
			<th>이미지경로</th>
		</tr>
		<c:if test="${empty requestScope.fileList}">
			<tr>
				<td colspan="5">업로드된 파일이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty requestScope.fileList}">
			<c:forEach var="file" items="${fileList}">
				<tr>
					<td>${file.fileNum}</td>
					<td>
						<a href="download.do?fileNum=${file.fileNum}">
							${file.title}
						</a>
					</td>
					<td>${file.savedPath}</td>
					<td>${file.savedImgPath}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<a href="file.do?action=uploadForm">
		<button>파일 추가</button>
	</a>
<hr>
<img src="file:\\C:\uploaded\Chrysanthemum.jpg">
</body>
</html>

