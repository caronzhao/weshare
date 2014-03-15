package org.bks.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bks.model.Book;
import org.bks.model.SharedBooks;
import org.bks.service.BookService;
import org.bks.util.JsonTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Caron Zhao
 * 
 *         Feb 24, 2014 3:57:47 PM
 */
@Path("/books")
@Component
public class BookController {
	
	@Autowired
	private BookService bookService = null;


	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response findSharedBooks(@PathParam(value = "userId") String userId) {
		List<Book> books = bookService.findSharedBooks(userId);
		
		SharedBooks sharedBooks = new SharedBooks(books);
		
		String jsonResult = JsonTranslation.object2JsonString(sharedBooks);
		
//		SharedBooks bs = JsonTranslation.jsonString2Object(jsonResult, SharedBooks.class);
		
		return Response.ok(jsonResult).build();
	}
}