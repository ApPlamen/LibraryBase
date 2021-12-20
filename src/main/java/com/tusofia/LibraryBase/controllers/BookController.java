package com.tusofia.LibraryBase.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusofia.LibraryBase.dtos.inputs.BookInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.BookUpdateDTO;
import com.tusofia.LibraryBase.entities.Book;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.entities.RentArchive;
import com.tusofia.LibraryBase.services.BookService;

@RestController
@RequestMapping("api/book")
public class BookController extends CRUDController<Book, Integer, BookInputDTO, BookUpdateDTO> {

	private BookService service;
	
	@Autowired
	public BookController(BookService service) {
		super(service);
		this.service = service;
	}
	
	@GetMapping("get-rents/{entityId}")
	public List<Rent> getBookRents(@PathVariable int entityId) {
		return this.service.getBookRents(entityId);
	}
	
	@GetMapping("get-rent-active/{entityId}")
	public Optional<RentActive> getBookRentsActive(@PathVariable int entityId) {
		return this.service.getBookRentActive(entityId);
	}
	
	@GetMapping("get-rents-archive/{entityId}")
	public List<RentArchive> getBookRentsArchive(@PathVariable int entityId) {
		return this.service.getBookRentsArchive(entityId);
	}

}

