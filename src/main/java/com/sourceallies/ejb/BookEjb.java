package com.sourceallies.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sourceallies.model.Book;

@Stateless
public class BookEjb {
	@PersistenceContext(unitName = "book")
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Book> findBooks() {
		return manager.createNamedQuery(Book.FindAllBooks).getResultList();
	}

	public Book createBook(Book book) {
		manager.persist(book);
		return book;
	}
}
