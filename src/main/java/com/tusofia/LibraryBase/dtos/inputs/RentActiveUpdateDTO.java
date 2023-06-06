package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentActive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentActiveUpdateDTO extends UpdateDTO<RentActive, Integer> {
	
	private Date fromDate;
	private Date toDate;
	private int userId;
	private int bookId;

	@Override
	public RentActive toEntity(RentActive entity) {
		entity.setId(this.getId());
		entity.setUserId(this.getUserId());
		entity.setFromDate(this.getFromDate());
		entity.setToDate(this.getToDate());
		
		return entity;
	}

}
