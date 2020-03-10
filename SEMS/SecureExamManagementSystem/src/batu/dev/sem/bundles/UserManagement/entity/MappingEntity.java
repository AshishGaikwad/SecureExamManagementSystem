package batu.dev.sem.bundles.UserManagement.entity;

public class MappingEntity {
	private long id;
	private long RoleId;
	private long UserId;
	private long Rowstate;
	private String filler1;
	public String getFiller1() {
		return filler1;
	}
	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public long getRoleId() {
		return RoleId;
	}
	public void setRoleId(long roleId) {
		RoleId = roleId;
	}
	public long getRowstate() {
		return Rowstate;
	}
	public void setRowstate(long rowstate) {
		Rowstate = rowstate;
	}
	@Override
	public String toString() {
		return "UserRoleMappingEntity [id=" + id + ", UserId=" + UserId + ", RoleId=" + RoleId + ", Rowstate="
				+ Rowstate + "]";
	} 
	
	
}
