<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
    
<html>
<head>
<title>upload_form.jsp</title>
<link rel="stylesheet" href="upload_style.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<style>
#imagePreview {
    width: 350px;
    height: 350px;
    background-position: center center;
    background-size: cover;
    -webkit-box-shadow: 0 0 1px 1px rgba(0, 0, 0, .3);
    display: inline-block;
}

input[type=text]{
    border: none;
    border-bottom: 2px solid black;
    width: 500;
    height: 30;
}

.inform{
    font-size: 10pt;
}

input[type=text]:focus{
	border-bottom: 2px sloid #3e99d2;
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

        </c:if>
       </div>
    

<div id="wrap">
	<div class="upload">
	<br><br><br><br><br>
	<img src="upload.png"><br><br>

	<form action="file.do" method="post" enctype="multipart/form-data">
        
        <table class="formtable">
        <tr>
            <td rowspan="2"><div id="imagePreview">
            </div>
                <br><br><input id="fileUpload" type="file" name ="uploadImg" class="img" />
		</td>
            <td>
            <table class="inform">
                <tr>
                <td>파일 선택<br><input type="file" name="uploadFile"><br></td>
                </tr>
                <tr>
                <td><br>제목<br><input type = "text" name ="title"></td>
            </tr>
                        <tr>
            <td>앨범 이름<br><input type = "text" name ="album"><br></td>
            </tr>
                        <tr>
            <td>가수<br><input type = "text" name = "singer"><br>
            </td>
            </tr>
            </table>
            </td>

        </table>
        
        <br><input type="submit" value="업로드">	
	</form>
	</div>
	

<script>
$(document).ready(function() {
        $("#fileUpload").on('change', function() {
          //Get count of selected files
          var countFiles = $(this)[0].files.length;
          var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
          var image_holder = $("#imagePreview");
          image_holder.empty();
          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
            if (typeof(FileReader) != "undefined") {
              //loop for each file selected for uploaded.
              for (var i = 0; i < countFiles; i++) 
              {
                var reader = new FileReader();
                reader.onload = function(e) {
                  $("<img />", {
                    "src": e.target.result,
                    "class": "thumb-image",
                    "width":"350px",
                    "height":"350px"
                  }).appendTo(image_holder);
                }
                image_holder.show();
                reader.readAsDataURL($(this)[0].files[i]);
              }
            } else {
              alert("This browser does not support FileReader.");
            }
          } else {
            alert("Pls select only images");
          }
        });
      });
</script>
	
	<div id="footer">
       </div>
    
</div>
	
</body>
</html>