package batu.dev.sem.bundles.UserManagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import batu.dev.sem.bundles.UserManagement.dao.UserDao;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;
import batu.dev.sem.utils.MySQLConnector;

public class UserDaoImpl implements UserDao {

	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";

	@Override
	public int createUser(UserEntity pUserEntity) {
		try {

			if (getUser(pUserEntity.getEmail()) == null) {
				lQuery = "INSERT INTO `Users` " + "(" + "`id`, " + "`full_name`, " + "`dob`," + " `password`, "
						+ "`email`, " + "`mobile`, " + "`status`, " + "`c_by`, "
						+ "`c_at`, `u_by`, `u_at`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				lConnection = MySQLConnector.getConnection();

				lConnection.setAutoCommit(false);
				lPreparedStatement = lConnection.prepareStatement(lQuery, Statement.RETURN_GENERATED_KEYS);

				lPreparedStatement.setString(1, pUserEntity.getFullName());
				lPreparedStatement.setString(2, pUserEntity.getDateOfBirth());
				lPreparedStatement.setString(3, pUserEntity.getPassword());
				lPreparedStatement.setString(4, pUserEntity.getEmail());
				lPreparedStatement.setString(5, pUserEntity.getMobile());
				lPreparedStatement.setInt(6, pUserEntity.getStatus());

				lPreparedStatement.setLong(7, pUserEntity.getCreatedBy());
				lPreparedStatement.setString(8, pUserEntity.getCreatedAt());
				lPreparedStatement.setLong(9, pUserEntity.getUpdatedBy());
				lPreparedStatement.setString(10, pUserEntity.getUpdatedAt());
				int result = lPreparedStatement.executeUpdate();

				ResultSet rs = lPreparedStatement.getGeneratedKeys();
				if (rs.next()) {
//					System.out.println("last inserted id is == " + rs.getInt(1));
				}
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
			} else {
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
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
	public long createUserWithReponse(UserEntity pUserEntity) {
		try {

			if (getUser(pUserEntity.getEmail()) == null) {
				lQuery = "INSERT INTO `Users` " + "(" + "`id`, " + "`full_name`, " + "`dob`," + " `password`, "
						+ "`email`, " + "`mobile`, " + "`status`, " + "`c_by`, "
						+ "`c_at`, `u_by`, `u_at`,`pas`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
				lConnection = MySQLConnector.getConnection();

				lConnection.setAutoCommit(false);
				lPreparedStatement = lConnection.prepareStatement(lQuery, Statement.RETURN_GENERATED_KEYS);

				lPreparedStatement.setString(1, pUserEntity.getFullName());
				lPreparedStatement.setString(2, pUserEntity.getDateOfBirth());
				lPreparedStatement.setString(3, pUserEntity.getPassword());
				lPreparedStatement.setString(4, pUserEntity.getEmail());
				lPreparedStatement.setString(5, pUserEntity.getMobile());
				lPreparedStatement.setInt(6, pUserEntity.getStatus());

				lPreparedStatement.setLong(7, pUserEntity.getCreatedBy());
				lPreparedStatement.setString(8, pUserEntity.getCreatedAt());
				lPreparedStatement.setLong(9, pUserEntity.getUpdatedBy());
				lPreparedStatement.setString(10, pUserEntity.getUpdatedAt());
				lPreparedStatement.setString(11, pUserEntity.getPas());
				int result = lPreparedStatement.executeUpdate();
				long respo = 0;
				ResultSet rs = lPreparedStatement.getGeneratedKeys();
				if (rs.next()) {
					respo = rs.getInt(1);
					System.out.println("last inserted id is == " + rs.getInt(1));
				}
				lConnection.commit();

				// System.out.println(result + "= rESs");

				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				lQuery = "";
				if (result != 0)
					return respo;
				else
					return 2;
			} else {
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
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
	public int updateUser(UserEntity pUserEntity) {
		try {

			if (getUser(pUserEntity.getEmail()) != null) {
				
				System.out.println("getUserId() == "+pUserEntity.getUserId());
				lQuery = "UPDATE `Users` SET `full_name`=?,`dob`=?,`password`=?,`email`=?,`mobile`=?,`status`=?,`u_by`=?,`u_at`=? WHERE `id`=?";
				
				
				lConnection = MySQLConnector.getConnection();

				lConnection.setAutoCommit(false);
				lPreparedStatement = lConnection.prepareStatement(lQuery);

				lPreparedStatement.setString(1, pUserEntity.getFullName());
				lPreparedStatement.setString(2, pUserEntity.getDateOfBirth());
				lPreparedStatement.setString(3, pUserEntity.getPassword());
				lPreparedStatement.setString(4, pUserEntity.getEmail());
				lPreparedStatement.setString(5, pUserEntity.getMobile());
				lPreparedStatement.setInt(6, pUserEntity.getStatus());

				lPreparedStatement.setLong(7, pUserEntity.getUpdatedBy());
				lPreparedStatement.setString(8, pUserEntity.getUpdatedAt());
				lPreparedStatement.setLong(9, pUserEntity.getUserId());
				
				int result = lPreparedStatement.executeUpdate();
				lConnection.commit();

				 System.out.println(result + "= rESs");

				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				lQuery = "";
				if (result != 0)
					return 13;
				else
					return 2;
			} else {
				return 11;
			}

		} catch (Exception e) {
			e.printStackTrace();
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
	public int deleteUser(UserEntity pUserEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserEntity getUser(long pUserId) {
		try {
			UserEntity lUserEntity = new UserEntity();
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `id`,`full_name`,`dob`,`password`,`email`,`mobile`,`status`,`c_by`,`c_at`,`u_by`,`u_at`,`pas` FROM `Users` where id = '"
					+ pUserId + "'";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			if (lResultSet.next()) {
				lUserEntity.setUserId(lResultSet.getLong(1));
				lUserEntity.setFullName(lResultSet.getString(2));
				lUserEntity.setDateOfBirth(lResultSet.getString(3));
				lUserEntity.setPassword(lResultSet.getString(4));
				lUserEntity.setEmail(lResultSet.getString(5));
				lUserEntity.setMobile(lResultSet.getString(6));
				lUserEntity.setStatus(lResultSet.getInt(7));
				lUserEntity.setCreatedAt(lResultSet.getString(8));
				lUserEntity.setCreatedBy(lResultSet.getLong(9));
				lUserEntity.setUpdatedAt(lResultSet.getString(10));
				lUserEntity.setUpdatedBy(lResultSet.getLong(11));
				lUserEntity.setPas(lResultSet.getString(12));
//				System.out.println(lUserEntity.toString());

				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return lUserEntity;
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
	public UserEntity getUser(String pEmail) {
		try {
			UserEntity lUserEntity = new UserEntity();
			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `id`,`full_name`,`dob`,`password`,`email`,`mobile`,`status`,`c_by`,`c_at`,`u_by`,`u_at`,`pas` FROM `Users` where email = '"
					+ pEmail + "'";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);

			if (lResultSet.next()) {
				lUserEntity.setUserId(lResultSet.getLong(1));
				lUserEntity.setFullName(lResultSet.getString(2));
				lUserEntity.setDateOfBirth(lResultSet.getString(3));
				lUserEntity.setPassword(lResultSet.getString(4));
				lUserEntity.setEmail(lResultSet.getString(5));
				lUserEntity.setMobile(lResultSet.getString(6));
				lUserEntity.setStatus(lResultSet.getInt(7));
				lUserEntity.setCreatedAt(lResultSet.getString(8));
				lUserEntity.setCreatedBy(lResultSet.getLong(9));
				lUserEntity.setUpdatedAt(lResultSet.getString(10));
				lUserEntity.setUpdatedBy(lResultSet.getLong(11));
				lUserEntity.setPas(lResultSet.getString(12));
//				System.out.println(lUserEntity.toString());

				lConnection = null;
				lPreparedStatement = null;
				lResultSet = null;
				return lUserEntity;
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
	public int validateUser(String pEmail, String pPassword) {
		try {
			UserEntity lUserEntity = getUser(pEmail);

			if (lUserEntity == null)
				return 11;
			else {
				if (lUserEntity.getStatus() == 1) {
					if (lUserEntity.getEmail().equalsIgnoreCase(pEmail)
							&& lUserEntity.getPassword().equals(pPassword)) {
						return 9;
					} else {
						return 8;
					}
				} else {
					return 10;
				}
			}
		} catch (Exception e) {
			return 12;
		}

	}

	@Override
	public List<UserEntity> getUser() {
		List<UserEntity> lList = null;
		try {

			lConnection = MySQLConnector.getConnection();
			lQuery = "SELECT `id`,`full_name`,`dob`,`password`,`email`,`mobile`,`status`,`c_by`,`c_at`,`u_by`,`u_at`,`pas` FROM `Users`";

			lResultSet = lConnection.createStatement().executeQuery(lQuery);
			lList = new ArrayList<UserEntity>();
			while (lResultSet.next()) {
				UserEntity lUserEntity = new UserEntity();
				lUserEntity.setUserId(lResultSet.getLong(1));
				lUserEntity.setFullName(lResultSet.getString(2));
				lUserEntity.setDateOfBirth(lResultSet.getString(3));
				lUserEntity.setPassword(lResultSet.getString(4));
				lUserEntity.setEmail(lResultSet.getString(5));
				lUserEntity.setMobile(lResultSet.getString(6));
				lUserEntity.setStatus(lResultSet.getInt(7));
				lUserEntity.setCreatedAt(lResultSet.getString(8));
				lUserEntity.setCreatedBy(lResultSet.getLong(9));
				lUserEntity.setUpdatedAt(lResultSet.getString(10));
				lUserEntity.setUpdatedBy(lResultSet.getLong(11));
				lUserEntity.setPas(lResultSet.getString(12));
//				System.out.println(lUserEntity.toString());

				lList.add(lUserEntity);
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

		return lList;

	}

	public static void main(String[] args) {

		UserDao lUserDao = new UserDaoImpl();

		System.out.println(lUserDao.getUser(9).toString());

	}

}
