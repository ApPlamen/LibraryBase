package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.RentArchive;

public class RentArchiveUpdateDTO extends UpdateDTO<RentArchive, Integer> {
	
	private Date fromDate;
	private Date toDate;
	private int userId;
	private int bookId;

	public RentArchiveUpdateDTO() {
	}

	@Override
	public RentArchive toEntity(RentArchive entity) {
		entity.setId(this.getId());
		entity.setBookId(this.getBookId());
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
