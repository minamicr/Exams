package br.com.minami.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.minami.model.User;
import br.com.minami.repository.UserDAO;

@Component
public class CustomUserDetailService implements UserDetailsService{
	private final UserDAO userDAO;
	
	@Autowired
	public CustomUserDetailService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Optional.ofNullable(userDAO.findByUsername(username))
			.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		return new org.springframework.security.core.userdetails.User(user.getUsername()
				, user.getPassword()
				, user.isAdmin() ? authorityListAdmin : authorityListUser);
	}

}
