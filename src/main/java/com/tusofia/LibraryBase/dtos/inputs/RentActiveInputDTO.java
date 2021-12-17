package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentActive;

public class RentActiveInputDTO extends InputDTO<RentActive> {
	
	private Date fromDate;
	private Date toDate;
	private int userId;
	private int bookId;

	public RentActiveInputDTO() {
	}

	@Override
	public RentActive toEntity() {
		RentActive rentActiveEntity = new RentActive();
		rentActiveEntity.setUserId(this.getUserId());
		rentActiveEntity.setFromDate(this.getFromDate());
		rentActiveEntity.setToDate(this.getToDate());
		
		return rentActiveEntity;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
