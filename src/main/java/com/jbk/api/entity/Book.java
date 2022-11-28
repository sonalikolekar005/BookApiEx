package com.jbk.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
	@Id
	@Min(1)
	private int bookId;
	
	@NotNull(message = "Book name is required")
    private String bookName;
	
	@NotNull(message = "Book  Author name is required")
	private String bookAuthor;
	
	@NotNull(message = "Book Publisher name is required")
	private String bookPublisher;
	
	@Min(1)
	private int bookPrise;
	
	@Min(1)
	private int bookPublishYear;
	
	@NotNull(message = "Book ISBNO is required")
	private String isbnNo;

	public Book() {
		super();
	}

	public Book(int bookId, String bookName, String bookAuthor, String bookPublisher, int bookPrise,
			int bookPublishYear, String isbnNo) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPrise = bookPrise;
		this.bookPublishYear = bookPublishYear;
		this.isbnNo = isbnNo;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPublisher="
				+ bookPublisher + ", bookPrise=" + bookPrise + ", bookPublishYear=" + bookPublishYear + ", isbnNo="
				+ isbnNo + "]";
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public int getBookPrise() {
		return bookPrise;
	}

	public void setBookPrise(int bookPrise) {
		this.bookPrise = bookPrise;
	}

	public int getBookPublishYear() {
		return bookPublishYear;
	}

	public void setBookPublishYear(int bookPublishYear) {
		this.bookPublishYear = bookPublishYear;
	}

	public String getIsbnNo() {
		return isbnNo;
	}

	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}

	
}
