package batu.dev.sem.bundles.examination.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import batu.dev.sem.bundles.examination.dao.ExaminationDao;
import batu.dev.sem.bundles.examination.entity.ExaminationEntity;
import batu.dev.sem.utils.MySQLConnector;
import batu.dev.sem.utils.Util;

public class ExaminationDaoImpl implements ExaminationDao {
	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";

	@Override
	public String create(ExaminationEntity pExaminationEntity) {
		// INSERT INTO `examinationportal`.`examination`
		// (`eId`,`eTitle`,`eSubjectId`,`eMarkQueDetails`,`eTotalQue`,`eTotalMarks`,`ePassingMarks`,`eDuration`,`eDescription`,`eAdmissionStartDate`,`eAdmissionLastDate`,`eHallTicketDate`,`eDate`,`eResultDate`,`eFee`,`eIsActive`)
		// VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);
		try {

			if (get(pExaminationEntity.geteTitle()) == null) {

				lQuery = "INSERT INTO `examinationportal`.`examination` (`eId`,`eTitle`,`eSubjectId`,`eMarkQueDetails`,`eTotalQue`,"
						+ "`eTotalMarks`,`ePassingMarks`,`eDuration`,`eDescription`,`eAdmissionStartDate`,`eAdmissionLastDate`,`eHallTicketDate`,"
						+ "`eDate`,`eResultDate`,`eFee`,`eIsActive`) VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				lConnection = MySQLConnector.getConnection();

				lConnection.setAutoCommit(false);
				lPreparedStatement = lConnection.prepareStatement(lQuery);

				lPreparedStatement.setString(1, pExaminationEntity.geteTitle());
				lPreparedStatement.setLong(2, pExaminationEntity.geteSubjectId());
				lPreparedStatement.setString(3, pExaminationEntity.geteMarkQueDetails());
				lPreparedStatement.setLong(4, pExaminationEntity.geteTotalQue());
				lPreparedStatement.setLong(5, pExaminationEntity.geteTotalMarks());
				lPreparedStatement.setLong(6, pExaminationEntity.getePassingMarks());
				lPreparedStatement.setLong(7, pExaminationEntity.geteDuration());
				lPreparedStatement.setString(8, pExaminationEntity.geteDescription());
				lPreparedStatement.setString(9, pExaminationEntity.geteAdmissionStartDate());
				lPreparedStatement.setString(10, pExaminationEntity.geteAdmissionLastDate());
				lPreparedStatement.setString(11, pExaminationEntity.geteHallTicketDate());
				lPreparedStatement.setString(12, pExaminationEntity.geteDate());
				lPreparedStatement.setString(13, pExaminationEntity.geteResultDate());
				lPreparedStatement.setDouble(14, pExaminationEntity.geteFee());
				lPreparedStatement.setInt(15, pExaminationEntity.geteIsActive());
				int res = lPreparedStatement.executeUpdate();
				lConnection.commit();

				if (res > 0)
					return Util.nofity("Examination Created successfully.", "success");
				else
					return Util.nofity("Failed to Create Examination.", "error");
			} else
				return Util.nofity("This Examination Title is already Exist", "error");
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

			return Util.nofity("Something went wrong please try again.", "error");
		}
	}

	@Override
	public String update(ExaminationEntity pExaminationEntity) {
		try {
			lQuery = "UPDATE `examinationportal`.`examination` SET `eTitle` = ?,`eSubjectId` = ?,`eMarkQueDetails` = ?,`eTotalQue` = ?,`eTotalMarks` = ?,`ePassingMarks` = ?,`eDuration` = ?,`eDescription` = ?,`eAdmissionStartDate` = ?,`eAdmissionLastDate` = ?,`eHallTicketDate` = ?,`eDate` = ?,`eResultDate` = ?,`eFee` = ?,`eIsActive` = ? WHERE `eId`=?;";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);

			lPreparedStatement.setString(1, pExaminationEntity.geteTitle());
			lPreparedStatement.setLong(2, pExaminationEntity.geteSubjectId());
			lPreparedStatement.setString(3, pExaminationEntity.geteMarkQueDetails());
			lPreparedStatement.setLong(4, pExaminationEntity.geteTotalQue());
			lPreparedStatement.setLong(5, pExaminationEntity.geteTotalMarks());
			lPreparedStatement.setLong(6, pExaminationEntity.getePassingMarks());
			lPreparedStatement.setLong(7, pExaminationEntity.geteDuration());
			lPreparedStatement.setString(8, pExaminationEntity.geteDescription());
			lPreparedStatement.setString(9, pExaminationEntity.geteAdmissionStartDate());
			lPreparedStatement.setString(10, pExaminationEntity.geteAdmissionLastDate());
			lPreparedStatement.setString(11, pExaminationEntity.geteHallTicketDate());
			lPreparedStatement.setString(12, pExaminationEntity.geteDate());
			lPreparedStatement.setString(13, pExaminationEntity.geteResultDate());
			lPreparedStatement.setDouble(14, pExaminationEntity.geteFee());
			lPreparedStatement.setInt(15, pExaminationEntity.geteIsActive());

			lPreparedStatement.setLong(16, pExaminationEntity.geteId());
			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			if (res > 0)
				return Util.nofity("Examination Updated successfully.", "success");
			else
				return Util.nofity("Failed to Update Examination.", "error");
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
			return Util.nofity("Something went wrong please try again.", "error");
		}
	}

	@Override
	public String delete(ExaminationEntity pExaminationEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExaminationEntity> get() {
		try {
			List<ExaminationEntity> lExaminationEntities = new ArrayList<ExaminationEntity>();

			lQuery = "SELECT `examination`.`eId`,`examination`.`eTitle`,`examination`.`eSubjectId`,`examination`.`eMarkQueDetails`,"
					+ "`examination`.`eTotalQue`,`examination`.`eTotalMarks`,`examination`.`ePassingMarks`,`examination`.`eDuration`,"
					+ "`examination`.`eDescription`,`examination`.`eAdmissionStartDate`,`examination`.`eAdmissionLastDate`,"
					+ "`examination`.`eHallTicketDate`,`examination`.`eDate`,`examination`.`eResultDate`,`examination`.`eFee`,"
					+ "`examination`.`eIsActive` FROM `examinationportal`.`examination`  WHERE `examination`.`eIsActive`=1;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
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
	public ExaminationEntity get(long pExaminationId) {
		try {
			ExaminationEntity lExaminationEntity = null;
			lQuery = "SELECT `examination`.`eId`,`examination`.`eTitle`,`examination`.`eSubjectId`,`examination`.`eMarkQueDetails`,"
					+ "`examination`.`eTotalQue`,`examination`.`eTotalMarks`,`examination`.`ePassingMarks`,`examination`.`eDuration`,"
					+ "`examination`.`eDescription`,`examination`.`eAdmissionStartDate`,`examination`.`eAdmissionLastDate`,"
					+ "`examination`.`eHallTicketDate`,`examination`.`eDate`,`examination`.`eResultDate`,`examination`.`eFee`,"
					+ "`examination`.`eIsActive` FROM `examinationportal`.`examination` WHERE eId=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pExaminationId);
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				lExaminationEntity = new ExaminationEntity();
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
			} else {
				return null;
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lExaminationEntity;

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
	public ExaminationEntity get(String pExaminationTitle) {
		try {
			ExaminationEntity lExaminationEntity = null;
			lQuery = "SELECT `examination`.`eId`,`examination`.`eTitle`,`examination`.`eSubjectId`,`examination`.`eMarkQueDetails`,"
					+ "`examination`.`eTotalQue`,`examination`.`eTotalMarks`,`examination`.`ePassingMarks`,`examination`.`eDuration`,"
					+ "`examination`.`eDescription`,`examination`.`eAdmissionStartDate`,`examination`.`eAdmissionLastDate`,"
					+ "`examination`.`eHallTicketDate`,`examination`.`eDate`,`examination`.`eResultDate`,`examination`.`eFee`,"
					+ "`examination`.`eIsActive` FROM `examinationportal`.`examination` WHERE eTitle=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setString(1, pExaminationTitle);
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				lExaminationEntity = new ExaminationEntity();
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
			} else {
				return null;
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lExaminationEntity;

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
	public List<ExaminationEntity> getOnSubjectId(long pSubjectId) {
		try {
			List<ExaminationEntity> lExaminationEntities = new ArrayList<ExaminationEntity>();

			lQuery = "SELECT `examination`.`eId`,`examination`.`eTitle`,`examination`.`eSubjectId`,`examination`.`eMarkQueDetails`,"
					+ "`examination`.`eTotalQue`,`examination`.`eTotalMarks`,`examination`.`ePassingMarks`,`examination`.`eDuration`,"
					+ "`examination`.`eDescription`,`examination`.`eAdmissionStartDate`,`examination`.`eAdmissionLastDate`,"
					+ "`examination`.`eHallTicketDate`,`examination`.`eDate`,`examination`.`eResultDate`,`examination`.`eFee`,"
					+ "`examination`.`eIsActive` FROM `examinationportal`.`examination` WHERE eSubjectId=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pSubjectId);
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

	public static void main(String[] args) {
		System.err.println(new ExaminationDaoImpl().get(3));
	}

}
