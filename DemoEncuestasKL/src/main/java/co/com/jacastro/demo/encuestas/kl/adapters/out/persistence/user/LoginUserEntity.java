package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.user;

import java.util.Objects;

public class LoginUserEntity {

	private String username;
	private String password;

	public LoginUserEntity() {
	}

	public LoginUserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginUserEntity other = (LoginUserEntity) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "LoginUserEntity [username=" + username + ", password=" + password + "]";
	}

}
