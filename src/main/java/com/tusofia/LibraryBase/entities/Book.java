package com.tusofia.LibraryBase.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book implements EntityModel {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String author;
	private Date published;
	
	@OneToMany(targetEntity=RentArchive.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="bookId", referencedColumnName="id")
	private List<RentArchive> rentsArchive;

	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public List<RentArchive> getRentsArchive() {
		return rentsArchive;
	}

	public void setRentsArchive(List<RentArchive> rentsArchive) {
		this.rentsArchive = rentsArchive;
	}
	
}
