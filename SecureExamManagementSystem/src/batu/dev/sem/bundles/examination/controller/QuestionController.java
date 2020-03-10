package batu.dev.sem.bundles.examination.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.bundles.examination.dao.QuestionDao;
import batu.dev.sem.bundles.examination.dao.SubjectDao;
import batu.dev.sem.bundles.examination.daoimpl.QuestionDaoImpl;
import batu.dev.sem.bundles.examination.daoimpl.SubjectDaoImpl;
import batu.dev.sem.bundles.examination.entity.QuestionEntity;
import batu.dev.sem.utils.MultipartData;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class QuestionController
 */
@WebServlet("/QuestionController")
public class QuestionController extends HttpServlet {

	UserEntity lUserEntity = null;

	private SubjectDao lSubjectDao = new SubjectDaoImpl();
	private QuestionDao lQuestionDao = new QuestionDaoImpl();
	private Gson gson = new Gson();
	private boolean isMultipart = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		lUserEntity = (UserEntity) request.getSession().getAttribute("USER_ENTITY");
		isMultipart = ServletFileUpload.isMultipartContent(request);
		MultipartData lMultipartData = null;

		String FormType = "";
		if (!isMultipart)
			FormType = request.getParameter("FormType");
		else {
			lMultipartData = Util.getMultipartFromParam(request, response);
			Map<String, String> lMultipartFormField = lMultipartData.getFormData();

			if (lMultipartFormField.get("FormType") != null) {
				FormType = lMultipartFormField.get("FormType");
			}
		}

		switch (FormType) {
		case "SaveQuestion":
			save(request, response);
			break;
		case "UploadBulkQuestion":
			uploadBulkQuestion(request, response, lMultipartData);
			break;
//		case "DeleteSubject":
//			delete(request, response);
//			break;
//		case "GetSubject":
//			get(request, response);
//			break;

		case "FetchSubjects":
			fetchSubject(request, response);
			break;
		case "FetchQuestionsOnSubjects":
			fetchQuestionsOnSubjects(request, response);
			break;

		case "FetchQuestion":
			fetchQuestion(request, response);
			break;

		case "FetchSubjectQuestionDetails":
			fetchSubjectQuestionDetails(request, response);
			break;

		default:
			break;
		}
	}

	private void fetchSubjectQuestionDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter()
					.print(lQuestionDao.getSubjectQuestionDetails(Long.parseLong(request.getParameter("SubjectId"))));
		} catch (Exception e) {
			try {
				response.getWriter().print("[]");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private void uploadBulkQuestion(HttpServletRequest request, HttpServletResponse response,
			MultipartData lMultipartData) {
		String uploadFilePath = Util.getProperty("Config", "fileUploadLocation");
		String pFileUpload = Util.uploadFile(lMultipartData.getFileData());
		Map<String, String> formData = lMultipartData.getFormData();
		String subId = formData.get("SubjectList");

		int success = 0;
		int failed = 0;
		String resp = "Failed Line No : ";
		try (Workbook book = WorkbookFactory.create(new File(uploadFilePath + pFileUpload))) {

			Sheet sheet = book.getSheetAt(0);

			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				try {
					Row row = sheet.getRow(i);

					QuestionEntity lQuestionEntity = new QuestionEntity();
					lQuestionEntity.setSubjectId(Long.parseLong(subId));

					lQuestionEntity.setQuestion(row.getCell(1).getStringCellValue());
					lQuestionEntity.setMarks((int) row.getCell(2).getNumericCellValue());

					JSONArray body = new JSONArray();

					JSONObject body1 = new JSONObject();
					body1.put("id", 1);
					body1.put("value", row.getCell(3).getStringCellValue());
					body.put(body1);

					JSONObject body2 = new JSONObject();
					body2.put("id", 2);
					body2.put("value", row.getCell(4).getStringCellValue());
					body.put(body2);

					JSONObject body3 = new JSONObject();
					body3.put("id", 3);
					body3.put("value", row.getCell(5).getStringCellValue());
					body.put(body3);

					JSONObject body4 = new JSONObject();
					body4.put("id", 4);
					body4.put("value", row.getCell(6).getStringCellValue());
					body.put(body4);

					lQuestionEntity.setCorrectAnswer((int) row.getCell(7).getNumericCellValue());
					lQuestionEntity.setOptions(body.toString());

					lQuestionDao.create(lQuestionEntity);
					success++;
				} catch (Exception e) {
					e.printStackTrace();
					failed++;
					resp = resp + " " + i + ",";
//					response.getWriter().print("Uploaded  Questions remarks successfully");
				}

			}

			response.getWriter().println("Uploaded  Status : ");
			response.getWriter().println("Successful : " + success);
			response.getWriter().println("Failed : " + failed);
			response.getWriter().println("" + resp);

			if (new File(uploadFilePath + pFileUpload).delete())
				System.out.println("File Deleted successfully");
//			Scanner fileScanner = new Scanner(new File(uploadFilePath+pFileUpload));
//			long success = 0;
//			long failed = 0;
//			
//			int counter = 0;
//			fileScanner.nextLine();
//			while(fileScanner.hasNextLine())
//			{
//
//		
//				
//					
//					
//					
//					String [] data = fileScanner.nextLine().split(",");
//					System.out.println(Arrays.toString(data));
//					QuestionEntity lQuestionEntity = new QuestionEntity();
//					lQuestionEntity.setSubjectId(Long.parseLong(subId));
//					
//					lQuestionEntity.setQuestion(data[1]);
//					lQuestionEntity.setMarks(Integer.parseInt(data[2]));
//					
//					JSONArray body = new JSONArray();
//					
//					JSONObject body1 = new JSONObject();
//					body1.put("id", 1);
//					body1.put("value", data[3]);
//					body.put(body1);
//					
//					JSONObject body2 = new JSONObject();
//					body2.put("id", 2);
//					body2.put("value", data[4]);
//					body.put(body2);
//					
//					JSONObject body3 = new JSONObject();
//					body3.put("id", 3);
//					body3.put("value", data[5]);
//					body.put(body3);
//					
//					JSONObject body4 = new JSONObject();
//					body4.put("id", 4);
//					body4.put("value", data[6]);
//					body.put(body4);
//					
//					
//					lQuestionEntity.setCorrectAnswer(Integer.parseInt(data[7]));
//					lQuestionEntity.setOptions(body.toString());
//					
//					
//					lQuestionDao.create(lQuestionEntity);
//					success++;
//				
//			}
//			
//			response.getWriter().print("Uploaded  Questions remarks successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				response.getWriter().print("Uploaded  Questions remarks Failed");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private void fetchQuestion(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter()
					.print(gson.toJson(lQuestionDao.get(Long.parseLong(request.getParameter("QuestionId")))));
		} catch (Exception e) {
			try {
				response.getWriter().print("[]");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private void fetchQuestionsOnSubjects(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter()
					.print(gson.toJson(lQuestionDao.getBySubject(Long.parseLong(request.getParameter("SubjectId")))));
		} catch (Exception e) {
			try {
				response.getWriter().print("[]");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

//	
//	subjectId:$("#SubjectList option:selected").val(),
//	question:$("#Question").val(),
//	options:optionArray(),
//	correctAnswer:$("#CorrectOption option:selected").val(),
//	marks:$("#Marks").val()

	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			JSONObject body = new JSONObject(request.getParameter("Body"));
			QuestionEntity lQuestionEntity = new QuestionEntity();
			lQuestionEntity.setQuestion(body.getString("question"));
			lQuestionEntity.setCorrectAnswer(Integer.parseInt(body.getString("correctAnswer")));
			lQuestionEntity.setOptions(body.get("options").toString());
			lQuestionEntity.setSubjectId(Long.parseLong(body.getString("subjectId")));
			lQuestionEntity.setMarks(Integer.parseInt(body.getString("marks")));
			response.getWriter().print(lQuestionDao.create(lQuestionEntity));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().print(Util.nofity("Something went wrong please try again.", "error"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private void fetchSubject(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().print(gson.toJson(lSubjectDao.fetchOnHead(lUserEntity.getUserId())));
		} catch (Exception e) {
			try {
				response.getWriter().print("[]");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
