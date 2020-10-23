package org.ict.microservice.repository;

import java.util.Optional;

import org.ict.microservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Nojan Bakhtiarian
 * @since 07.08.2020
 * 
 * providing the definition of methods and Jpa provides others automatically
 * Input: User entity and Integer id as primary key
 * there are lots of defined methods by JpaRepository, but new method should be added here.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
//	creating a functionality to look up a user by passing user name in database by Jpa
	Optional<User> findByUserName(String userName);

	Optional<User> deleteByUserName(String userName);

}