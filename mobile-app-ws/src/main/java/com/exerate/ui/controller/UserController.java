package com.exerate.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exerate.ui.model.UserRest;
import com.exerate.ui.model.request.UserDetailsRequestModel;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	Map<String,UserRest> users;
	

	@GetMapping
	public String getUser(@RequestParam(value = "limit", defaultValue = "10") int l,
			@RequestParam(value = "page", defaultValue = "1") int p,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String s) {

		return "get user method was called with page " + p + " and limit in a page is " + l + " sorted in " + s;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable("userId") String id) {
		
		
		if (users.containsKey(id)) {
			return new ResponseEntity<UserRest>(users.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}

//		UserRest user = new UserRest();
//		user.setFirstName("Fatih");
//		user.setLastName("Sevim");
//		user.setEmail("test@gamil.com");

		
	}

	@PostMapping(consumes = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
				produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) {

		UserRest user = new UserRest();
		user.setFirstName(userDetailsRequestModel.getFirstName());
		user.setLastName(userDetailsRequestModel.getLastName());
		user.setEmail(userDetailsRequestModel.getEmail());
		
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		if (users==null) users=new HashMap<String, UserRest>();
		users.put(userId, user);

		return new ResponseEntity<UserRest>(user, HttpStatus.OK);
		
	
	}

	@PutMapping
	public String updateUser() {

		return "update user method was called";
	}

	@DeleteMapping
	public String deleteUser() {

		return "delete user method was called";
	}

}
