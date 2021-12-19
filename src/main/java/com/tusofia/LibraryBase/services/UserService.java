package com.tusofia.LibraryBase.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.dtos.inputs.UserInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.UserUpdateDTO;
import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.entities.RentArchive;
import com.tusofia.LibraryBase.entities.User;
import com.tusofia.LibraryBase.infrastructure.UserRepo;

@Service
public class UserService extends CRUDService<User, Integer, UserInputDTO, UserUpdateDTO> {

	@Autowired
	public UserService(UserRepo repo) {
		super(repo);
	}
	
	public List<Rent> getUserRents(int userId) {
		User user = this.repo.findById(userId).get();
		
		List<RentActive> rentsActive = user.getRentsActive();
		List<RentArchive> rentsArchive = user.getRentsArchive();
		List<Rent> rents = Stream
				.concat(rentsActive.stream(), rentsArchive.stream())
				.collect(Collectors.toList());
		
		return rents;
	}
	
	public List<RentActive> getUserRentsActive(int userId) {
		User user = this.repo.findById(userId).get();
		
		return user.getRentsActive();
	}
	
	public List<RentArchive> getUserRentsArchive(int userId) {
		User user = this.repo.findById(userId).get();
		
		return user.getRentsArchive();
	}

}
