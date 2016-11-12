package org.thomas.java.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USER_DETAILS")
public class UserDetails {
	@Id
	@Column (name="USER_ID")
	private int userId;	
	@Column (name="USER_NAME")
	private String userName;
	private String userAdd1;
	private String userAdd2;
	private String userCountry;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAdd1() {
		return userAdd1;
	}
	public void setUserAdd1(String userAdd1) {
		this.userAdd1 = userAdd1;
	}
	public String getUserAdd2() {
		return userAdd2;
	}
	public void setUserAdd2(String userAdd2) {
		this.userAdd2 = userAdd2;
	}
	public String getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}	
}
