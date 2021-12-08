package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.entities.Book;
import com.tusofia.LibraryBase.infrastructure.BookRepo;

@Service
public class BookService extends CRUDService<Book, Integer> {
	
	@Autowired
	public BookService(BookRepo repo) {
		super(repo);
	}

}
