package com.exerate.ui.userservice;

import com.exerate.ui.model.request.UserDetailsRequestModel;
import com.exerate.ui.model.response.UserRest;

public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);
}
