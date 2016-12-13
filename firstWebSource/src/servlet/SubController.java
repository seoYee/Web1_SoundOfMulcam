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
 
@WebServlet("/subpage.do")
public class SubController extends HttpServlet{
    private FileDao dao = FileDao.getInstance();
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String strNum = req.getParameter("num").toString();        
        int songNum = Integer.parseInt(strNum);
        System.out.println(songNum);
        String viewPath = "";

        
        if(action==null || action.equals("selected")){

        	FileVO selected = dao.selectFile(songNum);
        	
            req.setAttribute("selectedMusic", selected);
            viewPath = "musicPage.jsp";
        }
         
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
}

