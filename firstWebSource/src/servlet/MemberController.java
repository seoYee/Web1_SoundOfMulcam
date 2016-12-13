
//package servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//
//import service.MemberService;
//import vo.MemberVo;
//
//@WebServlet("/member.do")
//public class MemberController extends HttpServlet {
//	private MemberService service = MemberService.getInstance();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		execute(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("EUC-KR");
//		execute(req, resp);
//	}
//
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		String viewPath = "";
//		
//		
//		// 가입 누르면 네이버 로그인 또는 그냥 가입 선택화면으로 이동
//		if (action.equals("joinForm1")) {
//			viewPath = "join_form1.jsp";
//
//		} else if (action.equals("joinForm2")) {
//			String id = request.getParameter("id");
//			switch (service.joinCheck(id)) {
//			case "alreadyJoin":
//				// 알림창띄우고 다시 메인 화면으로 돌아가게끔 구현
//				viewPath = "alreadyJoin.jsp";
//				break;
//			case "joinToNaver":
//				viewPath = "joinToNaver.jsp";
//				break;
//			case "joinPossible":
//				HttpSession session = request.getSession();
//				session.setAttribute("possibleId", id);
//				viewPath = "join_form2.jsp";
//				break;
//			}
//		} else if (action.equals("join")) {
//			HttpSession session = request.getSession();
////			System.out.println((String)session.getAttribute("possibleId"));
////			System.out.println(request.getParameter("password"));
//			
//	        String uploadFolder = getServletContext().getRealPath("/")+"/files/";
//	        MultipartRequest mRequest = new MultipartRequest
//	                (request, uploadFolder, 10240 * 10240 * 5, 
//	                "EUC-KR", new DefaultFileRenamePolicy());			
//	                
//			
//			MemberVo member = new MemberVo();
//			member.setId((String)session.getAttribute("possibleId"));
//			member.setPassword(request.getParameter("password"));
//			member.setNickname(request.getParameter("nickname"));
//			member.setProfileImg(request.getParameter("profileImg"));
//			member.setPoint(0); //초기값을 0으로 한다.
//			member.setNaverJoin(0); // naverlogin인지 여부. 1이 yes, 0이 no\
//			
//			
//			if (service.join(member) == true) {
//				viewPath = "join_success.jsp";
//			} 
//			
//			
//			
//		}else if (action.equals("login")) {
//			String id = request.getParameter("id");
//			String pw = request.getParameter("password");
//			MemberVo loginUserInfo = service.loginUserInfo(id, pw);
//			
//			if (service.login(id, pw) == true) {
//				HttpSession session = request.getSession();
//				session.setAttribute("loginId", loginUserInfo.getId());
//				session.setAttribute("password", loginUserInfo.getPassword());
//				session.setAttribute("nickname", loginUserInfo.getNickname());
//			}
//			viewPath = "login_result.jsp";
//		} else if (action.equals("logout")) {
//			HttpSession session = request.getSession();
//			session.invalidate();
//			viewPath = "logout.jsp";
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//		dispatcher.forward(request, response);
//	}
//}

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.MemberService;
import vo.MemberVo;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private MemberService service = MemberService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("들어왔니");
		// FIXME UploadFolder Path
		String action = req.getParameter("action");
		System.out.println("fasdjkfhasdkj"+action);
		String viewPath = "";

		if (action==null) {
			String uploadFolderPath = getServletContext().getRealPath("/")+"/files/";
			MultipartRequest mreq = new MultipartRequest(req, uploadFolderPath, 10240 * 10240 * 5, "UTF-8",
					new DefaultFileRenamePolicy());
			//
			HttpSession session = req.getSession();
			System.out.println((String) session.getAttribute("possibleId"));
			String id = (String) session.getAttribute("possibleId");

			String password = mreq.getParameter("password");
			String nickname = mreq.getParameter("nickname");
			String fileName = mreq.getFilesystemName("profileImg");
			String profileImgPath = uploadFolderPath + "/" + fileName;

			MemberVo member = new MemberVo();
			member.setId(id);
			member.setPassword(password);
			member.setNickname(nickname);

			member.setprofileImgPath(profileImgPath);

			member.setPoint(0); // 초기값을 0으로 한다.
			member.setNaverJoin(0); // naverlogin인지 여부. 1이 yes, 0이 no\
			viewPath = "";
			if (service.join(member) == true) {
				viewPath = "join_success.jsp";
			}
		}else if (action.equals("joinForm1")) {
			System.out.println("??");
			viewPath = "join_form1.jsp";

		} else if (action.equals("joinForm2")) {
			String id = req.getParameter("id");
			switch (service.joinCheck(id)) {
			case "alreadyJoin":
				// 알림창띄우고 다시 메인 화면으로 돌아가게끔 구현
				viewPath = "alreadyJoin.jsp";
				break;
			case "joinToNaver":
				viewPath = "joinToNaver.jsp";
				break;
			case "joinPossible":
				HttpSession session = req.getSession();
				session.setAttribute("possibleId", id);
				viewPath = "join_form2.jsp";
				break;
			}

		} else if (action.equals("login")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("password");
			MemberVo loginUserInfo = service.loginUserInfo(id, pw);

			if (service.login(id, pw) == true) {
				HttpSession session = req.getSession();
				session.setAttribute("loginId", loginUserInfo.getId());
				session.setAttribute("password", loginUserInfo.getPassword());
				session.setAttribute("nickname", loginUserInfo.getNickname());
			}
			viewPath = "login_result.jsp";
			
		} else if (action.equals("logout")) {
//			HttpSession session = req.getSession();
//			session.invalidate();
			viewPath = "logout.jsp";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}

}


