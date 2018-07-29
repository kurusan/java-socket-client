package com.bank.logic.auth;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

	private String login;
	private String password;
	
	public User(String login, String password) {
		this.setLogin(login);
		this.setPassword(password);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
