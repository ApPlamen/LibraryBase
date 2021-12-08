package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.entities.BookReserved;
import com.tusofia.LibraryBase.infrastructure.BookReservedRepo;

@Service
public class BookReservedService extends CRUDService<BookReserved, Integer> {
	
	@Autowired
	public BookReservedService(BookReservedRepo repo) {
		super(repo);
	}
	
	@Override
	public synchronized BookReserved save(BookReserved entity) {
		return this.repo.save(entity);
	}
}
