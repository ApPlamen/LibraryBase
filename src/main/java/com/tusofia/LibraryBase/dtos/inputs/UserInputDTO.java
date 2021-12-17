package com.tusofia.LibraryBase.dtos.inputs;

import com.tusofia.LibraryBase.entities.User;

public class UserInputDTO extends InputDTO<User> {
	
	private String userName;
	private String password;

	public UserInputDTO() {
	}

	@Override
	public User toEntity() {
		User userEntity = new User();
		userEntity.setUserName(this.getUserName());
		userEntity.setPassword(this.getPassword());
		userEntity.setActive(true);
		
		return userEntity;
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

}
