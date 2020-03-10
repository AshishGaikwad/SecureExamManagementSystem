package batu.dev.sem.bundles.examination.dao;

import java.util.List;

import batu.dev.sem.bundles.examination.entity.ExaminationEntity;

public interface ExaminationDao {
	
	public String create(ExaminationEntity pExaminationEntity);
	public String update(ExaminationEntity pExaminationEntity);
	public String delete(ExaminationEntity pExaminationEntity);
	
	public List<ExaminationEntity> get();
	public ExaminationEntity get(long pExaminationId);
	public ExaminationEntity get(String pExaminationTitle);
	public List<ExaminationEntity> getOnSubjectId(long pSubjectId);
	
	
	
	
}
