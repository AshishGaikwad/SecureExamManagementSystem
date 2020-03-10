package batu.dev.sem.bundles.examination.entity;

import com.google.gson.Gson;

public class SubjectEntity 
{
	private long id;
	private String name;
	private String code;
	private long head;
	private String admissionStartDate; 
	private String admissionEndDate; 
	private String examinationDate;
	private String resultDate;
	private double fee;
	private String desc;
	
	
	
	
	
	
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getResultDate() {
		return resultDate;
	}
	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getHead() {
		return head;
	}
	public void setHead(long head) {
		this.head = head;
	}
	public String getAdmissionStartDate() {
		return admissionStartDate;
	}
	public void setAdmissionStartDate(String admissionStartDate) {
		this.admissionStartDate = admissionStartDate;
	}
	public String getAdmissionEndDate() {
		return admissionEndDate;
	}
	public void setAdmissionEndDate(String admissionEndDate) {
		this.admissionEndDate = admissionEndDate;
	}
	public String getExaminationDate() {
		return examinationDate;
	}
	public void setExaminationDate(String examinationDate) {
		this.examinationDate = examinationDate;
	}
	
	@Override
	public String toString() {
		return "SubjectEntity [id=" + id + ", name=" + name + ", code=" + code + ", head=" + head
				+ ", admissionStartDate=" + admissionStartDate + ", admissionEndDate=" + admissionEndDate
				+ ", examinationDate=" + examinationDate + ", resultDate=" + resultDate + ", fee=" + fee + ", desc="
				+ desc + "]";
	} 
	
	
	
	
}
