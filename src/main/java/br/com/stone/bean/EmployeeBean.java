package br.com.stone.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeBean {
	@XmlElement(name="matricula")
	public String matricula;
	@XmlElement(name="nome")
	public String nome;
	@XmlElement(name="valor_da_participação")
	public String valor;
	
	public EmployeeBean(){
		
	}

}
