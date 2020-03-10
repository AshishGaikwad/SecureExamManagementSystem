package batu.dev.sem.bundles.UserManagement.entity;

public class RoleEntity {
	private long RoleId;
	private String RoleName;
	private String RoleState;
	private long CreatedBy;
	private String CreatedAt;
	private long UpdatedBy;
	private String UpdatedAt;
	
	public long getRoleId() {
		return RoleId;
	}
	public void setRoleId(long roleId) {
		RoleId = roleId;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public String getRoleState() {
		return RoleState;
	}
	public void setRoleState(String roleState) {
		RoleState = roleState;
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
		return "RoleEntity [RoleId=" + RoleId + ", RoleName=" + RoleName + ", RoleState=" + RoleState + ", CreatedBy="
				+ CreatedBy + ", CreatedAt=" + CreatedAt + ", UpdatedBy=" + UpdatedBy + ", UpdatedAt=" + UpdatedAt
				+ "]";
	}


	

}
