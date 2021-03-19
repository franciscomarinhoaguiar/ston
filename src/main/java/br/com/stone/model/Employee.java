package br.com.stone.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 

public class Employee {

	public String matricula;
	public String nome;
	public String area;
	public String cargo;
	public String salario_bruto;
	public String data_de_admissao;
	public static final int BASE_SALARY = 1040;


	/**
	 * Calculate the bonus for the employee
	 * @return
	 */
	
	public double calculate() {
		double salary = getSalary(this.salario_bruto);
		System.out.println("salary:"+salary);
		int feeByDate = getFeeByDate();
		System.out.println("feeByDate:"+feeByDate);
		double f1 = salary * feeByDate;
		int feeByArea =  getFeeByArea();
		System.out.println("feeByArea:"+feeByArea);
		double f2 = salary * feeByArea;
		double sum = f1 + f2;
		int feeBySalary = getFeeBySalary();
		System.out.println("feeBySalary:"+feeBySalary);
		double div = sum/feeBySalary;
		double result = div * 12;
		return result;
	}

	/**
	 * Print employee information
	 */
	public String toString() {
		return matricula + "\n" + nome + "\n" + area + "\n" + cargo + "\n" + salario_bruto + "\n" + data_de_admissao;
	}

	/**
	 * Get the fee by area
	 * @return fee
	 */
	private int getFeeByArea() {
		if (this.area.equals(EnumArea.Diretoria.name())) {
			return 1;

		}

		if (this.area.equals(EnumArea.Contabilidade.name()) || this.area.equals(EnumArea.Financeiro.name())
				|| this.area.equals(EnumArea.Tecnologia.name())) {
			return 2;

		}
		if (this.area.equals("Serviços Gerais")) {
			return 3;

		} else {
			return 5;
		}

	}
	
	

	/**
	 *  Get fee by salary
	 * @return fee
	 */
	private int getFeeBySalary() {

		if (this.cargo.equals("Estagiário")) {
			return 1;

		}
		if (getSalary(this.salario_bruto) >= (8 * BASE_SALARY)) {
			return 5;
		}

		if (getSalary(this.salario_bruto) >= (5 * BASE_SALARY) && getSalary(this.salario_bruto) < (8 * BASE_SALARY)) {
			return 3;
		}
		if (getSalary(this.salario_bruto) > (3 * BASE_SALARY) && getSalary(this.salario_bruto) < (5 * BASE_SALARY)) {
			return 2;
		}else{
			return 1;
		}
	
	}
	/**
	 * Get fee by date
	 * @return fee
	 */
	private int getFeeByDate() {
		Date today = new Date();
		Date date_adm = getDate(this.data_de_admissao);
		int diff = today.getYear() - date_adm.getYear();
		

		if (diff<=1) {
			return 1;

		}
		if (diff >1 && diff<3) {
			return 2;
		}
		if (diff >=3 && diff<8) {
			return 3;
		}
		return 5;
	
	}

	/**
	 * Parse salary(String) to double
	 * @param salary
	 * @return salary
	 */
	private double getSalary(String salary) {
		salary = salary.substring(3);
		salary = salary.replaceAll("\\.", "");
		salary = salary.replaceAll("\\,", ".");
		Double s = Double.parseDouble(salary);
		return s;
	}
	
	/**
	 * Parse a date(String) to date
	 * @param date_adm
	 * @return date object
	 */
	private Date getDate(String date_adm){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		 try {
	            date = formatter.parse(date_adm);
	           
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 return date;
	}

	
}
