package batu.dev.sem.bundles.examination.dao;

import java.util.List;

import batu.dev.sem.bundles.examination.entity.SubjectEntity;

public interface SubjectDao {
	public String add(SubjectEntity pSubjectEntity);
	public List<SubjectEntity> get();
	public List<SubjectEntity> get(long pId);
	public List<SubjectEntity> get(String pName);
	public List<SubjectEntity> fetchOnHead(long pHeadId);
	public boolean isExist(String pName);
	public String update(SubjectEntity pSubjectEntity);
	public String delete(long pSubjectId);
}
