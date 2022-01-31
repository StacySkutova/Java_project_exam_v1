package net.javaapp.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import net.javaapp.springboot.model.User;
import net.javaapp.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
