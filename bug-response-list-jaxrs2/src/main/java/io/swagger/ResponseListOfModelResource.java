package io.swagger;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElementWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@Path("")
public final class ResponseListOfModelResource extends Object {
	public ResponseListOfModelResource() {
		super();
	}

	@ApiOperation(value="Return List<Item>",
	              notes="Let Jersey/JAXB do the element wrapping")
	@GET
	@Path("list")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@XmlElementWrapper(name="items")
	public List<Item> getModels() {
		return Arrays.asList(new Item("1", "foo"), new Item("2", "bar"));
	}

	@ApiOperation(value="Return Items, which contains List<Item>",
	              notes="JAXB annotations are used so that the result is semantical equivalent to List<Iterm> been returned")
	@GET
	@Path("items")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Items getItems() {
		return new Items(Arrays.asList(new Item("1", "foo"), new Item("2", "bar")));
	}
}
