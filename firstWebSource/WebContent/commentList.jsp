<%@page import="vo.CommentVO"%>
<%@page import="vo.CommentPageVO"%>
<%@page import="service.CommentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>commentList.jsp</title>

<style>
#wrap2{
	width: 90%;
	margin: auto;
	align-self: center;
    border: none;
    width: 95%;
    margin: auto;
    border: none;
    font-size: 10pt;
    border-collapse: collapse;
}

#rp{
    border: none;
    border-bottom: 2px solid black;
}

</style>


</head>
<body>

<div id="wrap2" width="95%" align="center">
	<%
		// 	CommentVO c = new CommentVO();
		// 	c = (CommentVO)request.getAttribute("commentPage"); 
		// List<CommentVO> commentList = new ArrayList<CommentVO>();
		// commentList = (CommentVO)request.getAttribute("commentPage");
		// 		int musicNum = 14;
		String musicNumStr = (String) request.getAttribute("musicNum");
		int musicNum = Integer.parseInt(musicNumStr);
		String nickname = (String) request.getAttribute("nickname");
		String profileImg = (String) request.getAttribute("profileImg");
		CommentService service = CommentService.getInstance();
		CommentPageVO commentPage = service.makePage(musicNum);
		
		for (CommentVO comments : commentPage.getCommentList()) {
			if (comments.getseq() == 1) {
	%>
<table>
<tr>
		<td><br>&nbsp; <img src="profileimage.jpg"><%=comments.getWriteDate()%><br>&nbsp;&nbsp;<%=comments.getNickname()%>
		&nbsp;:&nbsp;<%=comments.getContent()%><br></td></tr>
	<tr><td>
	<form name="reply" method="post" action="comment.do?action=reply&musicNum=<%=musicNum%>">
		<textarea id="rp" rows="1" cols="55" name="reply" placeholder="Write a reply"></textarea>
		<input type="hidden" name="musicNum"	value="<%=comments.getMusicNum()%>">
		 <input type="hidden" name="nickname" value="<%=session.getAttribute("nickname")%>">
		<input type="hidden" name="profileImg"	value="<%=session.getAttribute("profileImg")%>"> 
		<input type="hidden" name="parentCommentNum"value="<%=comments.getCommentNum()%>">
		 <input type="submit"id="submitBtn" value="Reply" /></td>
	</form>
</tr>	
	</table>
	<%
		} else {
	%>

<table>
<tr>
		<td><br>&nbsp; <img src="b_play.png"><img
			src="profileimage.jpg"><%=comments.getWriteDate()%><br>&nbsp;&nbsp;<%=comments.getNickname()%>
		&nbsp;:&nbsp;<%=comments.getContent()%><br></td></trr>
	<tr><td>
	<form name="reply" method="post" action="comment.do?action=reply">
		<textarea id="rp" rows="1" cols="55" name="reply" placeholder="Write a reply"></textarea>
		<input type="hidden" name="musicNum"	value="<%=comments.getMusicNum()%>">
		<input type="hidden" name="nickname" value="<%=session.getAttribute("nickname")%>">
		<input type="hidden" name="profileImg" value="<%=session.getAttribute("profileImg")%>">
		<input type="hidden" name="parentCommentNum" value="<%=comments.getCommentNum()%>">
		<input type="submit" id="submitBtn" value="Reply" /></td></tr>
	</form>
	</tr>
	</table>
	<%
		}
		}
	%>
</div>
</body>
</html>