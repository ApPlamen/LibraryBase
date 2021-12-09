package com.tusofia.LibraryBase.exceptions;

public class RepoSaveException extends RuntimeException {

	protected static String message = "Entity was not saved to the database";
	
	public RepoSaveException() {
		this(message);
	}
	
	public RepoSaveException(String message) {
		super(message);
	}

}
