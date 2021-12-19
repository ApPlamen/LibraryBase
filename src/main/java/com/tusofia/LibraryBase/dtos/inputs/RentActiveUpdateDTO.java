package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentActive;

public class RentActiveUpdateDTO extends UpdateDTO<RentActive, Integer> {
	
	private Date fromDate;
	private Date toDate;
	private int userId;
	private int bookId;

	public RentActiveUpdateDTO() {
	}

	@Override
	public RentActive toEntity(RentActive entity) {
		entity.setId(this.getId());
		entity.setUserId(this.getUserId());
		entity.setFromDate(this.getFromDate());
		entity.setToDate(this.getToDate());
		
		return entity;
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
