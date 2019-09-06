package ${package}.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ${package}.domain.Message;

@Path("test")
@Api(value = "test")
public class MyResource {	
	@GET 
	@Path("helloJson")	
	@ApiOperation(value = "Say hello to user")
	@ApiResponses(value = { 
		      @ApiResponse(code = 401, message = "User is Unauthorized"),
		      @ApiResponse(code = 500, message = "Execution error")})
	@Produces(MediaType.APPLICATION_JSON)
	public Message getHelloJson(
			@ApiParam(value = "Name of the user", required = false) @QueryParam("user") @DefaultValue("world") String user) {
		return new Message("Hello " + user + "!", "English");
	}	
}