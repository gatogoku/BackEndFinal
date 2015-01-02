package org.sistema.springmvc.forms.models;

/**
 * Represents a user.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
public class User {

	private int id;
	private String login;
	private String description;
	private String password;

	public User() {
	}

	public User(int id, String login, String description, String password) {
		this.id = id;
		this.login = login;
		this.description = description;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
