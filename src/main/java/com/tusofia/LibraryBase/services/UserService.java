package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.entities.User;
import com.tusofia.LibraryBase.infrastructure.UserRepo;

@Service
public class UserService extends CRUDService<User, Integer> {

	@Autowired
	public UserService(UserRepo repo) {
		super(repo);
	}

}
