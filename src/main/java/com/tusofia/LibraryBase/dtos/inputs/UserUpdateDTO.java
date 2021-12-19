package com.tusofia.LibraryBase.dtos.inputs;

import com.tusofia.LibraryBase.entities.User;

public class UserUpdateDTO extends UpdateDTO<User, Integer> {
	
	private String userName;
	private String password;
	private boolean active;

	public UserUpdateDTO() {
	}

	@Override
	public User toEntity(User entity) {
		entity.setId(this.getId());
		entity.setUserName(this.getUserName());
		entity.setPassword(this.getPassword());
		entity.setActive(this.isActive());
		
		return entity;
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

}
