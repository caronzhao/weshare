package org.weshare.model;

/**
 * @author Caron Zhao
 *
 * Mar 16, 2014 9:25:35 PM
 */
public class RegisterProfile {
	// required
	private String nickName;
	
	// required. The confirmed password will be done in UI side
	private String password;
	
	// required. It can get automatically
	private String phoneNumber;

	// optional
	private String email;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}