package com.tusofia.LibraryBase.infrastructure;

import org.springframework.stereotype.Repository;

import com.tusofia.LibraryBase.entities.BookReserved;

@Repository
public interface BookReservedRepo extends Repo<BookReserved, Integer> {

	BookReserved findByBookIdAndUserId(int bookId, int userId);
	
}
