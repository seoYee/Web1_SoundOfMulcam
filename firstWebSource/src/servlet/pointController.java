package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.pointService;
import vo.pointVO;

@WebServlet("/point.do")
public class pointController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		execute(req, resp);
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String viewPath = "";
		pointService service = pointService.getinstance();
		if (action.equals("payForm")) {
			// String a = request.getParameter("memberNum");
			// int b = Integer.parseInt(a);
			// pointVO vo = service.callPay(b);
			// request.setAttribute("plz",vo);
			viewPath = "point.jsp";
		} else if (action.equals("pointcheck")) {
			String pointcheck = request.getParameter("memberNum");
			int memberNum = 0;
			if (pointcheck != null && pointcheck.length() > 0) {
				memberNum = Integer.parseInt(pointcheck);
			}
			pointVO point = service.callPay(memberNum);
			request.setAttribute("point", point);
			viewPath = "point.jsp";

		} else if (action.equals("chargeForm")) {
			String memberNum = request.getParameter("memberNum");
			String a = request.getParameter("point");
			request.setAttribute("memberNum", memberNum);
			request.setAttribute("point", a);
			viewPath = "chargeForm.jsp";
		} else if (action.equals("pointCharge")) {
			String pointcheck = request.getParameter("memberNum");
			int a = Integer.parseInt(pointcheck);
			String point1 = request.getParameter("point");
			int b = Integer.parseInt(point1);
			String charge = request.getParameter("charge");
			int c = Integer.parseInt(charge);
			int d = b + c;
			int ttt = service.aaa(d, a);
			request.setAttribute("rrrr", ttt);
			viewPath = "point.jsp";

		}else if(action.equals("purchase")){
			String memberNumStr = request.getParameter("memberNum");
			int memberNum = Integer.parseInt(memberNumStr);
			String daysStr = request.getParameter("days");
			int days = Integer.parseInt(daysStr);
			double purchaseDouble = service.purchase(memberNum, days);
			if(purchaseDouble>0){
				BigDecimal purchase1 = new BigDecimal(purchaseDouble);
//				long l = bd.longValue();
				long a = purchase1.longValue();
				Date d = new Date();
				d.setTime(a);
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
				request.setAttribute("purchase", s.format(d));
				viewPath="complet.jsp";
				
			}else if(purchaseDouble==0){
				viewPath="fail.jsp";
			}
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
