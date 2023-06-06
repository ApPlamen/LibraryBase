package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentActive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentActiveInputDTO extends InputDTO<RentActive> {
	
	private Date fromDate;
	private Date toDate;
	private int userId;
	private int bookId;

	@Override
	public RentActive toEntity() {
		RentActive rentActiveEntity = new RentActive();
		rentActiveEntity.setUserId(this.getUserId());
		rentActiveEntity.setFromDate(this.getFromDate());
		rentActiveEntity.setToDate(this.getToDate());
		
		return rentActiveEntity;
	}

}
