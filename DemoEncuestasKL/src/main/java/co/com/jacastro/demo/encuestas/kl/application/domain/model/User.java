package co.com.jacastro.demo.encuestas.kl.application.domain.model;

import java.util.Date;
import java.util.Objects;

public class User {

	public static final String USER_AUTHORIZED = "USER_AUTHORIZED";
	public static final String USER_NOT_AUTHORIZED = "USER_NOT_AUTHORIZED";
	public static final String USER_NOT_EXIST = "USER_NOT_EXIST";
	public static final String USER_CREATED = "USER_CREATED";
	public static final String USER_UPDATE = "USER_UPDATE";

	private String username;
	private String password;
	private String email;
	private String rol;
	private String status;
	private Date expiredDate;
	private String token;

	public User() {
	}

	public User(String userName, String email, String rol, String status, Date expiredDate, String token) {
		super();
		this.username = userName;
		this.email = email;
		this.rol = rol;
		this.status = status;
		this.expiredDate = expiredDate;
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, expiredDate, password, rol, status, token, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(expiredDate, other.expiredDate)
				&& Objects.equals(password, other.password) && Objects.equals(rol, other.rol)
				&& Objects.equals(status, other.status) && Objects.equals(token, other.token)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "AuthenticatedUser [username=" + username + ", password=" + password + ", email=" + email + ", rol="
				+ rol + ", status=" + status + ", expiredDate=" + expiredDate + ", token=" + token + "]";
	}

}
