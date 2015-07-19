package nl.rsvier.icaras.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name= "users", catalog = "icaras")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public User() {

	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	@Id
	@NotBlank(message="Gebruikersnaam mag niet leeg zijn")
	@Size(min=4, max=15, message="Gebruikersnaam moet tussen de 4 en 15 letters lang zijn")
	@Pattern(regexp="^\\w{4,}$", message="Gebruikersnaam mag alleen uit letters, cijfers en underscore bestaan")
	@Column(name="username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotBlank(message="Wachtwoord mag niet leeg zijn")
	@Pattern(regexp="^\\S+$")
	@Size(min=8, max=15, message="Wachtwoord moet tussen de 4 en 15 letters lang zijn")
	@Column(name="password", nullable = false, length = 60)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany (fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

}
