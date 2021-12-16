package com.tusofia.LibraryBase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusofia.LibraryBase.dtos.inputs.UserInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.UserUpdateDTO;
import com.tusofia.LibraryBase.entities.User;
import com.tusofia.LibraryBase.services.UserService;

@RestController
@RequestMapping("api/user")
public class UserController extends CRUDController<User, Integer, UserInputDTO, UserUpdateDTO> {

	@Autowired
	public UserController(UserService service) {
		super(service);
	}

}
