
package batu.dev.sem.bundles.examination.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import batu.dev.sem.bundles.examination.dao.AnswerDao;
import batu.dev.sem.bundles.examination.dao.ExaminationDao;
import batu.dev.sem.bundles.examination.dao.QuestionDao;
import batu.dev.sem.bundles.examination.entity.AnswerEntity;
import batu.dev.sem.bundles.examination.entity.ExaminationEntity;
import batu.dev.sem.bundles.examination.entity.QuestionEntity;
import batu.dev.sem.utils.MySQLConnector;
import batu.dev.sem.utils.Util;

public class QuestionDaoImpl implements QuestionDao {

	private Connection lConnection = null;
	private PreparedStatement lPreparedStatement = null;
	private ResultSet lResultSet = null;
	private String lQuery = "";
	private ExaminationDao lExaminationDao = new ExaminationDaoImpl();
	private AnswerDao lAnswerDao = new AnswerDaoImpl();

	@Override
	public String create(QuestionEntity pQuestionEntity) {
		try {
			lQuery = "INSERT INTO `examinationportal`.`questions`"
					+ "(`questions_id`,`questions_subject_id`,`questions_question`,"
					+ "`questions_options`,`questions_correct_option`,`questions_marks`" + ")VALUES(null,?,?,?,?,?);";
			lConnection = MySQLConnector.getConnection();

			lConnection.setAutoCommit(false);
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pQuestionEntity.getSubjectId());
			lPreparedStatement.setString(2, pQuestionEntity.getQuestion());
			lPreparedStatement.setString(3, pQuestionEntity.getOptions());
			lPreparedStatement.setInt(4, pQuestionEntity.getCorrectAnswer());
			lPreparedStatement.setInt(5, pQuestionEntity.getMarks());

			int res = lPreparedStatement.executeUpdate();
			lConnection.commit();

			if (res > 0)
				return Util.nofity("Question added successfully.", "success");
			else
				return Util.nofity("Failed to add Question.", "error");
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
	public String update(QuestionEntity pQuestionEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(long pQuestionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionEntity> get() {
		try {
			List<QuestionEntity> lQuestionEntities = new ArrayList<QuestionEntity>();

			lQuery = "SELECT`questions`.`questions_id`,`questions`.`questions_subject_id`,`questions`.`questions_question`,`questions`.`questions_options`,`questions`.`questions_correct_option`,`questions`.`questions_marks`FROM `examinationportal`.`questions`;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				QuestionEntity lEntity = new QuestionEntity();
				lEntity.setId(lResultSet.getLong(1));
				lEntity.setSubjectId(lResultSet.getLong(2));
				lEntity.setQuestion(lResultSet.getString(3));
				lEntity.setOptions(lResultSet.getString(4));
				lEntity.setCorrectAnswer(lResultSet.getInt(5));
				lEntity.setMarks(lResultSet.getInt(6));
				lQuestionEntities.add(lEntity);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lQuestionEntities;

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
	public List<QuestionEntity> get(long pQuestionId) {
		try {
			List<QuestionEntity> lQuestionEntities = new ArrayList<QuestionEntity>();

			lQuery = "SELECT`questions`.`questions_id`,`questions`.`questions_subject_id`,`questions`.`questions_question`,`questions`.`questions_options`,`questions`.`questions_correct_option`,`questions`.`questions_marks`FROM `examinationportal`.`questions` WHERE questions_id="
					+ pQuestionId;
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				QuestionEntity lEntity = new QuestionEntity();
				lEntity.setId(lResultSet.getLong(1));
				lEntity.setSubjectId(lResultSet.getLong(2));
				lEntity.setQuestion(lResultSet.getString(3));
				lEntity.setOptions(lResultSet.getString(4));
				lEntity.setCorrectAnswer(lResultSet.getInt(5));
				lEntity.setMarks(lResultSet.getInt(6));
				lQuestionEntities.add(lEntity);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lQuestionEntities;

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
	public List<QuestionEntity> get(String pQuestion) {
		try {
			List<QuestionEntity> lQuestionEntities = new ArrayList<QuestionEntity>();

			lQuery = "SELECT`questions`.`questions_id`,`questions`.`questions_subject_id`,`questions`.`questions_question`,`questions`.`questions_options`,`questions`.`questions_correct_option`,`questions`.`questions_marks`FROM `examinationportal`.`questions` WHERE questions_question='"
					+ pQuestion + "'";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				QuestionEntity lEntity = new QuestionEntity();
				lEntity.setId(lResultSet.getLong(1));
				lEntity.setSubjectId(lResultSet.getLong(2));
				lEntity.setQuestion(lResultSet.getString(3));
				lEntity.setOptions(lResultSet.getString(4));
				lEntity.setCorrectAnswer(lResultSet.getInt(5));
				lEntity.setMarks(lResultSet.getInt(6));
				lQuestionEntities.add(lEntity);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lQuestionEntities;

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
	public List<QuestionEntity> getBySubject(long pSubjectId) {
		try {
			List<QuestionEntity> lQuestionEntities = new ArrayList<QuestionEntity>();

			lQuery = "SELECT`questions`.`questions_id`,`questions`.`questions_subject_id`,`questions`.`questions_question`,`questions`.`questions_options`,`questions`.`questions_correct_option`,`questions`.`questions_marks`FROM `examinationportal`.`questions` WHERE questions_subject_id="
					+ pSubjectId;
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				QuestionEntity lEntity = new QuestionEntity();
				lEntity.setId(lResultSet.getLong(1));
				lEntity.setSubjectId(lResultSet.getLong(2));
				lEntity.setQuestion(lResultSet.getString(3));
				lEntity.setOptions(lResultSet.getString(4));
				lEntity.setCorrectAnswer(lResultSet.getInt(5));
				lEntity.setMarks(lResultSet.getInt(6));
				lQuestionEntities.add(lEntity);
			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lQuestionEntities;

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
	public String getSubjectQuestionDetails(long pSubjectId) {
		try {
			JSONArray lJSONArray = new JSONArray();

			lQuery = "SELECT DISTINCT questions_subject_id as subid, questions_marks as marks ,(Select COUNT(marks) FROM examinationportal.questions  where questions_marks=marks and questions_subject_id=subid) as count FROM examinationportal.questions where questions_subject_id=?;";
			lConnection = MySQLConnector.getConnection();
			lPreparedStatement = lConnection.prepareStatement(lQuery);
			lPreparedStatement.setLong(1, pSubjectId);
			lResultSet = lPreparedStatement.executeQuery();
			while (lResultSet.next()) {
				JSONObject lObject = new JSONObject();
				lObject.put("questions_subject_id", lResultSet.getLong(1));
				lObject.put("questions_marks", lResultSet.getLong(2));
				lObject.put("count", lResultSet.getLong(3));
				lJSONArray.put(lObject);

			}
			lResultSet.close();
			lPreparedStatement.close();
			lConnection.close();
			return lJSONArray.toString();

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
	public Set<Long> generateQuestions(long uid, long eid) {
		try {

			ExaminationEntity lExaminationEntity = lExaminationDao.get(eid);
			String lQuestionPaper = lExaminationEntity.geteMarkQueDetails();
			// 1=3,2=3,3=2,5=2

			List<QuestionEntity> lQE = getBySubject(lExaminationEntity.geteSubjectId());

			String qmList[] = lQuestionPaper.split(",");
			Set<Long> lQuestionSet = new HashSet<Long>();

			for (int i = 0; i < qmList.length; i++) {
				String singleQM[] = qmList[i].split("=");

				int queCount = 1;
				while (queCount <= Integer.parseInt(singleQM[1])) {
					for (QuestionEntity lQuestionEntity : lQE) {

						if (lQuestionEntity.getMarks() == Integer.parseInt(singleQM[0])) {
							if (!lQuestionSet.contains(lQuestionEntity.getId())) {
								lQuestionSet.add(lQuestionEntity.getId());
								queCount++;
								break;
							}
						}

					}
				}
			}

			return lQuestionSet;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean insertGenreatedUsersQuestions(long uid, long eid,long erId) {
		try {
			Set<Long> lSet =  generateQuestions(uid, eid);
			
			for (Long qid : lSet) {
				AnswerEntity lAnswerEntity = new AnswerEntity();
				
				lAnswerEntity.setQId(qid);
				lAnswerEntity.setEId(eid);
				lAnswerEntity.setUId(uid);
				lAnswerEntity.setErId(erId);
				lAnswerEntity.setSelctedOption(0);
				
				lAnswerDao.create(lAnswerEntity);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static void main(String[] args) {
		System.err.println(new QuestionDaoImpl().generateQuestions(9, 3));
	}

}
