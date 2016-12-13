<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
<head>
   <link rel="stylesheet" href="sub_style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>point.jsp</title>
<style>
.page{
	height: 100%;
	vertical-align: top;
	text-align: center;
}

.page a{
	text-decoration: none;
}


input[type=text]{
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 3px solid #3e99d2;
    border-radius: 15px;
    box-sizing: border-box;
    outline: none;
    background-color: rgba(0,0,0,0.8);
    color: white;
    background-image: url('serchicon.png');
    background-position: 10px 10px;
    background-repeat: no-repeat;
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

<br><br><br><br><br><br><br>
<div class="page">
<form action="point.do" method="post">
<input type="text" name="point" value="${point.point}" style="text-align:right">
</form>
<a href="point.do?action=pointcheck&memberNum=1">
	<button>조회</button>
</a>
<a href="point.do?action=chargeForm&memberNum=1&point=${point.point}"><button>충전</button>
</a>
    </div>
           <div id="footer"></div>
     </div>

</body>
</html>