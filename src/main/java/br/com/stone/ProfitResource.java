package br.com.stone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.stone.bean.EmployeeBean;
import br.com.stone.bean.MyJaxbBean;

import br.com.stone.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;

/**
 * Root resource (exposed at "profit" path)
 */
@Path("profit")
public class ProfitResource {
	private AppController controller = AppController.getInstance();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
	@Path("{value}")
    @GET
    @Produces("application/json")
    public MyJaxbBean getBonus(@PathParam("value") String value) {
		System.out.println("getting bonus....");
		List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(controller.getModel().values());
        Locale localeBR = new Locale("pt","BR");
        NumberFormat currency = NumberFormat.getCurrencyInstance(localeBR);
        ArrayList func = new ArrayList<EmployeeBean>();
        double total = 0;
        double bonus = 0;
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.matricula = employee.matricula;
			employeeBean.nome = employee.nome;
			bonus = employee.calculate();
			System.out.println("-----------------------");
			total += bonus;
			employeeBean.valor = currency.format(bonus);
			func.add(employeeBean);
			
		}
		MyJaxbBean beanResult = new MyJaxbBean(func);
		beanResult.totalFuncionarios = func.size();
		beanResult.totalDisponibilizado = currency.format(Double.parseDouble(value));
		beanResult.totalDistribuido = currency.format(total);
		double saldo = Double.parseDouble(value) - total;
		
		beanResult.saldoTotalDisponibilizado = currency.format(saldo);
		
		return beanResult;
    }
}
