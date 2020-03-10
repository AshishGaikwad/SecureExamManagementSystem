package batu.dev.sem.bundles.examination.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.dao.UserDao;
import batu.dev.sem.bundles.UserManagement.daoimpl.UserDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.bundles.examination.dao.SubjectDao;
import batu.dev.sem.bundles.examination.daoimpl.SubjectDaoImpl;
import batu.dev.sem.bundles.examination.entity.SubjectEntity;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao lUserDao = new UserDaoImpl();
	private SubjectDao lSubjectDao = new SubjectDaoImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String FormType = request.getParameter("FormType");

		switch (FormType) {
		case "CreateSubject":
			create(request, response);
			break;
		case "UpdateSubject":
			update(request, response);
			break;
		case "DeleteSubject":
			delete(request, response);
			break;
		case "GetSubject":
			get(request, response);
			break;

		case "FetchSubjectHead":
			fetchSubjectHead(request, response);
			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) {
		try {
			String SubjectName = request.getParameter("SubjectName");
			String SubjectCode = request.getParameter("SubjectCode");
			String SubjectHead = request.getParameter("SubjectHead");
			String AdmissionStartDate = request.getParameter("AdmissionStartDate");
			String AdmissionEndDate = request.getParameter("AdmissionEndDate");
			String DateOfExamination = request.getParameter("DateOfExamination");
			String DateOfResult = request.getParameter("DateOfResult");
			String SubjectFee = request.getParameter("SubjectFee");
			String SubjectDescription = request.getParameter("SubjectDescription");

			SubjectEntity lEntity = new SubjectEntity();

			validateSubject(response, SubjectName, SubjectCode, SubjectHead, AdmissionStartDate, AdmissionEndDate,
					DateOfExamination, DateOfResult, SubjectFee, SubjectDescription, lEntity);

			response.getWriter().print(lSubjectDao.add(lEntity));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().print(Util.nofity("Please Enter valid form details.", "error"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			String SubjectId = request.getParameter("SubjectId");
			String SubjectName = request.getParameter("SubjectName");
			String SubjectCode = request.getParameter("SubjectCode");
			String SubjectHead = request.getParameter("SubjectHead");
			String AdmissionStartDate = request.getParameter("AdmissionStartDate");
			String AdmissionEndDate = request.getParameter("AdmissionEndDate");
			String DateOfExamination = request.getParameter("DateOfExamination");
			String DateOfResult = request.getParameter("DateOfResult");
			String SubjectFee = request.getParameter("SubjectFee");
			String SubjectDescription = request.getParameter("SubjectDescription");

			SubjectEntity lEntity = new SubjectEntity();

			validateSubject(response, SubjectName, SubjectCode, SubjectHead, AdmissionStartDate, AdmissionEndDate,
					DateOfExamination, DateOfResult, SubjectFee, SubjectDescription, lEntity);

			if (Util.isNull(SubjectId)) {
				response.getWriter().print(Util.nofity("Subject Id is not exist", "error"));
				return;
			} else {
				lEntity.setId(Long.parseLong(SubjectId));
			}

			response.getWriter().print(lSubjectDao.update(lEntity));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().print(Util.nofity("Please Enter valid form details.", "error"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String SubjectId = request.getParameter("SubjectId");

			if (Util.isNull(SubjectId)) {
				response.getWriter().print(Util.nofity("Subject Id is not exist", "error"));
				return;
			}

			response.getWriter().print(lSubjectDao.delete(Long.parseLong(SubjectId)));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().print(Util.nofity("Please Enter valid form details.", "error"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}

	}

	private void get(HttpServletRequest request, HttpServletResponse response) {
		try {
			String allAccessIds[] = Util.getProperty("Config", "ALL_ACCESS_ID").toString().split(",");
			JSONArray lArray = (JSONArray) request.getSession().getAttribute("USER_ROLES");
			UserEntity lUserEntity = (UserEntity) request.getSession().getAttribute("USER_ENTITY");

			boolean specialPrevilages = false;

			for (int i = 0; i < lArray.length(); i++) {

				for (String pString : allAccessIds) {
					if (lArray.getString(i).equalsIgnoreCase(pString)) {
						specialPrevilages = true;
						break;
					}
				}

			}
			if (specialPrevilages) {
//				System.out.println(gson.toJson(lSubjectDao.get()));
				
				response.getWriter().print(gson.toJson(lSubjectDao.get()));
			} else {
//				System.out.println(gson.toJson(lSubjectDao.fetchOnHead(lUserEntity.getUserId())));
				
				
				
				response.getWriter().print(gson.toJson(lSubjectDao.fetchOnHead(lUserEntity.getUserId())).toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void fetchSubjectHead(HttpServletRequest request, HttpServletResponse response) {
		try {

			String allAccessIds[] = Util.getProperty("Config", "ALL_ACCESS_ID").toString().split(",");

//			System.out.println(Arrays.toString(allAccessIds));

			JSONArray lArray = (JSONArray) request.getSession().getAttribute("USER_ROLES");
			UserEntity lUserEntity = (UserEntity) request.getSession().getAttribute("USER_ENTITY");

			boolean specialPrevilages = false;

			for (int i = 0; i < lArray.length(); i++) {

				for (String pString : allAccessIds) {
//					System.out.println(pString + ":" + lArray.getString(i));

					if (lArray.getString(i).equalsIgnoreCase(pString)) {
						specialPrevilages = true;
						break;
					}
				}

			}

			if (specialPrevilages) {
				response.getWriter().print(gson.toJson(lUserDao.getUser()));
			} else {

				response.getWriter().print(new JSONArray().put(new JSONObject(gson.toJson(lUserEntity))));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void validateSubject(HttpServletResponse response, String SubjectName, String SubjectCode,
			String SubjectHead, String AdmissionStartDate, String AdmissionEndDate, String DateOfExamination,
			String DateOfResult, String SubjectFee, String SubjectDescription, SubjectEntity lEntity)
			throws IOException {
		if (Util.isNull(SubjectName)) {
			response.getWriter().print(Util.nofity("Please Enter Subject Name", "error"));
			return;
		} else {
			lEntity.setName(SubjectName);
		}

		if (Util.isNull(SubjectCode)) {
			response.getWriter().print(Util.nofity("Please Enter Subject Code", "error"));
			return;
		} else {
			lEntity.setCode(SubjectCode);
		}

		if (Util.isNull(SubjectHead)) {
			response.getWriter().print(Util.nofity("Please Enter Subject Head", "error"));
			return;
		} else {
			lEntity.setHead(Long.parseLong(SubjectHead));
		}

		if (Util.isNull(AdmissionStartDate)) {
			response.getWriter().print(Util.nofity("Please Enter Admission Start Date", "error"));
			return;
		} else {
			lEntity.setAdmissionEndDate(AdmissionStartDate);
		}

		if (Util.isNull(AdmissionEndDate)) {
			response.getWriter().print(Util.nofity("Please Enter Admission End Date", "error"));
			return;
		} else {
			lEntity.setAdmissionStartDate(AdmissionEndDate);
		}

		if (Util.isNull(DateOfExamination)) {
			response.getWriter().print(Util.nofity("Please Enter Date of Examination", "error"));
			return;
		} else {
			lEntity.setExaminationDate(DateOfExamination);
		}

		if (Util.isNull(DateOfResult)) {
			response.getWriter().print(Util.nofity("Please Enter Date of result", "error"));
			return;
		} else {
			lEntity.setResultDate(DateOfResult);
		}

		if (Util.isNull(SubjectFee)) {
			response.getWriter().print(Util.nofity("Please Enter Subject Fee", "error"));
			return;
		} else {
			lEntity.setFee(Double.parseDouble(SubjectFee));
		}

		if (Util.isNull(SubjectDescription)) {
			response.getWriter().print(Util.nofity("Please Enter Subject Desc", "error"));
			return;
		} else {
			lEntity.setDesc(SubjectDescription);
		}
	}

}
