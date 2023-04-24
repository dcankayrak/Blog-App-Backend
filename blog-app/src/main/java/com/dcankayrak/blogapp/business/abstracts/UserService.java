package com.dcankayrak.blogapp.business.abstracts;

import java.util.List;

import com.dcankayrak.blogapp.entities.User;
import com.dcankayrak.blogapp.requests.UserCreateRequest;
import com.dcankayrak.blogapp.requests.UserUpdateRequest;

public interface UserService {
	List<User> getUsers();
	User getUser(int id);
	User createUser(UserCreateRequest createUser);
	User updateUser(int id,UserUpdateRequest updateUser);
	void deleteUser(int id);
}
