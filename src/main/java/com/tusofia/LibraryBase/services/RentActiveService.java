package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tusofia.LibraryBase.dtos.inputs.RentActiveInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentActiveUpdateDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentArchiveInputDTO;
import com.tusofia.LibraryBase.entities.Book;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.infrastructure.BookRepo;
import com.tusofia.LibraryBase.infrastructure.RentActiveRepo;

@Service
public class RentActiveService extends CRUDService<RentActive, Integer, RentActiveInputDTO, RentActiveUpdateDTO> {
	
	@Autowired
	private RentArchiveService rentArchiveService;
	
	@Autowired
	private BookRepo bookRepo;

	@Autowired
	public RentActiveService(RentActiveRepo repo) {
		super(repo);
	}
	
	@Override
	public RentActive create(RentActiveInputDTO dto) {
		RentActive entity = dto.toEntity();
		Book book = this.bookRepo.findById(dto.getBookId()).get();
		entity.setBook(book);
		
		return this.repo.save(entity);
	}
	
	public void returnBook(Integer id) {
		RentActive rent = this.repo.findById(id).get();
		RentArchiveInputDTO rentArchiveDTO = RentArchiveInputDTO.fromRentActive(rent);
		
		this.repoReturnBookTransactional(id, rentArchiveDTO);
	}

	@Transactional
	private void repoReturnBookTransactional(Integer bookId, RentArchiveInputDTO rentArchiveDTO) {
		this.rentArchiveService.create(rentArchiveDTO);
		this.repo.deleteById(bookId);
	}
	
}
