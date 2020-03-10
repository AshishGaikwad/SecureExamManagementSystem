package batu.dev.sem.bundles.UserManagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import batu.dev.sem.bundles.UserManagement.dao.OperationDao;
import batu.dev.sem.bundles.UserManagement.dao.RoleScreenMappingDao;
import batu.dev.sem.bundles.UserManagement.entity.MappingEntity;
import batu.dev.sem.bundles.UserManagement.entity.RoleEntity;
import batu.dev.sem.utils.MySQLConnector;

public class RoleScreenMappingDaoImpl implements OperationDao<MappingEntity>, RoleScreenMappingDao {
	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";

	@Override
	public int create(MappingEntity pEntity) {
		try {

			lQuery = "INSERT INTO `role_screen_mapping` (`id`,`r_id`,`s_id`,`rowstate`,`RWUD`) VALUES (NULL, ?, ?, ?,?)";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);

			lPreparedStatement.setLong(1, pEntity.getRoleId());
			lPreparedStatement.setLong(2, pEntity.getUserId());
			lPreparedStatement.setLong(3, pEntity.getRowstate());
			lPreparedStatement.setString(4, pEntity.getFiller1());

			int result = lPreparedStatement.executeUpdate();
			lConnection.commit();
			// System.out.println(result + "= rESs");

			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			lQuery = "";
			if (result != 0)
				return 1;
			else
				return 2;
		} catch (Exception e) {
			try {
				lConnection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			lQuery = "";

			return 2;
		} finally {
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			lQuery = "";
		}
	}

	@Override
	public int update(MappingEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MappingEntity pEntity) {
		try {

			lQuery = "DELETE FROM `role_screen_mapping` WHERE `role_screen_mapping`.`r_id` ="+pEntity.getRoleId();
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);

			int result = lPreparedStatement.executeUpdate();
			lConnection.commit();
			// System.out.println(result + "= rESs");

			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			lQuery = "";
			if (result != 0)
				return 1;
			else
				return 2;
		} catch (Exception e) {
			try {
				lConnection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			lQuery = "";

			return 2;
		} finally {
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			lQuery = "";
		}
	}

	
	public String getRoleMapping(long pId) {
		try {
			JSONArray lEntity = new JSONArray();
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `r_id`,`s_id`,`rowstate`,`RWUD` FROM `role_screen_mapping` WHERE r_id="+pId;

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			while (lResultSet.next()) {
				JSONObject lObject = new JSONObject();
				
//				System.out.println(lEntity.toString());
				lObject.put("r_id", lResultSet.getString(1));
				lObject.put("s_id", lResultSet.getString(2));
				lObject.put("rowstate", lResultSet.getString(3));
				lObject.put("RWUD", lResultSet.getString(4));
				
				lEntity.put(lObject);
			} 
			
				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return lEntity.toString();
		} catch (Exception e) {
			e.printStackTrace();
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			return null;// TODO: handle exception
		}finally {
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
		}
	}

	@Override
	public MappingEntity get(String pName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MappingEntity> get(String... p) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		OperationDao<MappingEntity> lRolesMapping = new RoleScreenMappingDaoImpl();

		MappingEntity lScreenEntity = new MappingEntity();
		lScreenEntity.setRoleId(1);
		lScreenEntity.setUserId(2);
		lScreenEntity.setRowstate(1);

//	SELECT screens.* from users_role_mapping  
//	INNER JOIN role 
//	ON 
//	users_role_mapping.r_id = role.role_id
//	INNER JOIN role_screen_mapping
//	ON 
//	role.role_id = role_screen_mapping.r_id
//	INNER JOIN screens
//	ON
//	role_screen_mapping.s_id = screens.screen_id
//	WHERE users_role_mapping.id = '1'
//	;

//		System.out.println("User Screen Map Created == " + lRolesMapping.create(lScreenEntity));
	}

	@Override
	public MappingEntity get(long pId) {
		// TODO Auto-generated method stub
		return null;
	}
}
