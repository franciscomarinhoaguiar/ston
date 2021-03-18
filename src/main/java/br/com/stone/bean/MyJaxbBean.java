package br.com.stone.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class MyJaxbBean {
	 @XmlElement(name="Participacoes")
	 public ArrayList<Employee> func;
	 
	 @XmlTransient
	    public int age;
	 
	   @XmlElement(name="total_de_funcionarios")
	    public int totalFuncionarios;
	   
	   @XmlElement(name="total_distribuido")
	    public int totalDistribuido;
	   
	   @XmlElement(name="total_disponibilizado")
	    public int totalDisponibilizado;
	   
	  
	   @XmlElement(name="saldo_total_disponibilizado")
	    public int saldoTotalDisponibilizado;
	   
	 
	    public MyJaxbBean() {} // JAXB needs this
	 
	    public MyJaxbBean(ArrayList<Employee> func, int age) {
	        this.func = func;
	        this.age = age;
	    }

}
