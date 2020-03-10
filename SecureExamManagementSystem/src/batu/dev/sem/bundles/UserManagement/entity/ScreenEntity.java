package batu.dev.sem.bundles.UserManagement.entity;

public class ScreenEntity {
	private long ScreenId;
	private String ScreenName;
	private String ScreenUrl;
	private long  ScreenParentId;
	private String ScreenMenuLevel;
	private String ScreenMenuIcon;
	private int Rowstate;
	public long getScreenId() {
		return ScreenId;
	}
	public void setScreenId(long screenId) {
		ScreenId = screenId;
	}
	public String getScreenName() {
		return ScreenName;
	}
	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}
	public String getScreenUrl() {
		return ScreenUrl;
	}
	public void setScreenUrl(String screenUrl) {
		ScreenUrl = screenUrl;
	}
	public long getScreenParentId() {
		return ScreenParentId;
	}
	public void setScreenParentId(long screenParentId) {
		ScreenParentId = screenParentId;
	}
	public String getScreenMenuLevel() {
		return ScreenMenuLevel;
	}
	public void setScreenMenuLevel(String screenMenuLevel) {
		ScreenMenuLevel = screenMenuLevel;
	}
	public int getRowstate() {
		return Rowstate;
	}
	public void setRowstate(int rowstate) {
		Rowstate = rowstate;
	}
	
	
	
	public String getScreenMenuIcon() {
		return ScreenMenuIcon;
	}
	public void setScreenMenuIcon(String screenMenuIcon) {
		ScreenMenuIcon = screenMenuIcon;
	}
	@Override
	public String toString() {
		return "ScreenEntity [ScreenId=" + ScreenId + ", ScreenName=" + ScreenName + ", ScreenUrl=" + ScreenUrl
				+ ", ScreenParentId=" + ScreenParentId + ", ScreenMenuLevel=" + ScreenMenuLevel + ", ScreenMenuIcon="
				+ ScreenMenuIcon + ", Rowstate=" + Rowstate + "]";
	}
	
	
}
