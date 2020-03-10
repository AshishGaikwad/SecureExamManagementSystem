package batu.dev.sem.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploader
 */
@WebServlet("/FileUploader")
public class FileUploader extends HttpServlet {

	private boolean isMultipart = false;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		isMultipart = ServletFileUpload.isMultipartContent(request);
		MultipartData lMultipartData = null;
		
		System.out.println("");
		
		if (isMultipart)
		{
			lMultipartData = Util.getMultipartFromParam(request, response);
			

			String pFileUpload = Util.uploadFile(lMultipartData.getFileData(),"PermenantUploadLocation");
			
			response.getWriter().print(pFileUpload.substring(1));
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
