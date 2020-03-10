
package batu.dev.sem.bundles.UserManagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONArray;

import batu.dev.sem.bundles.UserManagement.dao.OperationDao;
import batu.dev.sem.bundles.UserManagement.dao.UserRoleMappingDao;
import batu.dev.sem.bundles.UserManagement.entity.MappingEntity;
import batu.dev.sem.bundles.UserManagement.entity.RoleEntity;
import batu.dev.sem.utils.MySQLConnector;

public class UserRoleMappingDaoImpl implements UserRoleMappingDao, OperationDao<MappingEntity> {
	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";

	@Override
	public int create(MappingEntity pEntity) {
		try {

			lQuery = "INSERT INTO `users_role_mapping` (`id`,`u_id`,`r_id`,`rowstate`) VALUES (NULL, ?, ?, ?)";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);

			lPreparedStatement.setLong(1, pEntity.getUserId());
			lPreparedStatement.setLong(2, pEntity.getRoleId());
			lPreparedStatement.setLong(3, pEntity.getRowstate());

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

	
	public int delete(long pUserId) {
		try {

			lQuery = "DELETE FROM `Users` WHERE `u_id`=?";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pUserId);
			
			int result = lPreparedStatement.executeUpdate();
			lConnection.commit();
			// System.out.println(result + "= rESs");

			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			lQuery = "";
			if (result != 0)
				return 13;
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
	public MappingEntity get(long pId) {
		// TODO Auto-generated method stub
		return null;
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

	public JSONArray getUserRolesCSV(long pUserId) {
		JSONArray lArray = new JSONArray();
		try {
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT * FROM `users_role_mapping` where u_id = '" + pUserId + "'";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			while (lResultSet.next()) {

				lArray.put(lResultSet.getString("r_id"));

			}

			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
		} catch (Exception e) {
			e.printStackTrace();
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			return null;// TODO: handle exception
		} finally {
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
		}

		return lArray;
	}

	public static void main(String[] args) {
		UserRoleMappingDaoImpl lRolesMapping = new UserRoleMappingDaoImpl();
		System.out.println("getUserRolesCSV  " + lRolesMapping.getUserRolesCSV(1).toString());
//		OperationDao<MappingEntity> lRolesMapping = new UserRoleMappingDaoImpl();
//		
//		MappingEntity lRoleEntity = new MappingEntity();
//		lRoleEntity.setRoleId(1);
//		lRoleEntity.setUserId(1);
//		lRoleEntity.setRowstate(1);

//		System.out.println("Role Created == "+lRolesMapping.create(lRoleEntity));
	}

	@Override
	public int delete(MappingEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
