<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>file_list.jsp</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
						<script type="text/javascript">
var win;
// function go_pop(name){
// 	if(!win){
// 		sessionStorage.setItem("musicList",name)
// 	   win =  window.open("alone03.jsp?action=play&fileNum="+name,"new","width=370, height=360, resizable=no, scrollbars=no, status=no, location=no, directories=no;");
// 	    var a = $('#btnPreview').val();	
// 	}else{
// 			win.focus();
// 	}
// }
function go_pop(name){
// 	if(!win){
	   win =  window.open("alone.jsp?action=play&fileNum="+name,"new","width=350, height=300, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	
	   pass();
	   // 	}else{
// 		popup.call(name);
// 		win.focus(); 
// 	}
}

function pass(){
	location.href="top10.do?action=playcount&num="+'${selectedMusic.fileNum}';
// 	location.href="upload_form.jsp";
}


// function go_pop(name){
	
// 	   win =  window.open("alone03.jsp?action=play&fileNum="+name,"new","width=450, height=450, resizable=no, scrollbars=no, status=no, location=no, directories=no;");	

// 		popup.call(name);
// 		win.focus(); 
	
// }
    
	
</script>

<style type="text/css">
a{
	text-decoration:none;
	color:black;
}

</style>

</head>
<body>
<%String a = "files/"; %>

<div class="top10">
<br><br>
<img src=main_top10.png><br><br>

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
               
		<c:if test="${empty requestScope.top10List}">
			<tr>
				<td colspan="8">오류났어</td>
			</tr>
		</c:if>
		<c:if test="${not empty requestScope.top10List}">
			<c:forEach var="file" items="${top10List}" varStatus="status">
				<tr>
					<td class="rank"><h1>${status.count}</h1></td>
					<td class="cover"><a href="subpage.do?action=selected&num=${file.fileNum}" style="text-decoration:none">
							<img src="<%=a %>${file.fileName}"></a>
							
							</td>
					<td class="title"><a href="subpage.do?action=selected&num=${file.fileNum}">${file.title}</a></td>
					<td class="artist" style="padding-left:10px">${file.singer}</td>
					<td class="album" width="100px" style="padding-left:10px">${file.album}</td>
<%-- 					<td class="icon" style="padding-left:20px"><a href="top10.do?action=play&fileNum=${file.fileNum}" ><img src="b_play.png"></a></td> --%>
						<td class="icon" style="padding-left:20px"><a id="btn_play" href="#" onClick="window.go_pop('${file.mp3Name}')" ><img src="b_play.png">
						</a></td>

					<td class="icon"><a href="add.do?fileNum=${file.fileNum}"><img src="b_add.png"></a></td>
					<td class="icon"><a href="like.do?fileNum=${file.fileNum}"><img src="b_like.png"></a></td>
					</c:forEach>
				</tr>
		</c:if>
	</table>
	
	<form name="pass" action="top10.do">
	<input type="hidden" value="playcount"> 
	<input type ="hidden" value ="${file.Num}">
	</form>
	
	<br>
	
	<a href="http://70.12.109.117:8888/Day20/top10.do?action=chartList"><button id="more">view more</button></a>
</div>
</body>
</html>

