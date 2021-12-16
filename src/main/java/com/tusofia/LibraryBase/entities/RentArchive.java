package com.tusofia.LibraryBase.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RentsArchive")
public class RentArchive extends Rent {
	
	private int bookId;
	
	public RentArchive() {
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
}
