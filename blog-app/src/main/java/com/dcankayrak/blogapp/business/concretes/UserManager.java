package com.dcankayrak.blogapp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcankayrak.blogapp.business.abstracts.UserService;
import com.dcankayrak.blogapp.entities.User;
import com.dcankayrak.blogapp.repositories.UserRepository;
import com.dcankayrak.blogapp.requests.UserCreateRequest;
import com.dcankayrak.blogapp.requests.UserUpdateRequest;

@Service
public class UserManager implements UserService{
	
	private UserRepository theUserRepository;

	@Autowired
	public UserManager(UserRepository theUserRepository) {
		this.theUserRepository = theUserRepository;
	}

	@Override
	public List<User> getUsers() {
		return this.theUserRepository.findAll();
	}

	@Override
	public User getUser(int id) {
		Optional<User> foundUser = this.theUserRepository.findById(id);
		
		if(foundUser.isPresent()) {
			return foundUser.get();
		}
		return null;
	}

	@Override
	public User createUser(UserCreateRequest createUser) {
		User newUser = new User();
		newUser.setName(createUser.getName());
		newUser.setMail(createUser.getMail());
		newUser.setPassword(createUser.getPassword());
		
		return this.theUserRepository.save(newUser);
	}

	@Override
	public User updateUser(int id, UserUpdateRequest updateUser) {
		Optional<User> newUser = this.theUserRepository.findById(id);
		
		if(newUser.isPresent()) {
			User updatedUser = new User();
			updatedUser.setId(id);
			updatedUser.setName(updateUser.getName());
			updatedUser.setMail(updateUser.getMail());
			updatedUser.setPassword(updateUser.getPassword());
			
			return this.theUserRepository.save(updatedUser);
		}
		return null;
	}

	@Override
	public void deleteUser(int id) {
		if(this.theUserRepository.findById(id).isPresent()) {
			this.theUserRepository.deleteById(id);
		}
		
	}
	
	
}
