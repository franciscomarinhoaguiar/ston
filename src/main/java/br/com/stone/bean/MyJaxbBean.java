package br.com.stone.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class MyJaxbBean {
	 @XmlElement(name="Participacoes")
	 public ArrayList<EmployeeBean> func;
	   @XmlElement(name="total_de_funcionarios")
	    public int totalFuncionarios;
	   
	   @XmlElement(name="total_distribuido")
	    public String totalDistribuido;
	   
	   @XmlElement(name="total_disponibilizado")
	    public String totalDisponibilizado;
	   
	  
	   @XmlElement(name="saldo_total_disponibilizado")
	    public String saldoTotalDisponibilizado;
	   
	 
	    public MyJaxbBean() {} // JAXB needs this
	 
	    public MyJaxbBean(ArrayList<EmployeeBean> func) {
	        this.func = func;
	      
	    }

}
