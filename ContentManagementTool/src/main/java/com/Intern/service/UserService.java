package com.Intern.service;

import java.util.List;
import com.Intern.payload.UserDtos;

public interface UserService {

	UserDtos createUser(UserDtos user);
	UserDtos updateUser(UserDtos userDto ,Integer userId);
	UserDtos getUserById(Integer userId);
	List<UserDtos> getAllUsers();
	void deleteUser(Integer UserId);
}