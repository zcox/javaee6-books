package com.sourceallies.ejb;

import java.util.*;

import javax.ejb.*;
import javax.persistence.*;

import com.sourceallies.model.*;

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
