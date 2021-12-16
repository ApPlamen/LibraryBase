package com.tusofia.LibraryBase.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RentsActive")
public class RentActive extends Rent {
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "bookId")
	private Book book;
	
	public RentActive() {
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getBookId() {
		return book.getId();
	}
	
}
