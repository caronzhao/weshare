package org.weshare.web.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.weshare.model.RegisterProfile;
import org.weshare.web.model.User;
import org.weshare.web.service.UserService;

/**
 * @author Caron Zhao
 *
 * Mar 16, 2014 8:55:52 PM
 */
@Path("/account")
@Component
public class AccountController {
	@Autowired
	private UserService userService;
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response register(RegisterProfile profile) {
		User user = new User();
		
		return Response.ok().build();
		
	}
}