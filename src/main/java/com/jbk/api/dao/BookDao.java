package com.jbk.api.dao;

import java.util.List;

import com.jbk.api.entity.Book;

public interface BookDao {
	
	
	public boolean saveBook(Book book);

	public List<Book> getAllBook();

	public Book getBookById(int booktId);
	
	public boolean deletebook(int bookId);

	public boolean updateBook(Book book);

	public long getSumOfBook();

	public List<Book> getMaxPriseOfBook();
	
	public List<Book> getMinPriseOfBook();

	public List<Book> sortBookNameAsc();

	public List<Book> sortBookNameDsc();

	public List<Book> sortBookIdByDsc();

	public List<Book> sortBookByIdAsc();

	public long getCountOfBook();
}
