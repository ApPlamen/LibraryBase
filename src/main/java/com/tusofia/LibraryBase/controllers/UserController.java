package com.tusofia.LibraryBase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusofia.LibraryBase.dtos.inputs.UserInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.UserUpdateDTO;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.entities.RentArchive;
import com.tusofia.LibraryBase.entities.User;
import com.tusofia.LibraryBase.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController extends CRUDController<User, Integer, UserInputDTO, UserUpdateDTO> {

	private final UserService service;

	@Autowired
	public UserController(UserService service) {
		super(service);
		this.service = service;
	}
	
	@GetMapping("get-rents/{entityId}")
	public List<Rent> getUserRents(@PathVariable int entityId) {
		return this.service.getUserRents(entityId);
	}
	
	@GetMapping("get-rents-active/{entityId}")
	public List<RentActive> getUserRentsActive(@PathVariable int entityId) {
		return this.service.getUserRentsActive(entityId);
	}
	
	@GetMapping("get-rents-archive/{entityId}")
	public List<RentArchive> getUserRentsArchive(@PathVariable int entityId) {
		return this.service.getUserRentsArchive(entityId);
	}

}
