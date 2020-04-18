package com.user_admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String UserId;
	@Email
	private String userName;
	private String password;
	
	public User() {}

	public User(String userId, @Email String userName, String password) {
		UserId = userId;
		this.userName = userName;
		this.password = password;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	

}
