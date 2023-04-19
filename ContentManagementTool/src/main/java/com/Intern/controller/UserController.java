package com.Intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Intern.payload.ApiResponse;
import com.Intern.payload.UserDtos;
import com.Intern.service.UserService;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDtos> createUser(@Valid @RequestBody UserDtos userDtos){
		UserDtos createUserDtos = this.userService.createUser(userDtos);
		return new ResponseEntity<UserDtos>(createUserDtos, HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDtos> updateUser(@Valid @RequestBody UserDtos userDtos,  @PathVariable("userId")Integer uid){
		UserDtos updateUser = this.userService.updateUser(userDtos, uid);
		return ResponseEntity.ok(updateUser);
	}
	

	@GetMapping("/{userId}")
	public ResponseEntity<UserDtos> getUserById(@PathVariable("userId") Integer uid){
		return ResponseEntity.ok(this.userService.getUserById(uid));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDtos>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		//return new ResponseEntity<>(Map.of("message", "User Deleted Successfully"), HttpStatus.OK);
	     return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",false),HttpStatus.OK);
    }
}
