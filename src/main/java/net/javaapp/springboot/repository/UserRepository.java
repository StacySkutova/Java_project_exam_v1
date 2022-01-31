package net.javaapp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaapp.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
