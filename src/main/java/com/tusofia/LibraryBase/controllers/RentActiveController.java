package com.tusofia.LibraryBase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.services.RentActiveService;

@RestController
@RequestMapping("api/rent-active")
public class RentActiveController extends CRUDController<RentActive, Integer> {

	@Autowired
	public RentActiveController(RentActiveService service) {
		super(service);
	}

}
