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
		
		//save ���� �ȿ� �ִ� ������ �̸��� ��� �����´�.
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
