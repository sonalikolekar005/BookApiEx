package com.jbk.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.api.dao.BookDao;
import com.jbk.api.entity.Book;

@Service
public class BookServiceImp1 implements BookService {

	@Autowired
	private BookDao dao;

	@Override
	public boolean saveBook(Book book) {
		boolean isAdded = dao.saveBook(book);
		return isAdded;
	}

	@Override
	public List<Book> getAllBook() {
		
		return dao.getAllBook();
	}

	@Override
	public Book getBookById(int booktId) {
		
		return dao.getBookById(booktId);
	}

	@Override
	public boolean deletebook(int bookId) {
		
		return dao.deletebook(bookId);
	}

	@Override
	public boolean updateBook(Book book) {
		
		return dao.updateBook(book);
	}

	@Override
	public long getSumOfBook() {
		
		return dao.getSumOfBook();
	}

	@Override
	public List<Book> getMaxPriseOfBook() {
		
		return dao.getMaxPriseOfBook();
	}



	@Override
	public long getCountOfBook() {
		return dao.getCountOfBook();
		
		
	}



	@Override
	public List<Book> sortBookIdByDsc() {
		
		return dao.sortBookIdByDsc();
	}

	@Override
	public List<Book> getMinPriseOfBook() {
		
		return dao.getMinPriseOfBook();
	}

	@Override
	public List<Book> sortBookByIdAsc() {
		
		return dao.sortBookByIdAsc();
	}

	@Override
	public List<Book> sortBookNameAsc() {
		
		return dao.sortBookNameAsc();
	}

	@Override
	public List<Book> sortBookNameDsc() {
		
		return dao.sortBookNameDsc();
	}



}
