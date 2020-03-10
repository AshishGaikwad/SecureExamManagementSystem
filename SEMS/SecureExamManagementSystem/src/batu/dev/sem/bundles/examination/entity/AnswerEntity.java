package batu.dev.sem.bundles.examination.entity;

public class AnswerEntity {

	private long Id;
	private long QId;
	private long EId;
	private long UId;
	private long ErId;
	private long SelctedOption;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getQId() {
		return QId;
	}

	public void setQId(long qId) {
		QId = qId;
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

	public long getErId() {
		return ErId;
	}

	public void setErId(long erId) {
		ErId = erId;
	}

	public long getSelctedOption() {
		return SelctedOption;
	}

	public void setSelctedOption(long selctedOption) {
		SelctedOption = selctedOption;
	}

	@Override
	public String toString() {
		return "AnswerEntity [Id=" + Id + ", QId=" + QId + ", EId=" + EId + ", UId=" + UId + ", ErId=" + ErId
				+ ", SelctedOption=" + SelctedOption + "]";
	}
}
