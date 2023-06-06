package com.tusofia.LibraryBase.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RentsActive")
@Getter
@Setter
public class RentActive extends Rent {
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "bookId")
	private Book book;

	public int getBookId() {
		return this.book.getId();
	}
	
}
