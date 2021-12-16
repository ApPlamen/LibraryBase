package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.dtos.inputs.InputDTO;
import com.tusofia.LibraryBase.entities.BookReserved;
import com.tusofia.LibraryBase.infrastructure.BookReservedRepo;

@Service
public class BookReservedService extends CRUDService<BookReserved, Integer> {
	
	private BookReservedRepo repo;
	
	@Autowired
	public BookReservedService(BookReservedRepo repo) {
		super(repo);
		this.repo = repo;
	}
	
	@Override
	public synchronized BookReserved save(InputDTO<BookReserved, Integer> entity) {
		return this.repo.save(entity.toEntity());
	}
	
	public BookReserved findByBookIdAndUserId(int bookId, int userId) {
		return this.repo.findByBookIdAndUserId(bookId, userId);
	}
}
