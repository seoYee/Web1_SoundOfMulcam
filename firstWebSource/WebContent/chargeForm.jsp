<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <link rel="stylesheet" href="sub_style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>chargeForm</title>

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
<input type="radio" name="charge" value="1000"> 1000<br>
<input type="radio" name="charge" value="2000"> 2000<br>
<input type="radio" name="charge" value="3000"> 3000<br>       
<input type="radio" name="charge" value="4000"> 4000<br>
<input type="radio" name="charge" value="5000"> 5000<br><br>

<input type="hidden" name="action" value="pointCharge">
<input type ="hidden" name="memberNum" value="<%=request.getParameter("memberNum") %>">
<input type ="hidden" name="point" value="<%=request.getParameter("point") %>">
<input type="submit" value="충전">
</form>

    </div>
           <div id="footer"></div>
     </div>

</body>
</body>
</html>