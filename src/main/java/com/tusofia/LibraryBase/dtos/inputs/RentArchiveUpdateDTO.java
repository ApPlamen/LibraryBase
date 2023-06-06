package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentArchive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentArchiveUpdateDTO extends UpdateDTO<RentArchive, Integer> {
	
	private Date fromDate;
	private Date toDate;
	private int userId;
	private int bookId;

	@Override
	public RentArchive toEntity(RentArchive entity) {
		entity.setId(this.getId());
		entity.setBookId(this.getBookId());
		entity.setUserId(this.getUserId());
		entity.setFromDate(this.getFromDate());
		entity.setToDate(this.getToDate());
		
		return entity;
	}

}
