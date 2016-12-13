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
 
@WebServlet("/newsong.do")
public class NewController extends HttpServlet{
    private FileDao dao = FileDao.getInstance();
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String viewPath = "";
         
        if(action==null || action.equals("newList")){
            // 현재 서버에 업로드된 파일 목록 보여주기
            List<FileVO> newList = dao.selectNewList();
            req.setAttribute("newList", newList);
            viewPath = "newSong.jsp";

         
        RequestDispatcher dispatcher = 
            req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

    }
}

