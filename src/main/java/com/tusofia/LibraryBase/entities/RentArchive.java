package com.tusofia.LibraryBase.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RentsArchive")
public class RentArchive extends Rent {
	
	public RentArchive() {
	}
}
