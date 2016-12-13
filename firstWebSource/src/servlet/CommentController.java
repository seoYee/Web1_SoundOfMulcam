package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.FileDao;
import service.CommentService;
import vo.CommentPageVO;
import vo.CommentVO;
import vo.FileVO;

@WebServlet(urlPatterns = "/comment.do")
public class CommentController extends HttpServlet {
	FileDao dao = FileDao.getInstance();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form 태그에서 post방식으로 넘어오는 한글파라미터 인코딩
		req.setCharacterEncoding("UTF-8");
		execute(req, resp);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String viewPath = "";
		CommentService commentService = CommentService.getInstance();
		
		
		
		if (action == null || action.equals("main")) {
			viewPath = "main.jsp";

		} else if (action.equals("musicPage")) {
			int musicNum = Integer.parseInt(request.getParameter("musicNum"));
			String nickname = request.getParameter("nickname");
			// System.out.println("musicnum"+musicNum);
			// System.out.println("nickname"+nickname);
			String profileImg = request.getParameter("profileImg");
			CommentPageVO commentPage = commentService.makePage(musicNum);

			request.setAttribute("commentPage", commentPage);
			request.setAttribute("musicNum", musicNum);
			request.setAttribute("nickname", nickname);
			request.setAttribute("profileImg", profileImg);

			viewPath = "musicPage.jsp";

		} else if (action.equals("write")) {
			String musicNumStr = null;
			musicNumStr = request.getParameter("musicNum");
			int musicNum = Integer.parseInt(musicNumStr);
			String nickname = request.getParameter("nickname");
			String profileImg = request.getParameter("profileImg");
			String content = request.getParameter("content");
			CommentVO comment = new CommentVO();

			comment.setMusicNum(musicNum);
			comment.setNickname(nickname);
			comment.setProfileImg(profileImg);
			comment.setContent(content);
		
			int result = commentService.insert(comment);
			request.setAttribute("writeResult", result);
			viewPath = "cwrite.jsp";

			// } else if (action.equals("read")) {
			// String articleIdStr = request.getParameter("articleId");
			// int articleId = 0;
			//
			// if (articleIdStr != null && articleIdStr.length() > 0) {
			// articleId = Integer.parseInt(articleIdStr);
			// }
			//
			// ArticleVO article = boardService.read(articleId);
			//
			// request.setAttribute("article", article);
			// viewPath = "read.jsp";

			// } else if (action.equals("updateForm")) {
			// String articleIdStr = request.getParameter("articleId");
			// int articleId = 0;
			// if (articleIdStr != null && articleIdStr.length() > 0) {
			// articleId = Integer.parseInt(articleIdStr);
			// }
			//
			// ArticleVO original =
			// boardService.readWithoutReadCount(articleId);
			// request.setAttribute("original", original);
			// viewPath = "update_form.jsp";
			//
			// } else if (action.equals("update")) {
			// String title = request.getParameter("title");
			// String content = request.getParameter("content");
			// String password = request.getParameter("password");
			// String articleIdStr = request.getParameter("articleId");
			// int articleId = 0;
			//
			// if (articleIdStr != null && articleIdStr.length() > 0) {
			// articleId = Integer.parseInt(articleIdStr);
			// }

			// ArticleVO article = new ArticleVO();
			// article.setArticleId(articleId);
			// article.setTitle(title);
			// article.setContent(content);
			// article.setPassword(password);
			//
			// int result = boardService.modify(article);
			// request.setAttribute("updateResult", result);
			// viewPath = "update_result.jsp";
			//
			// } else if (action.equals("deleteForm")) {
			// viewPath = "delete_form.jsp";
			//
			// } else if (action.equals("delete")) {
			// String articleIdStr = request.getParameter("articleId");
			// int articleId = 0;
			//
			// if (articleIdStr != null && articleIdStr.length() > 0) {
			// articleId = Integer.parseInt(articleIdStr);
			// }
			// String password = request.getParameter("password");
			//
			// int result = boardService.remove(articleId, password);
			// request.setAttribute("deleteResult", result);
			// viewPath = "delete_result.jsp";
			//
			// } else if (action.equals("replyForm")) {
			// String articleIdStr = request.getParameter("articleId");
			// int articleId = 0;
			// if (articleIdStr != null && articleIdStr.length() > 0) {
			// articleId = Integer.parseInt(articleIdStr);
			// }
			// request.setAttribute("articleId", articleId);
			// viewPath = "reply_form.jsp";
		} else if (action.equals("reply")) {
			String parentCommentNumStr = null;
			parentCommentNumStr = (String) request.getParameter("parentCommentNum");
			int parentCommentNum = Integer.parseInt(parentCommentNumStr);
			String musicNumStr = null;
			musicNumStr = request.getParameter("musicNum");
			int musicNum = Integer.parseInt(musicNumStr);
			FileVO selected = dao.selectFile(musicNum);
			System.out.println("다오셀렉후"+selected);
			String nickname = request.getParameter("nickname");
			String profileImg = request.getParameter("profileImg");
			String content = request.getParameter("reply");

			CommentVO reply = new CommentVO();
			reply.setMusicNum(musicNum);
			reply.setNickname(nickname);
			reply.setProfileImg(profileImg);
			reply.setContent(content);
			
        	
			commentService.insertReply(reply, parentCommentNum);
            request.setAttribute("selectedMusic", selected);
            request.setAttribute("musicNum", musicNumStr);

			viewPath = "musicPage.jsp";
		} else if (action.equals("selected")) {
			String strNum = request.getParameter("musicNum");
			System.out.println("strNum:"+strNum);
			int musicNum = Integer.parseInt(strNum);
			System.out.println("musicNum:"+musicNum);
			
			System.out.println("액션:"+action);
//			CommentPageVO commentPage = commentService.makePage(musicNum);
//			List<CommentVO> commentPage = dao.selectCommentList(musicNum);
//			request.setAttribute("commentPage", commentPage);
			request.setAttribute("musicNum", strNum);
			viewPath="commentList.jsp";
//			
//			System.out.println("여긴?"+musicNum);
//			
//			System.out.println(commentPage);
//			if(commentPage==null){
//				System.out.println("무슨일이야?");
//			}

	}else if(action.equals("aaa")){
		viewPath="main.jsp";
	}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
}
}

