/**
 * 
 */
package br.com.authapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Delano Jr
 *
 */
@Entity
@Table(name = "tb_application_role")
public class ApplicationRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "isn_role")
	private Long isnRole;

	@Column(name = "role_name")
	private String roleName;

	public ApplicationRole() {
		super();
	}

	public ApplicationRole(Long isnRole, String roleName) {
		super();
		this.isnRole = isnRole;
		this.roleName = roleName;
	}

	public Long getIsnRole() {
		return isnRole;
	}

	public void setIsnRole(Long isnRole) {
		this.isnRole = isnRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
