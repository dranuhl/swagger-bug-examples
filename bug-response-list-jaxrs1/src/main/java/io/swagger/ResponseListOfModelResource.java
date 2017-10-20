package io.swagger;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@Path("/api")
public final class ResponseListOfModelResource extends Object {
	public ResponseListOfModelResource() {
		super();
	}

	@ApiOperation(value = "Return List of objects")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Item> getModels() {
		return Arrays.asList(new Item("1", "foo"), new Item("2", "bar"));
	}
}
