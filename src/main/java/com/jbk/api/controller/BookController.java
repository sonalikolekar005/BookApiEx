package com.jbk.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.api.entity.Book;

import com.jbk.api.exception.BookAlreadyExistException;
import com.jbk.api.exception.BookListIsEmpty;
import com.jbk.api.exception.BookNotFoundException;
import com.jbk.api.service.BookService;


@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookservice;
	

	@PostMapping(value = "/savebook")
	public ResponseEntity<Boolean> saveBook(@Valid @RequestBody Book book) {
		boolean isAdded = bookservice.saveBook(book);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {

			throw new BookAlreadyExistException("Book Already Exist Id=" + book.getBookId());
		}

	}
	

	@GetMapping(value = "/getallbook")
	public ResponseEntity<List<Book>> getAlBook() {
		List<Book> booklist = bookservice.getAllBook();
		if (!booklist.isEmpty()) {
			return new ResponseEntity<List<Book>>(booklist, HttpStatus.OK);
		} else {

			throw new BookListIsEmpty("BooK List is Empty :");
		}

	}

	@GetMapping(value = "/getbookbyid/{bookid}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookid) {
		Book book = bookservice.getBookById(bookid);
		if (book != null) {
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		} else {

			throw new BookNotFoundException("For this Id Book Not Found");
		}
	}

	@DeleteMapping(value = "/deletebookbyid")
	public ResponseEntity<Boolean> deleteBook(@RequestParam int bookid) {
		boolean isdeleted = bookservice.deletebook(bookid);
		if (isdeleted) {
			return new ResponseEntity<Boolean>(isdeleted, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("For this Id Book Not Found");
		}
	}

	@PutMapping(value = "/updatebookbyid")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Book book) {
		boolean isUpdate = bookservice.updateBook(book);
		if (isUpdate) {
			return new ResponseEntity<Boolean>(isUpdate, HttpStatus.OK);
		} else {
			throw new BookNotFoundException("For this Id Book Not Found");
		}
	}

	@GetMapping(value = "/getsumofbook")
	public ResponseEntity<Long> getSumOfBook() {
		long isSum = bookservice.getSumOfBook();

		return new ResponseEntity<Long>(isSum, HttpStatus.OK);
	}

	@GetMapping(value = "/getmaxprisebook")
	public ResponseEntity<List<Book>> getMaxPriseBook() {
		List<Book> booklist = bookservice.getMaxPriseOfBook();
		
			return new ResponseEntity<List<Book>>(booklist, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getminprisebook")
	public ResponseEntity<List<Book>> getMinPriseBook() {
		List<Book> booklist = bookservice.getMinPriseOfBook();
		
			return new ResponseEntity<List<Book>>(booklist, HttpStatus.OK);

	}
	
	@GetMapping(value="/getBookidbyasc")
	public ResponseEntity<List<Book>> getBookIdAsc() {
		List<Book> list=bookservice.sortBookByIdAsc();
		if(!list.isEmpty())
		{
			return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
		} else {
			throw new BookListIsEmpty("BooK List is Empty:");
		}
		
	}

	@GetMapping(value = "/sortbookidbydsc")
	public ResponseEntity<List<Book>> getBookIdDsc() {
		List<Book> booklist = bookservice.sortBookIdByDsc();
		if (!booklist.isEmpty()) {
			return new ResponseEntity<List<Book>>(booklist, HttpStatus.OK);
		} else {
			throw new BookListIsEmpty("BooK List is Empty:");
		}

	}

	@GetMapping(value="/getbooknamebyasc")
	public ResponseEntity<List<Book>> getBookNameAsc()
	{
		List<Book> list =bookservice.sortBookNameAsc();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
		} else {
			throw new BookListIsEmpty("BooK List is Empty:");
		}
	}
	
	@GetMapping(value="/getbooknamebydesc")
	public ResponseEntity<List<Book>> getBookNameBydesc()
	{
		List< Book> list=bookservice.sortBookNameDsc();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
		} else {
			throw new BookListIsEmpty("BooK List is Empty:");
		}
		
	}
	
	@GetMapping(value = "/getcountofbook")
	public ResponseEntity<Long> getCountOfBook() {
		long bookCount = bookservice.getCountOfBook();

		return new ResponseEntity<Long>(bookCount, HttpStatus.OK);
	}
}
