package servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.FileDao;
import vo.FileVO;

@WebServlet("/download.do")
public class DownController extends HttpServlet {
	private FileDao dao = FileDao.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileNumStr = req.getParameter("fileNum");
		int fileNum=0;
		if(fileNumStr!=null&&fileNumStr.length()>0){
			fileNum = Integer.parseInt(fileNumStr);
		}
////////////////////////////////////////////////////////////		
		FileVO fileVO = dao.selectFile(fileNum);//파일정보조회
		
		String fileURL = fileVO.getSavedPath();//서버저장경로

		resp.setHeader(""
				+ "", 
				"attachment;filename=" + 
				new String(fileVO.getFileName().getBytes(), "ISO8859_1"));

		FileInputStream fis = new FileInputStream(fileURL);
		ServletOutputStream sos = resp.getOutputStream();

		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fis.read(buf)) != -1) {
			sos.write(buf, 0, size);
			sos.flush();
		}
		fis.close();
		sos.close();
	}
}

