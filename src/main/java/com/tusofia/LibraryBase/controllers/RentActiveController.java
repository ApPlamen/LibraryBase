package com.tusofia.LibraryBase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusofia.LibraryBase.dtos.inputs.RentActiveInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentActiveRentDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentActiveUpdateDTO;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.services.RentActiveService;

@RestController
@RequestMapping("api/rent-active")
public class RentActiveController extends CRUDController<RentActive, Integer, RentActiveInputDTO, RentActiveUpdateDTO> {

	private RentActiveService service;
	
	@Autowired
	public RentActiveController(RentActiveService service) {
		super(service);
		this.service = service;
	}
	
	@PostMapping("rent-book")
	public void returnBook(@RequestBody RentActiveRentDTO dto) {
		this.service.rentBook(dto);
	}
	
	@PostMapping("return-book/{entityId}")
	public void returnBook(@PathVariable Integer entityId) {
		this.service.returnBook(entityId);
	}

}
