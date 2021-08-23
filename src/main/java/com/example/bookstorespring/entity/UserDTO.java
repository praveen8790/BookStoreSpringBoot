package com.example.bookstorespring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	private String username;
	private String password;
	private String name;
	private String mobile;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}