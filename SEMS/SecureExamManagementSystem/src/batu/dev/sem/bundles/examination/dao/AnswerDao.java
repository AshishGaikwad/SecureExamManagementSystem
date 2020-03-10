package batu.dev.sem.bundles.examination.dao;

import java.util.List;

import batu.dev.sem.bundles.examination.entity.AnswerEntity;

public interface AnswerDao 
{
	public boolean create(AnswerEntity pAnswerEntity);
	public boolean update(AnswerEntity pAnswerEntity);
	public boolean delete(long pAId);
	public AnswerEntity get(long pAId);
	public List<AnswerEntity> get(long pQId, long pEId, long pUI);
	public List<AnswerEntity>get( long pEId, long pUId);
	public long count();
	public long count(long pAId);
	public long count(long pEId, long pUId);
}
