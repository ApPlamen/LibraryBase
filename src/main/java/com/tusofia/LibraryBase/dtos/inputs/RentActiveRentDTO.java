package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentActive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentActiveRentDTO extends InputDTO<RentActive> {

	private int userId;
	private int bookId;

	@Override
	public RentActive toEntity() {
		long millis = System.currentTimeMillis();
		Date dateForm = new Date(millis);
		Date dateTo = new Date(millis);
		
		RentActive rentActiveEntity = new RentActive();
		rentActiveEntity.setUserId(this.getUserId());
		rentActiveEntity.setFromDate(dateForm);
		
		dateTo.setMonth(dateTo.getMonth() + 1);
		rentActiveEntity.setToDate(dateTo);
		
		return rentActiveEntity;
	}

}
