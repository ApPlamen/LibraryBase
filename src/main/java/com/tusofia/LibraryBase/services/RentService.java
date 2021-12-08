package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tusofia.LibraryBase.entities.BookReserved;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.entities.RentArchive;

public class RentService extends CRUDSrevice<RentActive, Integer> {
	
	@Autowired
	private RentArchiveService rentArchiveService;
	@Autowired
	private BookReservedService bookReservedService;

	public RentService() {
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
			return null;
			//throw new Exception();
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
