/**
 * 
 */
package br.com.authapi.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.authapi.model.ApplicationUser;
import br.com.authapi.repository.UserRepository;

/**
 * @author Delano Jr
 *
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<ApplicationUser> applicationUser = userRepository.findByUsername(username);

		if (!applicationUser.isPresent())
			return null;

		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		applicationUser.get().getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});

		User user = new User(applicationUser.get().getUsername(),
				bCryptPasswordEncoder.encode(applicationUser.get().getPassword()), authorities);
		return user;
	}

}
