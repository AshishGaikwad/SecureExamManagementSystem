package batu.dev.sem.bundles.examination.entity;

public class ExamRegistrationEntity 
{
	private long Id;
	private long EId;
	private long UId;
	private String PId;
	private String Passcode;
	private String Status;
	
	
	
	
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPasscode() {
		return Passcode;
	}
	public void setPasscode(String passcode) {
		Passcode = passcode;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getEId() {
		return EId;
	}
	public void setEId(long eId) {
		EId = eId;
	}
	public long getUId() {
		return UId;
	}
	public void setUId(long uId) {
		UId = uId;
	}
	
	
	public String getPId() {
		return PId;
	}
	public void setPId(String pId) {
		PId = pId;
	}
	@Override
	public String toString() {
		return "ExamRegistrationEntity [Id=" + Id + ", EId=" + EId + ", UId=" + UId + ", PId=" + PId + ", Passcode="
				+ Passcode + ", Status=" + Status + "]";
	}
	
	
	
	
}
