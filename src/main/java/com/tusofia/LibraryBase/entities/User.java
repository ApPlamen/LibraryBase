package com.tusofia.LibraryBase.entities;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class User implements EntityModel {
	
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String password;
	private boolean active;
	
	@OneToMany(targetEntity=RentActive.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="userId", referencedColumnName="id")
	private List<RentActive> rentsActive;
	
	@OneToMany(targetEntity=RentArchive.class, orphanRemoval=true, cascade=CascadeType.ALL)
	@JoinColumn(name="userId", referencedColumnName="id")
	private List<RentArchive> rentsArchive;
	
}
