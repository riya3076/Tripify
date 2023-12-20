package com.group9.group09.repository.interfaces;

import com.group9.group09.model.User;

import java.util.Optional;

public interface UserRepository {

	int saveUserInfo(User user);
	
	int updateUserPassword(User user,String newpassword);
	
	int updateUserEmail(User user);

    int updateUserName(User user);

	int updateUserPhone(User user);

	int updateUserInterests(User user);

	int updateUserCountry(User user);

	Optional<User> findByUserId(String userId);
	
	int deleteByUserId(String userId);

	Optional<User> findByUsermail(String email);

	User getUserbyemail(String email);
}
