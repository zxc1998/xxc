package xiazai;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dowload
 */
@WebServlet("dowload.do")
public class dowload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dowload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream inputStream = new FileInputStream("/Users/zhangxiaochuan/Servlet.pages/");
				BufferedInputStream bufferedInputStream = new  BufferedInputStream(inputStream);
	
		byte[] file = new byte[ bufferedInputStream.available()];
		bufferedInputStream.read(file,0,bufferedInputStream.available());
		bufferedInputStream.close();
		response.setHeader("Content-Dispositoin", "attachment : filename="  +"Servlet.pages");
		response.setContentType("application/octet-stream");
		ServletOutputStream stream = response.getOutputStream() ;
		stream.write(file);
		stream.flush();
		stream.close();
				}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
