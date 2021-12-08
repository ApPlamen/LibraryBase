package com.tusofia.LibraryBase.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RentsArchive")
public class RentArchive extends Rent {
	
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;
	
	public RentArchive() {
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
