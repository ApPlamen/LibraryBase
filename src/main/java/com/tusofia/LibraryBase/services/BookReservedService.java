package com.tusofia.LibraryBase.services;

import com.tusofia.LibraryBase.entities.BookReserved;

public class BookReservedService extends CRUDSrevice<BookReserved, Integer> {

	public BookReservedService() {
	}
	
	@Override
	public synchronized BookReserved save(BookReserved entity) {
		return this.repo.save(entity);
	}
}
