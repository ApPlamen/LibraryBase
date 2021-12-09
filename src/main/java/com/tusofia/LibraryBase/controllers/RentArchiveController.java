package com.tusofia.LibraryBase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusofia.LibraryBase.entities.RentArchive;
import com.tusofia.LibraryBase.services.RentArchiveService;

@RestController
@RequestMapping("api/rent-archive")
public class RentArchiveController extends CRUDController<RentArchive, Integer> {

	@Autowired
	public RentArchiveController(RentArchiveService service) {
		super(service);
	}

}
