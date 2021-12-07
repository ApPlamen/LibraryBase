package com.tusofia.LibraryBase.entities;

import javax.persistence.Entity;

@Entity
public class BookReserved {
	
	private int user;
	private int book;

	public BookReserved() {
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getBook() {
		return book;
	}

	public void setBook(int book) {
		this.book = book;
	}
}
