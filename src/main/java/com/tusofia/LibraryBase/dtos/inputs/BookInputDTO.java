package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInputDTO extends InputDTO<Book> {

	private String name;
	private String author;
	private Date published;

	@Override
	public Book toEntity() {
		Book bookEntity = new Book();
		bookEntity.setName(this.getName());
		bookEntity.setAuthor(this.getAuthor());
		bookEntity.setPublished(this.getPublished());
		
		return bookEntity;
	}
}
