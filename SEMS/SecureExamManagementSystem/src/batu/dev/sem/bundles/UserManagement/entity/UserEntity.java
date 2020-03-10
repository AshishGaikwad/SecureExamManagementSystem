package batu.dev.sem.bundles.UserManagement.entity;

import com.google.gson.annotations.Expose;

public class UserEntity 
{
	private long UserId;
	
	private String FullName;
	
	private String DateOfBirth;
	
	@Expose(serialize = false) 
	private String Password;
	
	private String Email;
	
	private String Mobile;
	
	private int Status;
	
	private long CreatedBy;
	
	private String CreatedAt;
	
	private long UpdatedBy;
	
	private String UpdatedAt;
	
	private String Pas;
	
	

	
	
	public String getPas() {
		return Pas;
	}
	public void setPas(String pas) {
		Pas = pas;
	}
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public long getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(long createdBy) {
		CreatedBy = createdBy;
	}
	public String getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(String createdAt) {
		CreatedAt = createdAt;
	}
	public long getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(long updatedBy) {
		UpdatedBy = updatedBy;
	}
	public String getUpdatedAt() {
		return UpdatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		UpdatedAt = updatedAt;
	}
@Override
	public String toString() {
		return "UserEntity [UserId=" + UserId + ", FullName=" + FullName + ", DateOfBirth=" + DateOfBirth
				+ ", Password=" + Password + ", Email=" + Email + ", Mobile=" + Mobile + ", Status=" + Status
				+ ", CreatedBy=" + CreatedBy + ", CreatedAt=" + CreatedAt + ", UpdatedBy=" + UpdatedBy + ", UpdatedAt="
				+ UpdatedAt + ", Pas=" + Pas + "]";
	}
	
	
}
