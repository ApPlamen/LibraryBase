package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tusofia.LibraryBase.dtos.inputs.BookReservedInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.InputDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentActiveInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentArchiveInputDTO;
import com.tusofia.LibraryBase.entities.BookReserved;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
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
	public RentActive save(InputDTO<RentActive, Integer> entity) {
		if(entity.getId() != 0) {
			return this.repo.save(entity.toEntity());
		}
		
		BookReservedInputDTO bookReserved = new BookReservedInputDTO();
//		bookReserved.setBookId(entity.getBookId());
//		bookReserved.setUserId(entity.getUserId());
		BookReserved bookReservedEntity = this.bookReservedService.save(bookReserved);
		
		if(bookReservedEntity.getBookId() == 0) {
//			bookReservedEntity = this.bookReservedService.findByBookIdAndUserId(bookReserved.getBookId(), bookReserved.getUserId());
		}
		
		if(bookReservedEntity.getBookId() == 0) {
			throw new RepoSaveException("This book is booked by another user");
		}
		
		return this.repoSaveTransactional((RentActiveInputDTO)entity, bookReserved);
	}
	
	@Transactional
	private RentActive repoSaveTransactional(RentActiveInputDTO entity, BookReservedInputDTO bookReserved) {
		RentActive rentActiveEntity = this.repo.save(entity.toEntity());
		this.bookReservedService.delete(bookReserved);
		return rentActiveEntity;
	}
	
	public void returnBook(Integer id) {
		Rent rent = this.repo.getById(id);
		RentArchiveInputDTO rentArchive = new RentArchiveInputDTO();
		rentArchive.fromRent(rent);
		
		this.repoReturnBookTransactional(id, rentArchive);
	}

	@Transactional
	private void repoReturnBookTransactional(Integer bookId, RentArchiveInputDTO rentArchive) {
		this.rentArchiveService.save(rentArchive);
		this.repo.deleteById(bookId);
	}
	
}
