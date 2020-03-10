package batu.dev.sem.utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="temp_table")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long lId;
	
	@Column(name="name")
	private String lName;
	
	@Column(name="lastname")
	private String lLastMame;
	public long getlId() {
		return lId;
	}
	public void setlId(long lId) {
		this.lId = lId;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getlLastMame() {
		return lLastMame;
	}
	public void setlLastMame(String lLastMame) {
		this.lLastMame = lLastMame;
	}
	@Override
	public String toString() {
		return "Test [lId=" + lId + ", lName=" + lName + ", lLastMame=" + lLastMame + "]";
	}
	
	
	
	
}
