package org.bks.service;

import java.util.List;

import org.bks.model.Book;

/**
 * @author Caron Zhao
 *
 * Feb 25, 2014 12:41:35 PM
 */
public interface BookService {
	List<Book> findSharedBooks(String userId);
}
