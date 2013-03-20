package net.raven.ui.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/payment")
public class UserManagement
{
	@GET
	@Path("/rest")
	public Response savePayment()
	{
		return Response.status(200).build();

	}

}
