
public class User {
	private String userID, userPassword, userName, useryymmdd, userGender, userPhone, userTaste1, userTaste2;
	public User() {}
	//8°¡Áö
	public User(String userID,String userPassword, String userName, String useryymmdd, String userGender, String userPhone, String userTaste1, String userTaste2) {
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
		this.useryymmdd = useryymmdd;
		this.userGender = userGender;
		this.userPhone = userPhone;
		this.userTaste1 = userTaste1;
		this.userTaste2 = userTaste2;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUseryymmdd() {
		return useryymmdd;
	}
	public void setUseryymmdd(String useryymmdd) {
		this.useryymmdd = useryymmdd;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserTaste1() {
		return userTaste1;
	}
	public void setUserTaste1(String userTaste1) {
		this.userTaste1 = userTaste1;
	}
	public String getUserTaste2() {
		return userTaste2;
	}
	public void setUserTaste2(String userTaste2) {
		this.userTaste2 = userTaste2;
	}
	

}
