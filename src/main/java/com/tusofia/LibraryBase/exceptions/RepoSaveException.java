package com.tusofia.LibraryBase.exceptions;

public class RepoSaveException extends Exception {

	protected static String message = "Entity was not saved to the database";
	
	public RepoSaveException() {
		this(message);
	}
	
	public RepoSaveException(String message) {
		super(message);
	}

}
