package org.bks.model;

import java.util.List;

import org.bks.model.Book;

/**
 * @author Caron Zhao
 *
 * Feb 25, 2014 2:16:07 PM
 */
public class SharedBooks {
	
	private List<Book> books;
	
	private int totalNumber = 10;
	
	public SharedBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
}