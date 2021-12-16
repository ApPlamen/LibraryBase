package com.tusofia.LibraryBase.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements EntityModel {
	
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String password;
	private boolean active;
	
	@OneToMany(targetEntity=BookReserved.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="userId", referencedColumnName="id")
	private List<BookReserved> booksReserved;
	
	@OneToMany(targetEntity=RentActive.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="userId", referencedColumnName="id")
	private List<RentActive> rentsActive;
	
	@OneToMany(targetEntity=RentArchive.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="userId", referencedColumnName="id")
	private List<RentArchive> rentsArchive;
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<BookReserved> getBooksReserved() {
		return booksReserved;
	}

	public void setBooksReserved(List<BookReserved> booksReserved) {
		this.booksReserved = booksReserved;
	}

	public List<RentActive> getRentsActive() {
		return rentsActive;
	}

	public void setRentsActive(List<RentActive> rentsActive) {
		this.rentsActive = rentsActive;
	}

	public List<RentArchive> getRentsArchive() {
		return rentsArchive;
	}

	public void setRentsArchive(List<RentArchive> rentsArchive) {
		this.rentsArchive = rentsArchive;
	}
	
}
