package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.entities.BookReserved;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.entities.RentArchive;
import com.tusofia.LibraryBase.exceptions.RepoSaveException;
import com.tusofia.LibraryBase.infrastructure.RentActiveRepo;

@Service
public class RentActiveService extends CRUDService<RentActive, Integer> {
	
	@Autowired
	private RentArchiveService rentArchiveService;
	@Autowired
	private BookReservedService bookReservedService;

	@Autowired
	public RentActiveService(RentActiveRepo repo) {
		super(repo);
	}
	
	@Override
	public RentActive save(RentActive entity) {
		if(entity.getId() != 0) {
			return this.repo.save(entity);
		}
		
		BookReserved bookReserved = new BookReserved();
		bookReserved.setBook(entity.getBook());
		bookReserved.setUser(entity.getUser());
		bookReserved = this.bookReservedService.save(bookReserved);
		
		if(bookReserved.getId() == 0) {
			throw new RepoSaveException("This book is booked by another user");
		}
		
		entity = this.repo.save(entity);
		this.bookReservedService.delete(bookReserved);
		return entity;
	}
	
	@Override
	public void deleteById(Integer id) {
		Rent rent = this.repo.getById(id);
		
		this.rentArchiveService.save((RentArchive) rent);
		this.repo.deleteById(id);
	}

}
