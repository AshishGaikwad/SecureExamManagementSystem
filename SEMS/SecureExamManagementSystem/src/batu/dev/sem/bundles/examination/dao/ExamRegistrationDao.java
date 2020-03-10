package batu.dev.sem.bundles.examination.dao;

import java.util.List;

import com.instamojo.wrapper.model.PaymentOrder;

import batu.dev.sem.bundles.examination.entity.ExamRegistrationEntity;
import batu.dev.sem.bundles.examination.entity.ExaminationEntity;

public interface ExamRegistrationDao {
	public boolean save(ExamRegistrationEntity  pExamRegistrationEntity );
	public boolean update(ExamRegistrationEntity  pExamRegistrationEntity );
	public ExamRegistrationEntity get();
	public ExamRegistrationEntity getByUid(long pUID);
	public ExamRegistrationEntity getByEid(long pEID);
	public ExamRegistrationEntity getByPid(String pPID);
	public ExamRegistrationEntity getByEidAndUid(long pEID,long pUID);
	public List<ExaminationEntity> getAppliedExamination(long pUID);
}
