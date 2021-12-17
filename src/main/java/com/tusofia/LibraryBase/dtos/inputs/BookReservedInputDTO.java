package com.tusofia.LibraryBase.dtos.inputs;

import com.tusofia.LibraryBase.entities.BookReserved;

public class BookReservedInputDTO extends InputDTO<BookReserved> {
	
	private int bookId;
	private int userId;

	public BookReservedInputDTO() {
	}

	@Override
	public BookReserved toEntity() {
		BookReserved bookReservedEntity = new BookReserved();
		bookReservedEntity.setUserId(this.getUserId());
		
		return bookReservedEntity;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
