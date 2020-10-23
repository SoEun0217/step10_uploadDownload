package ex1023.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UpLoad")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���۵� ������ �ޱ�
		/*
		 * String name=request.getParameter("name"); String
		 * subject=request.getParameter("subject"); String
		 * file=request.getParameter("file");
		 * 
		 *   - ������ enctype="multipart/form-data"�� �����Ǹ�
		 *   requset�� �����͸� ���� �� ����.
		 *   cos.jar���� �����Ǵ� Ŭ������ �̿��Ѵ�.
		 */
		String saveDir=request.getServletContext().getRealPath("/save");//realPath�� ���������� ����Ǵ� ��
		int maxSize=1024*1024*100;//100M
		String encoding="UTF-8";
		
		MultipartRequest m= new MultipartRequest(request, saveDir,maxSize,encoding,new DefaultFileRenamePolicy());
		
		String name=m.getParameter("name"); 
		String subject=m.getParameter("subject"); 
		String file=m.getParameter("file");
		String systemfileName = m.getFilesystemName("file");
		String originalFileName = m.getOriginalFileName("file");
		
		//������ ����
		File f = m.getFile("file");
		long fileSize = f.length();
		
		//�����������Ѵٸ� ���ϸ�ڿ� ���ں��̱�
		System.out.println("name : "+ name);//jsp���� ${requestScope.name}
		System.out.println("subject : "+ subject);
		System.out.println("file : "+ file);
		System.out.println("systemfileName : "+systemfileName);
		System.out.println("originalFileName : "+originalFileName);
		System.out.println("fileSize  : "+fileSize);
		
		//��� �̵��ϱ����� �������� ���޵� ������ ����
		request.setAttribute("name", name);
		request.setAttribute("subject",subject);
		request.setAttribute("systemfileName", systemfileName);
		request.setAttribute("originalFileNameme", originalFileName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("saveDir", saveDir);
		
		request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
		
	}

}
