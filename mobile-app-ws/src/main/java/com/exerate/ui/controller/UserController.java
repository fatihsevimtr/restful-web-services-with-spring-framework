package com.exerate.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.exerate.ui.exceptions.UserServiceException;
import com.exerate.ui.model.request.UpdateUserDetailsRequestModel;
import com.exerate.ui.model.request.UserDetailsRequestModel;
import com.exerate.ui.model.response.UserRest;
import com.exerate.ui.userservice.UserService;
import com.exerate.ui.userservice.impl.UserServiceImp;

@RestController
@RequestMapping("/api/users")
public class UserController {

	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser(@RequestParam(value = "limit", defaultValue = "10") int l,
			@RequestParam(value = "page", defaultValue = "1") int p,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String s) {

		return "get user method was called with page " + p + " and limit in a page is " + l + " sorted in " + s;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable("userId") String id) {
		
		if(true) throw new UserServiceException("My own error message been thrown!");//for testing
		
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

	@PostMapping(consumes = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) {

		UserRest user = userService.createUser(userDetailsRequestModel);
		
		return new ResponseEntity<UserRest>(user, HttpStatus.OK);

	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_ATOM_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable("userId") String id,
			@Valid @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {

		UserRest existingUser = users.get(id);

		existingUser.setFirstName(updateUserDetailsRequestModel.getFirstName());
		existingUser.setLastName(updateUserDetailsRequestModel.getLastName());

		users.put(id, existingUser);
		return existingUser;

	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") String id) {
		users.remove(id);

		// return ResponseEntity.noContent().build();

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // or this
	}

}
