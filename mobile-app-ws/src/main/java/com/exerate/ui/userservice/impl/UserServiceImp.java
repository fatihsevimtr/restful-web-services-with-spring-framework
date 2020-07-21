package com.exerate.ui.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exerate.ui.model.request.UserDetailsRequestModel;
import com.exerate.ui.model.response.UserRest;
import com.exerate.ui.shared.Utility;
import com.exerate.ui.userservice.UserService;

@Service
public class UserServiceImp implements UserService {
	Map<String, UserRest> users;
	
	Utility util;
	
	public UserServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Autowired
	public UserServiceImp(Utility util) {
		this.util = util;
	}




	@Override
	public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {

		UserRest user = new UserRest();
		user.setFirstName(userDetailsRequestModel.getFirstName());
		user.setLastName(userDetailsRequestModel.getLastName());
		user.setEmail(userDetailsRequestModel.getEmail());

		String userId = util.generateId();
		user.setUserId(userId);
		if (users == null)
			users = new HashMap<String, UserRest>();
		users.put(userId, user);

		return user;
	}

}
