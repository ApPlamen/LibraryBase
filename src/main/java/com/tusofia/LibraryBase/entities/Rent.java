package com.tusofia.LibraryBase.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rents")
public class Rent {
	
	@Id
	@GeneratedValue
	private int id;
	private Date fromDate;
	private Date toDate;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "bookId", referencedColumnName = "id")
	private Book book;

	public Rent() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
