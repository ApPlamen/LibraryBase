package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.dtos.inputs.BookReservedInputDTO;
import com.tusofia.LibraryBase.entities.BookReserved;
import com.tusofia.LibraryBase.infrastructure.BookReservedRepo;

@Service
public class BookReservedService {
	
	@Autowired
	private BookReservedRepo repo;
	
	
	public BookReservedService() {
	}
	
	public void create(BookReservedInputDTO entity) {
		this.repo.save(entity.toEntity());
	}
	
	public BookReserved findByIdAndUserId(int bookId, int userId) {
		return this.repo.findByIdAndUserId(bookId, userId);
	}
	
	public void deleteById(int entityId) {
		this.repo.deleteById(entityId);
	}
	
}
