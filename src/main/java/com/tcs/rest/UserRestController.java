package com.tcs.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.domain.UserEntity;
import com.tcs.repo.UserEntityRepo;

@RestController
@RequestMapping
public class UserRestController {
	
	@Autowired
	private UserEntityRepo userRepo;
	
	@PostMapping("/save")
	public UserEntity  saveUser(@RequestBody UserEntity user) {
		
		return userRepo.save(user);
	}
	@GetMapping("/{id}")
public UserEntity  saveUser(@PathVariable String id) {
		Optional<UserEntity> byId = userRepo.findById(id);
		return byId.get();
	}
	
	
	

}
