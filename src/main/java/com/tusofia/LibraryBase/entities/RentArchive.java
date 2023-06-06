package com.tusofia.LibraryBase.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RentsArchive")
@Getter
@Setter
public class RentArchive extends Rent {
	
	private int bookId;
	
}
