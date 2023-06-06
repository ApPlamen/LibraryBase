package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentActive;
import com.tusofia.LibraryBase.entities.RentArchive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentArchiveInputDTO extends InputDTO<RentArchive> {
	
	private Date fromDate;
	private Date toDate;
	private int userId;
	private int bookId;

	@Override
	public RentArchive toEntity() {
		RentArchive rentArchiveEntity = new RentArchive();
		rentArchiveEntity.setBookId(this.getBookId());
		rentArchiveEntity.setUserId(this.getUserId());
		rentArchiveEntity.setFromDate(this.getFromDate());
		rentArchiveEntity.setToDate(this.getToDate());
		
		return rentArchiveEntity;
	}

	public static RentArchiveInputDTO fromRentActive(RentActive rent) {
		RentArchiveInputDTO rentArchiveInputDTO = new RentArchiveInputDTO();
		rentArchiveInputDTO.setUserId(rent.getUserId());
		rentArchiveInputDTO.setBookId(rent.getBookId());
		rentArchiveInputDTO.setFromDate(rent.getFromDate());
		rentArchiveInputDTO.setToDate(rent.getToDate());
		
		return rentArchiveInputDTO;
	}
	
}
