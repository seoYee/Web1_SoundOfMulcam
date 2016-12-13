<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% String num = session.getAttribute("selectedNum").toString();%>
<script>


location.href = "http://70.12.109.117:8888/Day20/subpage.do?action=selected&num="+'<%=num%>';


// $(document).ready(function(){
// 	$(".commentList").load("http://70.12.109.117:8888/Day20/comment.do?action=selected&musicNum=")
//                                                                             "top10.do?action=playcount&num="+'${selectedMusic.fileNum}';
	
// 	return false;
// });


</script>


<div class="commentList"></div>
</body>



</html>