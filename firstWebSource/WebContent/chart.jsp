<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>file_list.jsp</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
function go_pop(name){
    window.open("alone.jsp?action=play&fileNum="+name,"new","width=370, height=360, resizable=no, scrollbars=no, status=no, location=no, directories=no;");
    var a = $('#btnPreview').val();
}
</script>
<link rel="stylesheet" href="chart_style.css" type="text/css">
    
</head>
<style type="text/css">
a{
	text-decoration:none;
	color:black;
}

</style>

<body>

<%String a = "files/"; %>

<div id="line"></div>
    
       <div id="header">
           <li class="home">
           <a href="index.html"><img src="main_logo.png"></a></li>
           <li class="left"><a href="http://70.12.109.117:8888/Day20/top10.do?action=chartList">CHARTS</a></li>
           <li class="left">
            <form method="get" action="/search" id="search">
            <input name="q" type="search" size="80" placeholder="Search for artists, bands, tracks"/>
        </form>
           </li>
        <li class="right"><a href="http://70.12.109.117:8888/Day20/upload_form.jsp">UPLOAD</a></li>
        <li class="right"><a href="회원가입페이지"><button>JOIN US</button></a></li>
        <li class="right"><a href="로그인페이지">LOGIN</a></li>
       </div>
       
<div id="wrap">
<div class="chart">
<br><br><br><br>
<img src=chart.png><br><br>

	<table>
               <tr>
                   <th height="30"><b>순위</b></th>
                   <th></th>
                   <th><b>곡</b></th>
                   <th width="100"><b>아티스트</b></th>
                   <th width="100"><b>앨범</b></th>
                   <th></th>
                   <th></th>
                   <th></th>
               </tr>
               
		<c:if test="${empty requestScope.chartList}">
			<tr>
				<td colspan="8">오류났어</td>
			</tr>
		</c:if>
		<c:if test="${not empty requestScope.chartList}">
			<c:forEach var="file" items="${chartList}" varStatus="status">
				<tr>
					<td class="rank"><h1>${status.count}</h1></td>
					<td class="cover"><a href="subpage.do?action=selected&num=${file.fileNum}" style="text-decoration:none">
							<img src="<%=a %>${file.fileName}"></a>
							
							</td>
					<td class="title"><a href="subpage.do?action=selected&num=${file.fileNum}">${file.title}</a></td>
					<td class="artist" style="padding-left:10px">${file.singer}</td>
					<td class="album" width="100px" style="padding-left:10px">${file.album}</td>
<%-- 					<td class="icon" style="padding-left:20px"><a href="top10.do?action=play&fileNum=${file.fileNum}" ><img src="b_play.png"></a></td> --%>
						<td class="icon" style="padding-left:20px"><a href="#" class="btnPreview" onClick="window.go_pop('${file.mp3Name}')"><img src="b_play.png"></a></td>
					<td class="icon"><a href="add.do?fileNum=${file.fileNum}"><img src="b_add.png"></a></td>
					<td class="icon"><a href="like.do?fileNum=${file.fileNum}"><img src="b_like.png"></a></td>
					</c:forEach>
				</tr>
		</c:if>
	</table>
	
	<br>
	
</div>
       <div id="footer"></div>

</div>


</body>
</html>

