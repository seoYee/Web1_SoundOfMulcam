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
 
@WebServlet("/file.do")
public class FileController extends HttpServlet{
    private FileDao dao = FileDao.getInstance();
     
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String viewPath = "";
         
        if(action==null || action.equals("fileList")){
            // 현재 서버에 업로드된 파일 목록 보여주기
            List<FileVO> fileList = dao.selectFileList();
            req.setAttribute("fileList", fileList);
            viewPath = "file_list.jsp";
        } else if(action.equals("uploadForm")){
            viewPath = "upload_form.jsp";
        }
         
        RequestDispatcher dispatcher = 
            req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    // 파일 업로드 될때에는 post 방식이므로 doPost가 실행됨.
        request.setCharacterEncoding("EUC-KR");
        
//        String contentType1 = request.getContentType();
//        
//        System.out.println("이건찍는다 "+ contentType1.toLowerCase());
        
         
        
        
        String uploadFolder = getServletContext().getRealPath("/")+"/files/";
        MultipartRequest mRequest = new MultipartRequest
                (request, uploadFolder, 10240 * 10240 * 5, 
                "EUC-KR", new DefaultFileRenamePolicy());
        
//        Collection<Part> parts = request.getParts();
//        
//        for(Part part : parts){
//        	
//        	String contentType = part.getContentType();
//        	
//        	System.out.println("컨텐츠 타입 알아낸다"+contentType);
//        }
        
        String title = mRequest.getParameter("title");
    	String album =mRequest.getParameter("album");
    	String singer = mRequest.getParameter("singer");
        
        System.out.println(title);
        System.out.println(album);
        System.out.println(singer);
        
 
        // 서버폴더에 저장되는 문장
        File file = mRequest.getFile("uploadFile"); 
        File img =mRequest.getFile("uploadImg");
 
//         폴더에 저장된 파일 정보를 DB에 insert 시키기
        
        
        FileVO fileVO = new FileVO();
        fileVO.setMp3Name(mRequest.
                getOriginalFileName("uploadFile"));//음악 원래이름
        fileVO.setFileName(mRequest.getOriginalFileName("uploadImg")); //이미지 원래이름
        fileVO.setSavedPath(file.getAbsolutePath());//저장경로
        fileVO.setSavedImgPath(img.getAbsolutePath());
        fileVO.setTitle(title);
        fileVO.setAlbum(album);
        fileVO.setSinger(singer);
         
        int result = dao.insert(fileVO);
        
        System.out.println("왜안오지?"+result);
         
        // DB 작업 결과를 request에 기록해서 forward
        request.setAttribute("uploadResult", result);
         
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("upload_result.jsp");
            dispatcher.forward(request, resp);
    }
}

