package com.tusofia.LibraryBase.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class Rent implements EntityModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "fromDate")
	private Date fromDate;
	@Column(name = "toDate")
	private Date toDate;
	@Column(name = "userId")
	private int userId;

}
