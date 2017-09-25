package shangchuan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload.do")
@MultipartConfig(fileSizeThreshold = 5_242_880, // 5MB
maxFileSize = 20_971_520L, // 20MB
maxRequestSize = 43_943_040L )// 40MB
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Part filepart =request.getPart("file");
     InputStream inputStream = filepart.getInputStream();
     OutputStream outputStream = new FileOutputStream("/Users/zhangxiaochuan/"+filepart.getSubmittedFileName());
     int read;
     final byte [] bytes = new byte[1024];
     while((read = inputStream.read(bytes))!= -1) {
    	  outputStream.write(bytes, 0, read);
     }
     outputStream .flush();
     outputStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
