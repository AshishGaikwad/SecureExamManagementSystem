package batu.dev.sem.bundles.examination.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.instamojo.wrapper.model.PaymentOrder;

import batu.dev.sem.bundles.examination.dao.ExamRegistrationDao;
import batu.dev.sem.bundles.examination.entity.ExamRegistrationEntity;
import batu.dev.sem.bundles.examination.entity.ExaminationEntity;
import batu.dev.sem.utils.MySQLConnector;

public class ExamRegistrationDaoImpl implements ExamRegistrationDao {

	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";

	@Override
	public boolean save(ExamRegistrationEntity pExamRegistrationEntity) {
		try {
			lQuery = "INSERT INTO `examinationportal`.`examination_registration` (`id`,`eid`,`uid`,`pid`,`passcode`,`status`) VALUES (null,?,?,?,?,?);";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pExamRegistrationEntity.getEId());
			lPreparedStatement.setLong(2, pExamRegistrationEntity.getUId());
			lPreparedStatement.setString(3, pExamRegistrationEntity.getPId());
			lPreparedStatement.setString(4, pExamRegistrationEntity.getPasscode());
			lPreparedStatement.setString(5, pExamRegistrationEntity.getStatus());
			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			if (res > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			if (lConnection != null) {
				try {
					lConnection.rollback();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			return false;
		}
	}

	@Override
	public boolean update(ExamRegistrationEntity pExamRegistrationEntity) {
		try {
			lQuery = "UPDATE `examinationportal`.`examination_registration` SET `eid` = ?, `uid` = ?, `pid` = ?, `passcode`= ? ,`status`=? WHERE `id` = ?;";
			lConnection = MySQLConnector.getConnection();
			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pExamRegistrationEntity.getEId());
			lPreparedStatement.setLong(2, pExamRegistrationEntity.getUId());
			lPreparedStatement.setString(3, pExamRegistrationEntity.getPId());
			lPreparedStatement.setString(4, pExamRegistrationEntity.getPasscode());
			lPreparedStatement.setString(5, pExamRegistrationEntity.getStatus());
			lPreparedStatement.setLong(6, pExamRegistrationEntity.getId());

			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			if (res > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			if (lConnection != null) {
				try {
					lConnection.rollback();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			return false;
		}
	}

	@Override
	public ExamRegistrationEntity get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamRegistrationEntity getByUid(long pUID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamRegistrationEntity getByEid(long pEID) {
		// TODO Auto-generated method stub
		return null;
	}

	//
	@Override
	public ExamRegistrationEntity getByEidAndUid(long pEID, long pUID) {
		try {
			ExamRegistrationEntity lExamRegistrationEntity = null;
			lQuery = "SELECT `examination_registration`.`id`,`examination_registration`.`eid`,`examination_registration`.`uid`,`examination_registration`.`pid`,`passcode`,`status` FROM `examinationportal`.`examination_registration` where `examination_registration`.`eid`=? AND `examination_registration`.`uid`=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pEID);
			lPreparedStatement.setLong(2, pUID);
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				lExamRegistrationEntity = new ExamRegistrationEntity();
				lExamRegistrationEntity.setId(lResultSet.getLong(1));
				lExamRegistrationEntity.setEId(lResultSet.getLong(2));
				lExamRegistrationEntity.setUId(lResultSet.getLong(3));
				lExamRegistrationEntity.setPId(lResultSet.getString(4));
				lExamRegistrationEntity.setPasscode(lResultSet.getString(5));
				lExamRegistrationEntity.setStatus(lResultSet.getString(6));
			} else {
				return null;
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lExamRegistrationEntity;

		} catch (Exception e) {

			e.printStackTrace();
			if (lConnection != null) {
				try {
					lResultSet.close();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			return null;
		}
	}

	@Override
	public ExamRegistrationEntity getByPid(String pPID) {
		try {
			ExamRegistrationEntity lExamRegistrationEntity = null;
			lQuery = "SELECT `examination_registration`.`id`,`examination_registration`.`eid`,`examination_registration`.`uid`,`examination_registration`.`pid`,`passcode`,`status` FROM `examinationportal`.`examination_registration` where `examination_registration`.`pid`=? ;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			
			lPreparedStatement.setString(1, pPID);
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				lExamRegistrationEntity = new ExamRegistrationEntity();
				lExamRegistrationEntity.setId(lResultSet.getLong(1));
				lExamRegistrationEntity.setEId(lResultSet.getLong(2));
				lExamRegistrationEntity.setUId(lResultSet.getLong(3));
				lExamRegistrationEntity.setPId(lResultSet.getString(4));
				lExamRegistrationEntity.setPasscode(lResultSet.getString(5));
				lExamRegistrationEntity.setStatus(lResultSet.getString(6));
			} else {
				return null;
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lExamRegistrationEntity;

		} catch (Exception e) {

			e.printStackTrace();
			if (lConnection != null) {
				try {
					lResultSet.close();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			return null;
		}
	}
	
	//SELECT * FROM examinationportal.examination_registration INNER JOIN examination ON examination_registration.eid = examination.eId WHERE examination_registration.uid=9;

	@Override
	public List<ExaminationEntity> getAppliedExamination(long pUID) {
		try {
			List<ExaminationEntity> lExaminationEntities = new ArrayList<ExaminationEntity>();
			lQuery = "SELECT "
					+ "`examination`.`eId`,"
					+ "`examination`.`eTitle`,"
					+ "`examination`.`eSubjectId`,"
					+ "`examination`.`eMarkQueDetails`,"
					+ "`examination`.`eTotalQue`,"
					+ "`examination`.`eTotalMarks`,"
					+ "`examination`.`ePassingMarks`,"
					+ "`examination`.`eDuration`,"
					+ "`examination`.`eDescription`,"
					+ "`examination`.`eAdmissionStartDate`,"
					+ "`examination`.`eAdmissionLastDate`,"
					+ "`examination`.`eHallTicketDate`,"
					+ "`examination`.`eDate`,"
					+ "`examination`.`eResultDate`,"
					+ "`examination`.`eFee`,"
					+ "`examination`.`eIsActive`"
					+ " FROM examinationportal.examination_registration INNER JOIN examination ON examination_registration.eid = examination.eId WHERE examination_registration.uid=?" ;
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pUID);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				ExaminationEntity lExaminationEntity = new ExaminationEntity();
				lExaminationEntity.seteId(lResultSet.getLong(1));
				lExaminationEntity.seteTitle(lResultSet.getString(2));
				lExaminationEntity.seteSubjectId(lResultSet.getLong(3));
				lExaminationEntity.seteMarkQueDetails(lResultSet.getString(4));
				lExaminationEntity.seteTotalQue(lResultSet.getLong(5));
				lExaminationEntity.seteTotalMarks(lResultSet.getLong(6));
				lExaminationEntity.setePassingMarks(lResultSet.getLong(7));
				lExaminationEntity.seteDuration(lResultSet.getLong(8));
				lExaminationEntity.seteDescription(lResultSet.getString(9));
				lExaminationEntity.seteAdmissionStartDate(lResultSet.getString(10));
				lExaminationEntity.seteAdmissionLastDate(lResultSet.getString(11));
				lExaminationEntity.seteHallTicketDate(lResultSet.getString(12));
				lExaminationEntity.seteDate(lResultSet.getString(13));
				lExaminationEntity.seteResultDate(lResultSet.getString(14));
				lExaminationEntity.seteFee(lResultSet.getDouble(15));
				lExaminationEntity.seteIsActive(lResultSet.getInt(16));
				lExaminationEntities.add(lExaminationEntity);
				
			} 
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lExaminationEntities;

		} catch (Exception e) {

			e.printStackTrace();
			if (lConnection != null) {
				try {
					lResultSet.close();
					lPreparedStatement.close();
					lConnection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}

			return null;
		}
	}

}
