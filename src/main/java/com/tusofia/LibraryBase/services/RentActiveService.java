package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			bookReserved = this.bookReservedService.findByBookIdAndUserId(entity.getBook().getId(), entity.getUser().getId());
		}
		
		if(bookReserved.getId() == 0) {
			throw new RepoSaveException("This book is booked by another user");
		}
		
		return this.repoSaveTransactional(entity, bookReserved);
	}
	
	@Transactional
	private RentActive repoSaveTransactional(RentActive entity, BookReserved bookReserved) {
		entity = this.repo.save(entity);
		this.bookReservedService.delete(bookReserved);
		return entity;
	}
	
	public void returnBook(Integer id) {
		Rent rent = this.repo.getById(id);
		
		this.repoReturnBookTransactional(id, (RentArchive) rent);
	}

	@Transactional
	private void repoReturnBookTransactional(Integer bookId, RentArchive rentArchive) {
		this.rentArchiveService.save(rentArchive);
		this.repo.deleteById(bookId);
	}
	
}
