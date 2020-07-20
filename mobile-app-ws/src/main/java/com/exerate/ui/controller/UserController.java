package com.exerate.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUser(@RequestParam(value = "limit", defaultValue = "10") int l, @RequestParam(value = "page",defaultValue = "1") int p,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String s) {

		return "get user method was called with page "+p+" and limit in a page is "+l+" sorted in "+s;
	}

	@GetMapping(path = "/{userId}")
	public String getUser(@PathVariable("userId") String id) {

		return "get user method was called with id "+id;
	}

	@PostMapping
	public String createUser() {

		return "create user method was called";
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
