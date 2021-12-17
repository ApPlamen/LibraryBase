package com.tusofia.LibraryBase.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookReservations")
public class BookReserved implements EntityModel {

	@Id
	private int id;
	private int userId;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "bookId")
	private Book book;

	public BookReserved() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getBookId() {
		return this.book.getId();
	}

}
