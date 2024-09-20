package curso.springboot.springboot.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role implements GrantedAuthority {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeRole;


	@Override
	public String getAuthority() { // ROLE_ADMIN , ROLE_GERENTE, ROLE_SECRETARIO
		return this.nomeRole;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}


	public String getNomeRole() {
		return nomeRole;
	}


	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}


}
