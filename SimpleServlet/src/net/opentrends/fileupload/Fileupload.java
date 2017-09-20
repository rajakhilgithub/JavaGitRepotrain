package net.opentrends.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Fileupload
 */
@WebServlet("/Fileuploadpath")
public class Fileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean ismp;
	private String filepath;
	private int maxfilesize=50*1024;
	private int maxMemSize = 4 * 1024;
	private File file ;
	public void init() {
		filepath=getServletContext().getInitParameter("file-upload");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		throw new ServletException("GET method used with " +
	            getClass( ).getName( )+": POST method required.");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ismp=ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		if(!ismp) {
			out.println("<h2>no files uploaded</h2>");
		}
		out.println("check");
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize);
		factory.setRepository(new File("~/Desktop/java/"));
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setSizeMax(maxfilesize);
		try {
			List fileitems = upload.parseRequest((RequestContext) request);
			Iterator i=fileitems.iterator();
			while(i.hasNext()) {
				FileItem f=(FileItem)i.next();
				if(!f.isFormField()) {
						String fieldName = f.getFieldName();
		               String fileName = f.getName();
		               String contentType = f.getContentType();
		               boolean isInMemory = f.isInMemory();
		               long sizeInBytes = f.getSize();
		               if( fileName.lastIndexOf("\\") >= 0 ) {
		                   file = new File( filepath + fileName.substring( fileName.lastIndexOf("\\"))) ;
		                } else {
		                   file = new File( filepath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		                }
		                f.write( file ) ;
		                out.println("<p>Uploaded Filename: " + fileName + "</p><br>");
				}
			}
		}catch(Exception ex) {
           out.println("<p>Error-"+ex.getMessage()+"</p>");
         }
	}

}
