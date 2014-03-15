package org.bks.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.bks.model.Book;
import org.bks.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author Caron Zhao
 *
 * Feb 25, 2014 1:24:12 PM
 */
@Service
public class BookServiceImpl implements BookService {

	@Override
	public List<Book> findSharedBooks(String userId) {
		// for PoC just hard code now
		List<Book> books = new ArrayList<>();

		Book book1 = new Book(1);
		book1.setIntroduction("This is the introduction of book1");
		String content = "软件开发月创新";
		book1.setTitle(content);
		book1.setCoverPath("http://10.0.2.2:8080/bks-web/pic/cover.png");

		Book book2 = new Book(2);
		book2.setTitle("Book 2");
		book2.setIntroduction("This is the introduction of book2");
		book2.setCoverPath("http://10.0.2.2:8080/bks-web/pic/cover.png");

		Book book3 = new Book(3);
		book3.setTitle("软件开发月创新3");
		book3.setIntroduction("This is the introduction of book3");
		book3.setCoverPath("http://10.0.2.2:8080/bks-web/pic/cover.png");

		Book book4 = new Book(4);
		book4.setTitle("软件开发月创新4");
		book4.setIntroduction("This is the introduction of book4");
		book4.setCoverPath("http://10.0.2.2:8080/bks-web/pic/cover.png");

		Book book5 = new Book(5);
		book5.setTitle("软件开发月创新5");
		book5.setIntroduction("This is the introduction of book5");
		book5.setCoverPath("http://10.0.2.2:8080/bks-web/pic/cover.png");
		
		Book book6 = new Book(6);
		book6.setTitle("软件开发月创新6");
		book6.setIntroduction("This is the introduction of book6");
		book6.setCoverPath("http://10.0.2.2:8080/bks-web/pic/cover.png");
		
		Book book7 = new Book(7);
		book7.setTitle("Book 7");
		book7.setIntroduction("This is the introduction of book7");
		book7.setCoverPath("http://10.0.2.2:8080/bks-web/pic/cover.png");
		
		Book book8 = new Book(8);
		book8.setTitle("Book 8");
		book8.setIntroduction("This is the introduction of book8");
		book8.setCoverPath("http://10.0.2.2:8080/bks-web/pic/cover.png");

		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
		books.add(book7);
		books.add(book8);
		
		return books;
	}
}