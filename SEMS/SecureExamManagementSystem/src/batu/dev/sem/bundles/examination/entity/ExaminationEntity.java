package batu.dev.sem.bundles.examination.entity;

public class ExaminationEntity {
	
	private long eId;
	private String eTitle;
	private long eSubjectId;
	private String eMarkQueDetails;
	private long eTotalQue;
	private long eTotalMarks;	
	private long ePassingMarks;
	private long eDuration;
	private String eDescription;	
	private String eAdmissionStartDate;
	private String eAdmissionLastDate;
	private String eHallTicketDate;
	private String eDate;
	private String eResultDate;
	private double eFee;
	private int eIsActive;
	
	
		
	
	
	
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteResultDate() {
		return eResultDate;
	}
	public void seteResultDate(String eResultDate) {
		this.eResultDate = eResultDate;
	}
	public long geteTotalQue() {
		return eTotalQue;
	}
	public void seteTotalQue(long eTotalQue) {
		this.eTotalQue = eTotalQue;
	}
	public String geteDescription() {
		return eDescription;
	}
	public void seteDescription(String eDescription) {
		this.eDescription = eDescription;
	}
	public long geteId() {
		return eId;
	}
	public void seteId(long eId) {
		this.eId = eId;
	}
	public long geteSubjectId() {
		return eSubjectId;
	}
	public void seteSubjectId(long eSubjectId) {
		this.eSubjectId = eSubjectId;
	}
	public String geteMarkQueDetails() {
		return eMarkQueDetails;
	}
	public void seteMarkQueDetails(String eMarkQueDetails) {
		this.eMarkQueDetails = eMarkQueDetails;
	}
	public long geteTotalMarks() {
		return eTotalMarks;
	}
	public void seteTotalMarks(long eTotalMarks) {
		this.eTotalMarks = eTotalMarks;
	}
	public long getePassingMarks() {
		return ePassingMarks;
	}
	public void setePassingMarks(long ePassingMarks) {
		this.ePassingMarks = ePassingMarks;
	}

	public int geteIsActive() {
		return eIsActive;
	}
	public void seteIsActive(int eIsActive) {
		this.eIsActive = eIsActive;
	}
	public String geteHallTicketDate() {
		return eHallTicketDate;
	}
	public void seteHallTicketDate(String eHallTicketDate) {
		this.eHallTicketDate = eHallTicketDate;
	}
	public long geteDuration() {
		return eDuration;
	}
	public void seteDuration(long eDuration) {
		this.eDuration = eDuration;
	}
	public String geteAdmissionStartDate() {
		return eAdmissionStartDate;
	}
	public void seteAdmissionStartDate(String eAdmissionStartDate) {
		this.eAdmissionStartDate = eAdmissionStartDate;
	}
	public String geteAdmissionLastDate() {
		return eAdmissionLastDate;
	}
	public void seteAdmissionLastDate(String eAdmissionLastDate) {
		this.eAdmissionLastDate = eAdmissionLastDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public double geteFee() {
		return eFee;
	}
	public void seteFee(double eFee) {
		this.eFee = eFee;
	}
	@Override
	public String toString() {
		return "ExaminationEntity [eId=" + eId + ", eTitle=" + eTitle + ", eSubjectId=" + eSubjectId
				+ ", eMarkQueDetails=" + eMarkQueDetails + ", eTotalQue=" + eTotalQue + ", eTotalMarks=" + eTotalMarks
				+ ", ePassingMarks=" + ePassingMarks + ", eDuration=" + eDuration + ", eDescription=" + eDescription
				+ ", eAdmissionStartDate=" + eAdmissionStartDate + ", eAdmissionLastDate=" + eAdmissionLastDate
				+ ", eHallTicketDate=" + eHallTicketDate + ", eDate=" + eDate + ", eResultDate=" + eResultDate
				+ ", eFee=" + eFee + ", eIsActive=" + eIsActive + "]";
	}
	
	
	
	
	
}
