<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<html>
<head>
<title>join_form1.jsp</title>
    <link rel="stylesheet" href="sub_style.css" type="text/css">
<style>
#content{
	width: 95%;
	margin-top: 50px;
	height: 500px;
	align-content: center;
    text-align: center;
}

input[type=text]{
    border: none;
    border-bottom: 2px solid black;
    width: 300;
    height: 30;
}

input[type=password]{
    border: none;
    border-bottom: 2px solid black;
    width: 300;
    height: 30;
}

</style>

</head>
<body>


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
<div id="content">
<br><br>
<form action="member.do" method="post">
<a href = "네이버 API로 연결되는 링크"><button>naver id로 회원가입</button></a><br><br>
id : <input type="text" name="id" size=20><br>
<br><input type="submit" value="Continue">
<input type="hidden" name="action" value="joinForm2">

</form>
</div>
</div>

</body>
</html>