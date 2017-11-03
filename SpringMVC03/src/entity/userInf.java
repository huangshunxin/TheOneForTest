package entity;

public class userInf {
	private String username;
	private String pws;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPws() {
		return pws;
	}
	public void setPws(String pws) {
		this.pws = pws;
	}
	@Override
	public String toString() {
		return "userInf [username=" + username + ", pws=" + pws + "]";
	}
	
}
