package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.Book;

public class BookInputDTO extends InputDTO<Book> {
	
	private String name;
	private String author;
	private Date published;

	public BookInputDTO() {
	}

	@Override
	public Book toEntity() {
		Book bookEntity = new Book();
		bookEntity.setName(this.getName());
		bookEntity.setAuthor(this.getAuthor());
		bookEntity.setPublished(this.getPublished());
		
		return bookEntity;
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

}
