package com.jbk.api.service;

import java.util.List;

import com.jbk.api.entity.Book;

public interface BookService {

	public boolean saveBook(Book book);

	public List<Book> getAllBook();

	public Book getBookById(int booktId);

	public boolean deletebook(int bookId);

	public boolean updateBook(Book book);

	public long getSumOfBook();

	public List<Book> getMaxPriseOfBook();

	public List<Book> getMinPriseOfBook();

	public List<Book> sortBookByIdAsc();

	public List<Book> sortBookIdByDsc();

	public List<Book> sortBookNameAsc();

	public List<Book> sortBookNameDsc();

	public long getCountOfBook();

}
