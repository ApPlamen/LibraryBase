package com.tusofia.LibraryBase.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookReservations")
public class BookReserved {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name = "bookId", referencedColumnName = "id")
	private Book book;
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;

	public BookReserved() {
	}
	
	public Book getBook() {
		return book;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
