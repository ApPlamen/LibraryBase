package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentActive;

public class RentActiveRentDTO extends InputDTO<RentActive> {

	private int userId;
	private int bookId;

	public RentActiveRentDTO() {
	}

	@SuppressWarnings("deprecation")
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
