<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>main.jsp</title>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="main_style.css" />

<script>
$(document).ready(function(){
	$(".top10").load("http://70.12.109.117:8888/Day20/top10.do?action=top10List")
	$(".newsong").load("http://70.12.109.117:8888/Day20/newsong.do?action=newList")
	
	return false;
});
</script>

<style>

input[type=search]{
    width: 50;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 3px solid white;
    -webkit-transition: 0.5s;
    transition:0.5s;
    border-radius: 15px;
    box-sizing: border-box;
    outline: none;
    background-color: rgba(0,0,0,0.8);
    color: white;
    background-image: url('serchicon.png');
    background-position: 10px 10px;
    background-repeat: no-repeat;
}

input[type=search]:focus{
	border: 3px solid #3e99d2;
}


</style>

</head>
<body>

   <div id="wrap">
       <div id=line></div>
       <div id="header">
           <li class="home">
           <a href="index.html"><img src="main_logo.png"></a></li>
                   <c:if test="${not empty sessionScope.loginId }">
        <li class="right"><a href="payment.jsp">TICKET</a></li>
         <li class="right"><a href="http://70.12.109.117:8888/Day20/point.jsp">POINT</a></li>
        </c:if>
         <c:if test="${empty sessionScope.loginId }">
        <li class="right"><a href="http://70.12.109.117:8888/Day20/join_form1.jsp"><button>JOIN US</button></a></li>
        <li class="right"><a href="login_form.jsp">LOGIN</a></li>
        </c:if>
        <c:if test="${not empty sessionScope.loginId }">
        <li class="right"><a href="logout.jsp">LOGOUT</a></li>
        </c:if>
        
       </div>

        <div class="search">
            <img src="find.png">
        <form method="get" action="/search" id="search">
            <input name="q" type="search" size="50" placeholder="Search for artists, bands, tracks"/>
        </form>
            
       </div>
       
       <div id="imageslider">
           <img class="mySlide" src="slideimg-04.jpg" style="width:100%" alt>
           <img class="mySlide" src="slideimg-05.jpg" style="width:100%" alt>
           <img class="mySlide" src="slideimg-01.jpg" style="width:100%" alt>
           <img class="mySlide" src="slideimg-02.jpg" style="width:100%" alt>
           <img class="mySlide" src="slideimg-03.jpg" style="width:100%" alt>
       </div>
       

       
       <script>
       var myIndex=0;
         carousel();
         
         function carousel(){
             var i;
             var x= document.getElementsByClassName("mySlide");
             for(i=0; i<x.length; i++){
                 x[i].style.display="none";
             }
             myIndex++
             if(myIndex>x.length){
                 myIndex=1;
             }
             x[myIndex-1].style.display="block";
             setTimeout(carousel,5000);
         }
           
        </script>
        

       <div class="top10"></div>
    
       
    <div class="newsong"></div>
       

       <div id="footer">
       </div>
  
   </div>
</body>
</html>