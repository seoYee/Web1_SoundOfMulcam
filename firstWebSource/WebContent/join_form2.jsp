<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<html>
<head>
 <link rel="stylesheet" href="sub_style.css" type="text/css">
           <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  
<title>join_form2.jsp</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">


	$(function(){
		$('#password').keypress(function(){
			$('#target').html('');
		});
		
		$('#pwdConfirm').keyup(function(){
			if( $('#password').val() == $('#pwdConfirm').val() ){
				$('#target').html('비밀번호 일치');
			}else{
				$('#target').html('비밀번호 불일치');
			}
		});	
		
		$('form').submit(function(){
			if(document.getElementById("password").value==""){
				document.getElementById("password").focus();
// 				exit;
			}else if(document.getElementById("pwdConfirm").value==""){
				document.getElementById("pwdConfirm").focus();
// 				exit;
			}else if(document.getElementById("nickname").value==""){
				alert("nickname을 입력하세요")
				document.getElementById("nickname").focus();
// 				exit;
			}else if(document.getElementById("profileImg").value==""){
				alert("profile image 를 등록하세요.")
				document.getElementById("profileImg").focus();
// 				exit;
			}else{
				return true;
			}
			
			return false;
		})
	})
	
		
// 		function checkfield(){
		
// 			document.join.submit(); 
// 	}

	
	
</script>


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
	
.page{
	height: 100%;
	vertical-align: top;
	text-align: center;
}

.page a{
	text-decoration: none;
}

	
input[type=text]{
    border: none;
    border-bottom: 2px solid black;
    width: 500;
    height: 30;
}

input[type=password]{
    border: none;
    border-bottom: 2px solid black;
    width: 500;
    height: 30;
}

</style>

<%
	String id = (String) session.getAttribute("possibleId");
	
 %>

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
<form action="member.do" method="post" enctype="multipart/form-data">

  <table width="70%" align="center">
  		<tr>
  			<td>id: </td>
  			<td><%=id %>
  		</tr>
        <tr>
            <td>password:</td>
            <td><input type="password" id="password" name="password" size="20"></td>
        </tr>
        <tr>
            <td>password confirm:</td>
            <td><input type="password" id="pwdConfirm" size="20"></td>
        </tr>
        <tr>
        	<td>nickname:</td>
        	<td><input type="text" id="nickname" name="nickname" size="20"></td>
        </tr>
        <tr>
        	<td>profileImage:</td>
        	<td><input type="file" id="profileImg" name="profileImg"></td>
        </tr>
  </table>
  <br><br>
<input type="hidden" name="action" value="join">
  <input type="submit" value="join" >

  <input type="button" value="cancel" onclick="location.href='index.jsp'">
    <div id="target">비밀번호를 입력하시오.</div>
</div>
</div>

</form> 
</body>
</html>




