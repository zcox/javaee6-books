package com.sourceallies.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.sourceallies.ejb.BookEjb;
import com.sourceallies.model.Book;

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
