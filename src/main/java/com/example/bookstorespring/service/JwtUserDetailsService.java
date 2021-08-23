package com.example.bookstorespring.service;

import com.example.bookstorespring.DTO.UserDataDto;
import com.example.bookstorespring.entity.DAOUser;
import com.example.bookstorespring.entity.UserDTO;
import com.example.bookstorespring.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public UserDataDto getUserByUsername(String username) throws UsernameNotFoundException{
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		UserDataDto responseUser = new UserDataDto();
		responseUser.setUsername(user.getUsername());
		responseUser.setName(user.getName());
		responseUser.setMobile(user.getMobile());
		return responseUser;
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setName(user.getName());
		newUser.setMobile(user.getMobile());
		return userDao.save(newUser);
	}
	public void update(String username, DAOUser address){
		userDao.updateUserAddress(address.getAddress(),username,address.getCity(),address.getLandmark()
		,address.getPincode(),address.getLocality());
	}
}