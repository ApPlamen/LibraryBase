package com.tusofia.LibraryBase.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class Rent implements EntityModel {
	
	@Id
	@GeneratedValue
	private int id;
	private Date fromDate;
	private Date toDate;
	private int userId;

}
