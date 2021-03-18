package br.com.stone;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.stone.bean.Employee;
import br.com.stone.bean.MyJaxbBean;

/**
 * Root resource (exposed at "profit" path)
 */
@Path("profit")
public class ProfitResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@Path("{value}")
    @GET
    @Produces("application/json")
    public MyJaxbBean getIt(@PathParam("value") String value) {
		Employee func1 = new Employee();
		func1.matricula = "0001";
		func1.nome = "Victor Wilson";
		func1.valor = "2329.10";
		
		Employee func2 = new Employee();
		func2.matricula = "0002";
		func2.nome = "Cross Perkins";
		func2.valor = "1329.10";
		
		ArrayList func = new ArrayList<Employee>();
		func.add(func1);
		func.add(func2);
		
		
		return new MyJaxbBean(func, 32);
    }
}
