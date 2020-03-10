package batu.dev.sem.bundles.examination.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import batu.dev.sem.bundles.examination.dao.AnswerDao;
import batu.dev.sem.bundles.examination.entity.AnswerEntity;
import batu.dev.sem.utils.MySQLConnector;

public class AnswerDaoImpl implements AnswerDao {

	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";
//	private ExaminationDao lExaminationDao = new ExaminationDaoImpl();
	
	@Override
	public boolean create(AnswerEntity pAnswerEntity) {
		try {
			lQuery = "INSERT INTO `examinationportal`.`answer_sheet` (`q_id`,`e_id`,`u_id`,`er_id`,`selected_option`) VALUES (?,?,?,?,?);";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pAnswerEntity.getQId());
			lPreparedStatement.setLong(2, pAnswerEntity.getEId());
			lPreparedStatement.setLong(3, pAnswerEntity.getUId());
			lPreparedStatement.setLong(4, pAnswerEntity.getErId());
			lPreparedStatement.setLong(5, pAnswerEntity.getSelctedOption());
			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();
			return true;
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
	public boolean update(AnswerEntity pAnswerEntity) {
		try {
			lQuery = "UPDATE `examinationportal`.`answer_sheet`SET `q_id` = ?,`e_id` = ?,`u_id` = ?,`er_id` = ?,`selected_option` = ? WHERE `id` = ?;";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pAnswerEntity.getQId());
			lPreparedStatement.setLong(2, pAnswerEntity.getEId());
			lPreparedStatement.setLong(3, pAnswerEntity.getUId());
			lPreparedStatement.setLong(4, pAnswerEntity.getErId());
			lPreparedStatement.setLong(5, pAnswerEntity.getSelctedOption());
			lPreparedStatement.setLong(6, pAnswerEntity.getId());
			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			return true;
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
	public boolean delete(long pAId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AnswerEntity get(long pAId) {
		try {
			List<AnswerEntity> AnswerEntity = new ArrayList<AnswerEntity>();

			lQuery = "SELECT `answer_sheet`.`id`,`answer_sheet`.`q_id`,"
					+ "`answer_sheet`.`e_id`,`answer_sheet`.`u_id`,`answer_sheet`.`er_id`,`answer_sheet`.`selected_option"
					+ "`FROM `examinationportal`.`answer_sheet` WHERE `id`=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pAId);
			
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				AnswerEntity lEntity = new AnswerEntity();
				lEntity.setId(lResultSet.getLong(1));
				lEntity.setQId(lResultSet.getLong(2));
				lEntity.setEId(lResultSet.getLong(3));
				lEntity.setUId(lResultSet.getLong(4));
				lEntity.setErId(lResultSet.getLong(5));
				lEntity.setSelctedOption(lResultSet.getLong(6));
				
				AnswerEntity.add(lEntity);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return AnswerEntity.get(0);

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
	public List<AnswerEntity> get( long pEId, long pUId) {
		try {
			List<AnswerEntity> AnswerEntity = new ArrayList<AnswerEntity>();

			lQuery = "SELECT `answer_sheet`.`id`,`answer_sheet`.`q_id`,"
					+ "`answer_sheet`.`e_id`,`answer_sheet`.`u_id`,`answer_sheet`.`er_id`,`answer_sheet`.`selected_option"
					+ "`FROM `examinationportal`.`answer_sheet` WHERE `e_id`=? AND `u_id`=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			
			lPreparedStatement.setLong(1, pEId);
			lPreparedStatement.setLong(2, pUId);
			
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				AnswerEntity lEntity = new AnswerEntity();
				lEntity.setId(lResultSet.getLong(1));
				lEntity.setQId(lResultSet.getLong(2));
				lEntity.setEId(lResultSet.getLong(3));
				lEntity.setUId(lResultSet.getLong(4));
				lEntity.setErId(lResultSet.getLong(5));
				lEntity.setSelctedOption(lResultSet.getLong(6));
				
				AnswerEntity.add(lEntity);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return AnswerEntity;

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
	public List<AnswerEntity> get(long pQId, long pEId, long pUId) {
		try {
			List<AnswerEntity> AnswerEntity = new ArrayList<AnswerEntity>();

			lQuery = "SELECT `answer_sheet`.`id`,`answer_sheet`.`q_id`,"
					+ "`answer_sheet`.`e_id`,`answer_sheet`.`u_id`,`answer_sheet`.`er_id`,`answer_sheet`.`selected_option"
					+ "`FROM `examinationportal`.`answer_sheet` WHERE `q_id`=? AND `e_id`=? AND `u_id`=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pQId);
			lPreparedStatement.setLong(2, pEId);
			lPreparedStatement.setLong(3, pUId);
			
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				AnswerEntity lEntity = new AnswerEntity();
				lEntity.setId(lResultSet.getLong(1));
				lEntity.setQId(lResultSet.getLong(2));
				lEntity.setEId(lResultSet.getLong(3));
				lEntity.setUId(lResultSet.getLong(4));
				lEntity.setErId(lResultSet.getLong(5));
				lEntity.setSelctedOption(lResultSet.getLong(6));
				
				AnswerEntity.add(lEntity);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return AnswerEntity;

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
	public long count() {
		try {

			lQuery = "SELECT COUNT(*) FROM `examinationportal`.`answer_sheet`;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			long count = 0;
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				count = lResultSet.getLong(1);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return count;

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
			return 0;
		}
	}

	@Override
	public long count(long pAId) {
		try {
			lQuery = "SELECT COUNT(*) FROM `examinationportal`.`answer_sheet` WHERE `id`=? ;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pAId);
			long count = 0;
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				count = lResultSet.getLong(1);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return count;

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
			return 0;
		}
	}

	@Override
	public long count(long pEId, long pUId) {
		try {
			lQuery = "SELECT COUNT(*) FROM `examinationportal`.`answer_sheet` WHERE `e_id`=? AND `u_id`=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
		
			lPreparedStatement.setLong(1, pEId);
			lPreparedStatement.setLong(2, pUId);
			long count = 0;
			lResultSet = lPreparedStatement.executeQuery();
			if (lResultSet.next()) {
				count = lResultSet.getLong(1);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return count;

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
			
			return 0;
		}
	}

}
