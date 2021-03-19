package br.com.stone;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public List<Employee> getTodos() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(controller.getModel().values());
        return employees;
    }

	

}
