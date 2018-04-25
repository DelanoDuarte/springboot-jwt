package br.com.authapi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_application_user")
public class ApplicationUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "isn_user")
	private Long isnUser;

	@Column
	private String username;

	@Column
	private String password;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<ApplicationRole> roles;

	public ApplicationUser() {

	}

	public ApplicationUser(String username, String password, Set<ApplicationRole> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getIsnUser() {
		return isnUser;
	}

	public void setIsnUser(Long isnUser) {
		this.isnUser = isnUser;
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

	public Set<ApplicationRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<ApplicationRole> roles) {
		this.roles = roles;
	}

}
