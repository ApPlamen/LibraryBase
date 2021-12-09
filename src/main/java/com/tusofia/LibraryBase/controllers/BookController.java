package com.tusofia.LibraryBase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tusofia.LibraryBase.entities.Book;
import com.tusofia.LibraryBase.services.BookService;

@RestController
@RequestMapping("api/book")
public class BookController extends CRUDController<Book, Integer> {

	@Autowired
	public BookController(BookService service) {
		super(service);
	}

}

