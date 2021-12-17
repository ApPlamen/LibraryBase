package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.dtos.inputs.UserInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.UserUpdateDTO;
import com.tusofia.LibraryBase.entities.User;
import com.tusofia.LibraryBase.infrastructure.UserRepo;

@Service
public class UserService extends CRUDService<User, Integer, UserInputDTO, UserUpdateDTO> {

	@Autowired
	public UserService(UserRepo repo) {
		super(repo);
	}

}
