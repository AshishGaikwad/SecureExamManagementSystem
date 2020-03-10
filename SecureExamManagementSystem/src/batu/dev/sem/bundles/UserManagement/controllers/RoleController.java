package batu.dev.sem.bundles.UserManagement.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.daoimpl.RoleScreenMappingDaoImpl;
import batu.dev.sem.bundles.UserManagement.daoimpl.RolesDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.MappingEntity;
import batu.dev.sem.bundles.UserManagement.entity.RoleEntity;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.utils.Util;

/**
 * Servlet implementation class RoleController
 */
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession lHttpSession = request.getSession();
		UserEntity lEntity = (UserEntity) lHttpSession.getAttribute("USER_ENTITY");
		RolesDaoImpl lRolesDaoImpl = new RolesDaoImpl();
		RoleScreenMappingDaoImpl lRoleScreenMappingDaoImpl = new RoleScreenMappingDaoImpl();
		PrintWriter out = response.getWriter();
//		ResourceBundle lResponseBundle = Util.ResourceBundle.getBundle("responses");

		String lRequestType = request.getParameter("RequestType");
		Gson gson = new Gson();

		switch (lRequestType) {
		case "GetAllRoles":
			out.print(gson.toJson(lRolesDaoImpl.getAll()));
			break;

		case "GetUsersMappedRole":
			out.print(lRoleScreenMappingDaoImpl.getRoleMapping(new Long(request.getParameter("pRoleID"))));
			break;

		case "AddNewRole":
			RoleEntity lRoleEntity = new RoleEntity();
			lRoleEntity.setRoleName(request.getParameter("RoleName"));
			lRoleEntity.setUpdatedBy(lEntity.getUserId());
			lRoleEntity.setUpdatedAt(String.valueOf(new Timestamp(new Date().getTime())));
			lRoleEntity.setCreatedBy(lEntity.getUserId());
			lRoleEntity.setCreatedAt(String.valueOf(new Timestamp(new Date().getTime())));
			lRoleEntity.setRoleState("1");
			out.print(Util.getProperty("responses", String.valueOf(lRolesDaoImpl.create(lRoleEntity))));

			break;

		case "AddRoleMapping":
			JSONArray lArray = new JSONArray(request.getParameter("RoleMappingData").toString());
			
			
			
			if (lArray.length() > -1) {
				MappingEntity lMappingEntity2 = gson.fromJson(lArray.getJSONObject(0).toString(), MappingEntity.class);
				
				lRoleScreenMappingDaoImpl.delete(lMappingEntity2);
				
				try {
					for (int i = 0; i < lArray.length(); i++) {
						JSONObject lJsonObject = lArray.getJSONObject(i);
						MappingEntity lMappingEntity = gson.fromJson(lJsonObject.toString(), MappingEntity.class);
						lRoleScreenMappingDaoImpl.create(lMappingEntity);
						

					}
				} catch (Exception e) {
					e.printStackTrace();
					out.print("Something went wrong please try again");
					return;
				}
				
				out.print("Role Mappped Successfully");
				
			}

//			out.print(Util.getProperty("responses",String.valueOf(lRolesDaoImpl.create(lRoleEntity))));

			break;

		default:
			break;
		}

	}

}
