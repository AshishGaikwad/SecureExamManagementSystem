package batu.dev.sem.bundles.examination.dao;

import java.util.List;
import java.util.Set;

import batu.dev.sem.bundles.examination.entity.QuestionEntity;

public interface QuestionDao 
{
	public String create(QuestionEntity pQuestionEntity);
	public String update(QuestionEntity pQuestionEntity);
	public String delete(long pQuestionId);
	public List<QuestionEntity> get();
	public List<QuestionEntity> get(long pQuestionId);
	public List<QuestionEntity> get(String pQuestion);
	public List<QuestionEntity> getBySubject(long pSubjectId);
	public String getSubjectQuestionDetails(long pSubjectId);
	
	public Set<Long> generateQuestions(long uid, long eid);
	public boolean insertGenreatedUsersQuestions(long uid, long eid, long ErId);
	
	
}
