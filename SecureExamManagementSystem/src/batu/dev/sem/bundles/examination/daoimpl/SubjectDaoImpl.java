package batu.dev.sem.bundles.examination.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import batu.dev.sem.bundles.examination.dao.SubjectDao;
import batu.dev.sem.bundles.examination.entity.SubjectEntity;
import batu.dev.sem.utils.MySQLConnector;
import batu.dev.sem.utils.Util;

public class SubjectDaoImpl implements SubjectDao {

	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";

	@Override
	public String add(SubjectEntity pSubjectEntity) {

		try {
			lQuery = "INSERT INTO `examinationportal`.`subject`(" + "`subject_id`,"
					+ "`subject_name`,`subjectcode`,`subject_head`,`subject_admission_start_date`,"
					+ "`subject_admission_end_date`,`subject_examination_date`,`subject_result_date`,`subject_fee`,"
					+ "`subject_description`)" + "VALUES(Null,?,?,?,?,?,?,?,?,?)";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setString(1, pSubjectEntity.getName());
			lPreparedStatement.setString(2, pSubjectEntity.getCode());
			lPreparedStatement.setLong(3, pSubjectEntity.getHead());
			lPreparedStatement.setString(4, Util.sqlDate(pSubjectEntity.getAdmissionStartDate()));
			lPreparedStatement.setString(5, Util.sqlDate(pSubjectEntity.getAdmissionEndDate()));
			lPreparedStatement.setString(6, Util.sqlDate(pSubjectEntity.getExaminationDate()));
			lPreparedStatement.setString(7, Util.sqlDate(pSubjectEntity.getResultDate()));
			lPreparedStatement.setDouble(8, pSubjectEntity.getFee());
			lPreparedStatement.setString(9, pSubjectEntity.getDesc());

			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			if (res > 0)
				return Util.nofity( "Subject added successfully.", "success");
			else
				return Util.nofity( "Failed to add subject.", "error");
		} catch (Exception e) {

			if (lConnection != null) {
				try {
					lConnection.rollback();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			e.printStackTrace();
			return Util.nofity( "Something went wrong please try again.", "error");
		}

	}

	@Override
	public List<SubjectEntity> get() {
		try {
			List<SubjectEntity> lSubjectEntities = new ArrayList<SubjectEntity>();

			lQuery = "SELECT`subject`.`subject_id`,`subject`.`subject_name`,`subject`.`subjectcode`,`subject`.`subject_head`,`subject`.`subject_admission_start_date`,`subject`.`subject_admission_end_date`,`subject`.`subject_examination_date`,`subject`.`subject_result_date`,`subject`.`subject_fee`,`subject`.`subject_description`FROM `examinationportal`.`subject`;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				SubjectEntity lSubjectEntity = new SubjectEntity();
				lSubjectEntity.setId(lResultSet.getLong(1));
				lSubjectEntity.setName(lResultSet.getString(2));
				lSubjectEntity.setCode(lResultSet.getString(3));
				lSubjectEntity.setHead(lResultSet.getLong(4));
				lSubjectEntity.setAdmissionStartDate(Util.YmdTodmy(lResultSet.getString(5)));
				lSubjectEntity.setAdmissionEndDate(Util.YmdTodmy(lResultSet.getString(6)));
				lSubjectEntity.setExaminationDate(Util.YmdTodmy(lResultSet.getString(7)));
				lSubjectEntity.setResultDate(Util.YmdTodmy(lResultSet.getString(8)));
				lSubjectEntity.setFee(lResultSet.getDouble(9));
				lSubjectEntity.setDesc(lResultSet.getString(10));

				lSubjectEntities.add(lSubjectEntity);

			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lSubjectEntities;

		} catch (Exception e) {

			if (lConnection != null) {
				try {
					lResultSet.close();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<SubjectEntity> get(long pId) {
		try {
			List<SubjectEntity> lSubjectEntities = new ArrayList<SubjectEntity>();

			lQuery = "SELECT`subject`.`subject_id`,`subject`.`subject_name`,`subject`.`subjectcode`,`subject`.`subject_head`,`subject`.`subject_admission_start_date`,`subject`.`subject_admission_end_date`,`subject`.`subject_examination_date`,`subject`.`subject_result_date`,`subject`.`subject_fee`,`subject`.`subject_description`FROM `examinationportal`.`subject` WHERE `subject`.`subject_id`=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pId);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				SubjectEntity lSubjectEntity = new SubjectEntity();
				lSubjectEntity.setId(lResultSet.getLong(1));
				lSubjectEntity.setName(lResultSet.getString(2));
				lSubjectEntity.setCode(lResultSet.getString(3));
				lSubjectEntity.setHead(lResultSet.getLong(4));
				lSubjectEntity.setAdmissionStartDate(Util.YmdTodmy(lResultSet.getString(5)));
				lSubjectEntity.setAdmissionEndDate(Util.YmdTodmy(lResultSet.getString(6)));
				lSubjectEntity.setExaminationDate(Util.YmdTodmy(lResultSet.getString(7)));
				lSubjectEntity.setResultDate(Util.YmdTodmy(lResultSet.getString(8)));
				lSubjectEntity.setFee(lResultSet.getDouble(9));
				lSubjectEntity.setDesc(lResultSet.getString(10));

				lSubjectEntities.add(lSubjectEntity);

			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lSubjectEntities;

		} catch (Exception e) {

			if (lConnection != null) {
				try {
					lResultSet.close();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SubjectEntity> get(String pName) {
		try {
			List<SubjectEntity> lSubjectEntities = new ArrayList<SubjectEntity>();

			lQuery = "SELECT`subject`.`subject_id`,`subject`.`subject_name`,`subject`.`subjectcode`,`subject`.`subject_head`,`subject`.`subject_admission_start_date`,`subject`.`subject_admission_end_date`,`subject`.`subject_examination_date`,`subject`.`subject_result_date`,`subject`.`subject_fee`,`subject`.`subject_description`FROM `examinationportal`.`subject` WHERE `subject`.`subject_name`=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setString(1, pName);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				SubjectEntity lSubjectEntity = new SubjectEntity();
				lSubjectEntity.setId(lResultSet.getLong(1));
				lSubjectEntity.setName(lResultSet.getString(2));
				lSubjectEntity.setCode(lResultSet.getString(3));
				lSubjectEntity.setHead(lResultSet.getLong(4));
				lSubjectEntity.setAdmissionStartDate(Util.YmdTodmy(lResultSet.getString(5)));
				lSubjectEntity.setAdmissionEndDate(Util.YmdTodmy(lResultSet.getString(6)));
				lSubjectEntity.setExaminationDate(Util.YmdTodmy(lResultSet.getString(7)));
				lSubjectEntity.setResultDate(Util.YmdTodmy(lResultSet.getString(8)));
				lSubjectEntity.setFee(lResultSet.getDouble(9));
				lSubjectEntity.setDesc(lResultSet.getString(10));

				lSubjectEntities.add(lSubjectEntity);

			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lSubjectEntities;

		} catch (Exception e) {

			if (lConnection != null) {
				try {
					lResultSet.close();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SubjectEntity> fetchOnHead(long pHeadId) {
		try {
			List<SubjectEntity> lSubjectEntities = new ArrayList<SubjectEntity>();

			lQuery = "SELECT`subject`.`subject_id`,`subject`.`subject_name`,`subject`.`subjectcode`,`subject`.`subject_head`,`subject`.`subject_admission_start_date`,`subject`.`subject_admission_end_date`,`subject`.`subject_examination_date`,`subject`.`subject_result_date`,`subject`.`subject_fee`,`subject`.`subject_description`FROM `examinationportal`.`subject` WHERE `subject`.`subject_head`=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pHeadId);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				SubjectEntity lSubjectEntity = new SubjectEntity();
				lSubjectEntity.setId(lResultSet.getLong(1));
				lSubjectEntity.setName(lResultSet.getString(2));
				lSubjectEntity.setCode(lResultSet.getString(3));
				lSubjectEntity.setHead(lResultSet.getLong(4));
				lSubjectEntity.setAdmissionStartDate(Util.YmdTodmy(lResultSet.getString(5)));
				lSubjectEntity.setAdmissionEndDate(Util.YmdTodmy(lResultSet.getString(6)));
				lSubjectEntity.setExaminationDate(Util.YmdTodmy(lResultSet.getString(7)));
				lSubjectEntity.setResultDate(Util.YmdTodmy(lResultSet.getString(8)));
				lSubjectEntity.setFee(lResultSet.getDouble(9));
				lSubjectEntity.setDesc(lResultSet.getString(10));

				lSubjectEntities.add(lSubjectEntity);

			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lSubjectEntities;

		} catch (Exception e) {

			if (lConnection != null) {
				try {
					lResultSet.close();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isExist(String pName) {
		if(get(pName).size()>0)
			return true;
		else
			return false;
	}

	
	public static void main(String[] args) {
		System.err.println(new SubjectDaoImpl().isExist("JAVA"));
	}

	@Override
	public String update(SubjectEntity pSubjectEntity) {
		try {
			lQuery = "UPDATE `examinationportal`.`subject` SET"
					+ "`subject_name` = ?,`subjectcode` = ?,`subject_head` = ?,`subject_admission_start_date` = ?,"
					+ "`subject_admission_end_date` = ?,`subject_examination_date` = ?,`subject_result_date` = ?,"
					+ "`subject_fee` = ?,`subject_description` = ? "
					+ "WHERE subject_id=?;";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setString(1, pSubjectEntity.getName());
			lPreparedStatement.setString(2, pSubjectEntity.getCode());
			lPreparedStatement.setLong(3, pSubjectEntity.getHead());
			lPreparedStatement.setString(4, Util.sqlDate(pSubjectEntity.getAdmissionStartDate()));
			lPreparedStatement.setString(5, Util.sqlDate(pSubjectEntity.getAdmissionEndDate()));
			lPreparedStatement.setString(6, Util.sqlDate(pSubjectEntity.getExaminationDate()));
			lPreparedStatement.setString(7, Util.sqlDate(pSubjectEntity.getResultDate()));
			lPreparedStatement.setDouble(8, pSubjectEntity.getFee());
			lPreparedStatement.setString(9, pSubjectEntity.getDesc());
			lPreparedStatement.setLong(10, pSubjectEntity.getId());

			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			if (res > 0)
				return Util.nofity( "Subject updated successfully.", "success");
			else
				return Util.nofity( "Failed to update subject.", "error");
		} catch (Exception e) {

			if (lConnection != null) {
				try {
					lConnection.rollback();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			e.printStackTrace();
			return Util.nofity( "Something went wrong please try again.", "error");
		}
	}

	@Override
	public String delete(long pSubjectId) {
		try {
			lQuery = "DELETE FROM `examinationportal`.`subject`WHERE subject_id=?;";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pSubjectId);


			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			if (res > 0)
				return Util.nofity( "Subject deleted successfully.", "success");
			else
				return Util.nofity( "Failed to delete subject.", "error");
		} catch (Exception e) {

			if (lConnection != null) {
				try {
					lConnection.rollback();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			e.printStackTrace();
			return Util.nofity( "Something went wrong please try again.", "error");
		}
	}

}
