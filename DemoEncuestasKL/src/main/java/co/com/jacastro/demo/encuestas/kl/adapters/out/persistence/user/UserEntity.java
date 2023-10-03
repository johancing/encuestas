package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.user;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class UserEntity implements UserDetails {

	private static final long serialVersionUID = 8210361405256019263L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String username;
	private String password;
	private String email;
	private String rol;
	private String status;
	private Date expiredDate;
	private String token;

	public UserEntity() {
	}

	public UserEntity(String username, String password, String email, String rol, String status,
			Date expiredDate, String token) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.rol = rol;
		this.status = status;
		this.expiredDate = expiredDate;
		this.token = token;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, expiredDate, id, password, rol, status, token, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(email, other.email) && Objects.equals(expiredDate, other.expiredDate)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(rol, other.rol) && Objects.equals(status, other.status)
				&& Objects.equals(token, other.token) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "AuthenticatedUserEntity [id=" + id + ", username=" + username + ", password=" + password + ", email="
				+ email + ", rol=" + rol + ", status=" + status + ", expiredDate=" + expiredDate + ", token=" + token
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
