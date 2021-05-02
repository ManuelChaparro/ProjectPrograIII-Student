package models;

public class User {

	private String nameUser;
	private String codeUser;
	private String password;

	public User(String nameUser, String codeUser, String password) {
		this.nameUser = nameUser;
		this.codeUser = codeUser;
		this.password = password;
	}
	
	public String getNameUser() {
		return nameUser;
	}

	public String getCodeUser() {
		return codeUser;
	}

	public String getPassword() {
		return password;
	}
}