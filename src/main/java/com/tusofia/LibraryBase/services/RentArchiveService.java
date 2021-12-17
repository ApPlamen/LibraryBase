package com.tusofia.LibraryBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusofia.LibraryBase.dtos.inputs.RentArchiveInputDTO;
import com.tusofia.LibraryBase.dtos.inputs.RentArchiveUpdateDTO;
import com.tusofia.LibraryBase.entities.RentArchive;
import com.tusofia.LibraryBase.infrastructure.RentArchiveRepo;

@Service
public class RentArchiveService extends CRUDService<RentArchive, Integer, RentArchiveInputDTO, RentArchiveUpdateDTO> {
	
	@Autowired
	public RentArchiveService(RentArchiveRepo repo) {
		super(repo);
	}

}
