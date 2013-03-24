package net.raven.ui.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.raven.core.dao.user.UserManager;
import net.raven.core.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class UserManagement
{
	private final UserManager userManager;

	@Autowired
	public UserManagement(UserManager userManager)
	{
		this.userManager = userManager;
	}

	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser()
	{
		List<User> list = userManager.getUserList();
		System.out.println();
		return Response.status(200).entity(list.get(0)).build();
	}

	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addUser(@FormParam("login") final String login)
	{
		User newUser = new User();
		if (login == null || login.length() == 0)
		{
			return Response.status(Status.NO_CONTENT).build();
		}
		newUser.setLogin(login);
		userManager.addUser(newUser);
		return Response.status(200).build();
	}
}
