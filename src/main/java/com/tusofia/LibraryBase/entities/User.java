package com.tusofia.LibraryBase.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User implements EntityModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "userName")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "active")
	private boolean active;
	
	@OneToMany(targetEntity=RentActive.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="userId", referencedColumnName="id")
	private List<RentActive> rentsActive;
	
	@OneToMany(targetEntity=RentArchive.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="userId", referencedColumnName="id")
	private List<RentArchive> rentsArchive;
	
}
