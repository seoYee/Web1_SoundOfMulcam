<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="sub_style.css" type="text/css">
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<%
// int musicNum = Integer.parseInt(session.getAttribute("musicNum").toString());
// int musicNum = (Integer)session.getAttribute("musicNum");
// String musicNumStr = request.getParameter("musicNum");
// int musicNum = Integer.parseInt(musicNumStr);
String nickname = (String)(session.getAttribute("nickname"));
String profileImg = (String)(session.getAttribute("profileImg"));

String musicNum = request.getParameter("num");
session.setAttribute("selectedNum", musicNum);

%>

<script>
$(document).ready(function(){
	$(".commentList").load("http://70.12.109.117:8888/Day20/comment.do?action=selected&musicNum="+'${selectedMusic.fileNum}')
//                                                                             "top10.do?action=playcount&num="+'${selectedMusic.fileNum}';
	
	// 	$(".commentList").load("http://70.12.109.117:8888/Day20/comment.do?action=selected&musicNum=14")
// alert("${selectedMusic.fileNum}");
	return false;
});

</script>

</head>
<body>
<%String a = "files/"; %>


<style type="text/css">
a{
	text-decoration:none;
	color:black;
}

.artist{
	height: 47%;
	vertical-align: bottom;
}

.title{
	height: 30px;
	font-size: 20pt;
	font-weight: bold;
	vertical-align: top;
}

.b_play{
	width: 100px;	
}

#header intput[type=search]{
	margin-top:10;
}

</style>

<div id="line"></div>
    
       <div id="header">
           <li class="home">
           <a href="index.html"><img src="main_logo.png"></a></li>
           <li class="left">
           <li class="left"><a href="http://70.12.109.117:8888/Day20/top10.do?action=chartList">CHARTS</a></li>
            <li class="left"><form method="get" action="/search" id="search">
            <input name="q" type="search" size="50" placeholder="Search for artists, bands, tracks"/></li>
        </form>
           </li>
         
        <c:if test="${empty sessionScope.loginId }">
        <li class="right"><a href="http://70.12.109.117:8888/Day20/join_form1.jsp"><button>JOIN US</button></a></li>
        <li class="right"><a href="login_form.jsp">LOGIN</a></li>
                 </c:if>
         <c:if test="${not empty sessionScope.loginId }">
        <li class="right"><a href="logout.jsp">LOGOUT</a></li>
        <li class="right"><a href="http://70.12.109.117:8888/Day20/upload_form.jsp">UPLOAD</a></li>

        </c:if>
       </div>
    

<div id="wrap">
    <div class="blank"></div>
    <div class="player">
        <table>
            <tr>
            <td class="b_play" rowspan="2"><img src=btn_play.png></td>
            <td class="artist">${selectedMusic.singer}</td>
            <td class="cover" align=center rowspan="3"><img src="<%=a %>${selectedMusic.fileName}" style="align=center"></td>
            </tr>
            <tr>
                <td class="title">${selectedMusic.title}</td>
            </tr>
        </table>
    </div>
<div class="board" align="center">
<!--   <h1>해당 음원 게시판 부분</h1> -->
<br><br><br>
<form name="frm" method="post" action="comment.do?action=write">
				<textarea rows="3" cols="70" name="content"
					placeholder="Write a comment"></textarea>
					<input type="hidden" name="musicNum" value="${selectedMusic.fileNum}">
					<input type="hidden" name="nickname" value="${nickname}">
					<input type="hidden" name="profileImg" value="${profileImg}">
				<input type="submit" id="submitBtn" value="Write" />
			</form>

			
			  <div class="commentList"></div>
</div>
    
    
           <div id="footer">
       </div>
    
    </div>

</body>
    
    

    

</html>

