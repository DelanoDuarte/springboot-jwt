/**
 * 
 */
package br.com.authapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.authapi.model.ApplicationUser;

/**
 * @author Delano Jr
 *
 */
@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
	
	Optional<ApplicationUser> findByUsername(String username);
	
}
