package org.weshare.web.rest.resource;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.weshare.web.service.BookService;

/**
 * @author Caron Zhao
 *
 * Mar 16, 2014 8:58:49 PM
 */
@Path("/books")
@Component
public class BookController {
	@Autowired
	private BookService bookService = null;

}
