package com.sourceallies.controller;

import java.util.*;

import javax.ejb.*;
import javax.faces.bean.*;

import com.sourceallies.ejb.*;
import com.sourceallies.model.*;

@ManagedBean
@RequestScoped
public class BookController {
	@EJB
	private BookEjb ejb;
	private Book book;
	private List<Book> bookList;

	public Book getBook() {
		if (book == null)
			book = new Book();
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBookList() {
		if (bookList == null)
			bookList = ejb.findBooks();
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public String doNew() {
		return "newBook.xhtml";
	}

	public String doCreateBook() {
		book = ejb.createBook(book);
		bookList = ejb.findBooks();
		return "listBooks.xhtml";
	}
}
