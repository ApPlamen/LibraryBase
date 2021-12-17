package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tusofia.LibraryBase.dtos.inputs.BookReservedInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentActiveInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentActiveUpdateDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentArchiveInputDTO;
import com.tusofia.LibraryBase.entities.Book;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.infrastructure.BookRepo;
import com.tusofia.LibraryBase.infrastructure.RentActiveRepo;

@Service
public class RentActiveService extends CRUDService<RentActive, Integer, RentActiveInputDTO, RentActiveUpdateDTO> {
	
	@Autowired
	private RentArchiveService rentArchiveService;
	@Autowired
	private BookReservedService bookReservedService;
	
	@Autowired
	private BookRepo bookRepo;

	@Autowired
	public RentActiveService(RentActiveRepo repo) {
		super(repo);
	}
	
	@Override
	public RentActive create(RentActiveInputDTO dto) {
		BookReservedInputDTO bookReserved = new BookReservedInputDTO();
		bookReserved.setBookId(dto.getBookId());
		bookReserved.setUserId(dto.getUserId());
		this.bookReservedService.create(bookReserved);
		
//		if(bookReservedEntity.getId() == 0) {
//			bookReservedEntity = this.bookReservedService.findByBookIdAndUserId(bookReserved.getBookId(), bookReserved.getUserId());
//		}
//		
//		if(bookReservedEntity.getId() == 0) {
//			throw new RepoSaveException("This book is booked by another user");
//		}
		
		RentActive entity = dto.toEntity();
		Book book = this.bookRepo.findById(dto.getBookId()).get();
		entity.setBook(book);
		
		return this.repoSaveTransactional(entity, bookReserved.getBookId());
	}
	
	@Transactional
	private RentActive repoSaveTransactional(RentActive entity, int bookReservedId) {
		RentActive rentActiveEntity = this.repo.save(entity);
		this.bookReservedService.deleteById(bookReservedId);
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
		this.rentArchiveService.create(rentArchive);
		this.repo.deleteById(bookId);
	}
	
}
