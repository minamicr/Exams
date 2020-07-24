package br.com.minami.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import br.com.minami.model.User;

@Component
public interface UserDAO extends PagingAndSortingRepository<User, Long> {
	User findByUsername(String username);
}
