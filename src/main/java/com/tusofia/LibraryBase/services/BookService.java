package com.tusofia.LibraryBase.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.dtos.inputs.BookInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.BookUpdateDTO;
import com.tusofia.LibraryBase.entities.Book;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.entities.RentArchive;
import com.tusofia.LibraryBase.infrastructure.BookRepo;

@Service
public class BookService extends CRUDService<Book, Integer, BookInputDTO, BookUpdateDTO> {

	private final RentActiveService rentActiveService;
	
	@Autowired
	public BookService(BookRepo repo, RentActiveService rentActiveService) {
		super(repo);
		this.rentActiveService = rentActiveService;
	}
	
	public List<Rent> getBookRents(int bookId) {
		Book book = this.repo.findById(bookId).get();
		
		Optional<RentActive> rentsActive = this.rentActiveService.getById(bookId);
		List<RentArchive> rentsArchive = book.getRentsArchive();
		List<Rent> rents = Stream
				.concat(rentsActive.stream(), rentsArchive.stream())
				.collect(Collectors.toList());
		
		return rents;
	}
	
	public Optional<RentActive> getBookRentActive(int bookId) {
		return this.rentActiveService.getById(bookId);
	}
	
	public List<RentArchive> getBookRentsArchive(int bookId) {
		Book book = this.repo.findById(bookId).get();
		
		return book.getRentsArchive();
	}

}
