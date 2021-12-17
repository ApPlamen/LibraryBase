package com.tusofia.LibraryBase.dtos.inputs;

import java.sql.Date;

import com.tusofia.LibraryBase.entities.Rent;
import com.tusofia.LibraryBase.entities.RentArchive;

public class RentArchiveInputDTO extends InputDTO<RentArchive> {
	
	private Date fromDate;
	private Date toDate;
	private int userId;
	private int bookId;

	public RentArchiveInputDTO() {
	}

	@Override
	public RentArchive toEntity() {
		RentArchive rentArchiveEntity = new RentArchive();
		rentArchiveEntity.setBookId(this.getBookId());
		rentArchiveEntity.setUserId(this.getUserId());
		rentArchiveEntity.setFromDate(this.getFromDate());
		rentArchiveEntity.setToDate(this.getToDate());
		
		return rentArchiveEntity;
	}

	public void fromRent(Rent rent) {
		
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
