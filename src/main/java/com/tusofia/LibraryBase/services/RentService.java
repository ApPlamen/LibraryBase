package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tusofia.LibraryBase.entities.BookReserved;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.entities.RentArchive;
import com.tusofia.LibraryBase.exceptions.RepoSaveException;

public class RentService extends CRUDSrevice<RentActive, Integer> {
	
	@Autowired
	private RentArchiveService rentArchiveService;
	@Autowired
	private BookReservedService bookReservedService;

	public RentService() {
	}
	
	@Override
	public RentActive save(RentActive entity) throws RepoSaveException {
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
		
		try {
			this.rentArchiveService.save((RentArchive) rent);
			this.repo.deleteById(id);
		} catch (RepoSaveException e) {
			e.printStackTrace();
		}
	}

}
