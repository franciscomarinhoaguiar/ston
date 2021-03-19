package br.com.stone;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.stone.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Path("users")

public class UserResource {
	private AppController controller = AppController.getInstance();
	
	/**
	 *  Method handling HTTP POST requests. Save the user.
	 * @param body - New user - Json Format
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(String body) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Employee emp = objectMapper.readValue(body, Employee.class);
			System.out.println(emp.toString());
			controller.getModel().put(emp.matricula, emp);
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
	   
	}
	/**
	 *  Method handling HTTP GET requests. List the users.
	 * 
	 */
	@GET
    @Produces({MediaType.APPLICATION_JSON })
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(controller.getModel().values());
        return employees;
    }

	@Path("{value}")
	@DELETE
    @Produces({MediaType.APPLICATION_JSON })
    public Response removeUser(@PathParam("value") String value) {
		Employee employee = controller.getModel().get(value);
		
	        if(employee == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        try{
	        	controller.getModel().remove(value);
	           
	            return Response.status(Response.Status.OK).build();
	        }
	        catch(Exception ex)
	        {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
	        } 
    }
	
	 @PUT
	 @Path("{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response updateEmployee(@PathParam("id") String id, String body)
	    {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				Employee employeeUpdate = objectMapper.readValue(body, Employee.class);
				System.out.println(employeeUpdate.toString());
				Employee employeeCurrent = controller.getModel().get(id);
				 if(employeeCurrent == null)
			            return Response.status(Response.Status.NOT_FOUND).build();
				 
				 controller.getModel().put(id, employeeUpdate);
				 return Response.status(Response.Status.OK).entity(employeeUpdate).build();

			} catch (JsonMappingException e) {
				
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			} catch (JsonProcessingException e) {
				
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			}
			catch(Exception ex)
	        {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
	        } 
		    
	    }

	

}
