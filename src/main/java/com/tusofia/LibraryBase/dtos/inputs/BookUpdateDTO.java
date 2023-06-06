package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDTO extends UpdateDTO<Book, Integer> {
	
	private String name;
	private String author;
	private Date published;

	@Override
	public Book toEntity(Book entity) {
		entity.setId(this.getId());
		entity.setName(this.getName());
		entity.setAuthor(this.getAuthor());
		entity.setPublished(this.getPublished());
		
		return entity;
	}

}
