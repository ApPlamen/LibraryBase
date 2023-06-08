package com.tusofia.LibraryBase.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
@Getter
@Setter
public class Book implements EntityModel {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "author")
	private String author;
	@Column(name = "published")
	private Date published;
	
	@OneToMany(targetEntity=RentArchive.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="bookId", referencedColumnName="id")
	private List<RentArchive> rentsArchive;
	
}
