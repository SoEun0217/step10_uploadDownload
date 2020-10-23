package ex1023.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileList")
public class FileDownListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//save 폴더 안에 있는 파일의 이름을 모두 가져온다.
		String saveDir=
				request.getServletContext().getRealPath("/save");
		
		File file = new File(saveDir);
		if(file.exists()) {
			if(file.isDirectory()) {
				String fileNames [] = file.list();
				request.setAttribute("fileNames", fileNames);
			}
		}
		
		request.getRequestDispatcher("downList.jsp").forward(request, response);
	}

}
