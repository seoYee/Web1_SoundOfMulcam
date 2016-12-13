package servlet;
 
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.Part;


import dao.FileDao;
import vo.FileVO;
 
@WebServlet("/top10.do")
public class TopController extends HttpServlet{
    private FileDao dao = FileDao.getInstance();
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String viewPath = "";
         
        if(action==null || action.equals("top10List")){
            // 현재 서버에 업로드된 파일 목록 보여주기
            List<FileVO> top10List = dao.selectTopList();
            req.setAttribute("top10List", top10List);
            viewPath = "top10.jsp";
        }else if (action.equals("play")){
        	 FileVO vo = new FileVO();
        	String a = req.getParameter("fileNum");
        	int fileNum = 1;
        	fileNum = Integer.parseInt(a);
        	
        	vo = dao.selectFile(fileNum);
        	req.setAttribute("fileNum", vo);
        	viewPath = "alone.jsp";
        }else if(action.equals("chartList")){
        	List<FileVO> chartList = dao.selectChartList();
        	req.setAttribute("chartList", chartList);
        	viewPath= "chart.jsp";
        	
        	}else if(action.equals("playcount")){
        		System.out.println("여기온다~");
        		
        	}
         
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
}

