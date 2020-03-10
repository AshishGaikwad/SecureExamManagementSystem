package batu.dev.sem.bundles.UserManagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import batu.dev.sem.bundles.UserManagement.dao.OperationDao;
import batu.dev.sem.bundles.UserManagement.dao.RolesDao;
import batu.dev.sem.bundles.UserManagement.entity.RoleEntity;
import batu.dev.sem.utils.MySQLConnector;

public class RolesDaoImpl implements RolesDao, OperationDao<RoleEntity> {

	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";

	@Override
	public int create(RoleEntity pEntity) {
		try {

			//System.out.println("pEntity =="+pEntity);
			//System.out.println("get(pEntity.getRoleName())" + get(pEntity.getRoleName()));

			if (get(pEntity.getRoleName()) == null) {
				lQuery = "INSERT INTO `role` (`role_id`,`role_name`,`role_state`,`created_by`,`created_at`,`updated_by`,`updated_at`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
				lConnection = MySQLConnector.getConnection();

				lConnection.setAutoCommit(false);
				lPreparedStatement = lConnection.prepareStatement(lQuery);

				lPreparedStatement.setString(1, pEntity.getRoleName());
				lPreparedStatement.setString(2, pEntity.getRoleState());
				lPreparedStatement.setLong(3, pEntity.getCreatedBy());
				lPreparedStatement.setString(4, pEntity.getCreatedAt());
				lPreparedStatement.setLong(5, pEntity.getUpdatedBy());
				lPreparedStatement.setString(6, pEntity.getUpdatedAt());

				int result = lPreparedStatement.executeUpdate();
				lConnection.commit();
				// //System.out.println(result + "= rESs");

				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				lQuery = "";
				if (result != 0)
					return 301;
				else
					return 2;

			} else {
				return 302;
			}
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
	public int update(RoleEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(RoleEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RoleEntity get(long pId) {
		try {
			RoleEntity lEntity = new RoleEntity();
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `role_id`,`role_name`,`role_state`,`created_by`,`created_at`,`updated_by`,`updated_at` FROM `role` where role_id = '"
					+ pId + "'";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			if (lResultSet.next()) {
				lEntity.setRoleId(lResultSet.getLong(1));
				lEntity.setRoleName(lResultSet.getString(2));
				lEntity.setRoleState(lResultSet.getString(3));

				lEntity.setCreatedAt(lResultSet.getString(5));
				lEntity.setCreatedBy(lResultSet.getLong(4));
				lEntity.setUpdatedAt(lResultSet.getString(7));
				lEntity.setUpdatedBy(lResultSet.getInt(6));
				//System.out.println(lEntity.toString());

				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return lEntity;
			} else {
				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return null;
			}
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
	}

	@Override
	public RoleEntity get(String pString) {
		try {
			RoleEntity lEntity = new RoleEntity();
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `role_id`,`role_name`,`role_state`,`created_by`,`created_at`,`updated_by`,`updated_at` FROM `role` where role_name = '"
					+ pString + "'";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			if (lResultSet.next()) {
				lEntity.setRoleId(lResultSet.getLong(1));
				lEntity.setRoleName(lResultSet.getString(2));
				lEntity.setRoleState(lResultSet.getString(3));

				lEntity.setCreatedAt(lResultSet.getString(5));
				lEntity.setCreatedBy(lResultSet.getLong(4));
				lEntity.setUpdatedAt(lResultSet.getString(7));
				lEntity.setUpdatedBy(lResultSet.getInt(6));
				//System.out.println(lEntity.toString());

				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return lEntity;
			} else {
				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return null;
			}
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
	}

	@Override
	public List<RoleEntity> getAll() {
		try {

			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `role_id`,`role_name`,`role_state`,`created_by`,`created_at`,`updated_by`,`updated_at` FROM `role`";

			List<RoleEntity> list = new ArrayList<>();
			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			while (lResultSet.next()) {
				RoleEntity lEntity = new RoleEntity();
				lEntity.setRoleId(lResultSet.getLong(1));
				lEntity.setRoleName(lResultSet.getString(2));
				lEntity.setRoleState(lResultSet.getString(3));

				lEntity.setCreatedAt(lResultSet.getString(5));
				lEntity.setCreatedBy(lResultSet.getLong(4));
				lEntity.setUpdatedAt(lResultSet.getString(7));
				lEntity.setUpdatedBy(lResultSet.getInt(6));
//				//System.out.println(lEntity.toString());

				list.add(lEntity);

			}
			lConnection = null;
			lPreparedStatement = null;
			lResultSet = null;
			return list;
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
	}

	@Override
	public List<RoleEntity> get(String... p) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		OperationDao<RoleEntity> lRoles = new RolesDaoImpl();

		RoleEntity lRoleEntity = new RoleEntity();
		lRoleEntity.setRoleName("SUBADMIN");
		lRoleEntity.setRoleState("1");
		lRoleEntity.setCreatedBy(1);
		lRoleEntity.setCreatedAt("2019-10-28 11:11:11.222");
		lRoleEntity.setUpdatedBy(1);
		lRoleEntity.setUpdatedAt("2019-10-28 11:11:11.222");

		//System.out.println("Role Created == " + lRoles.create(lRoleEntity));
//		//System.out.println("Role get == "+lRoles.get(1).toString());
	}
}
