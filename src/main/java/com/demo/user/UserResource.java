package com.demo.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retriveAllUsers(@PathVariable int id){
		User user = userDaoService.FindOne(id);
		if(user == null) {
			throw new UserNotFoundExcpetion("id :"+id);
		}
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUsers(@PathVariable int id){
		User user = userDaoService.deleteById(id);
		if(user == null) {
			throw new UserNotFoundExcpetion("id :"+id);
		}
		return user;
	}
	
	@PostMapping("/users")
	public void createUsers(@Valid @RequestBody User user) {
		userDaoService.save(user);
	}
}
