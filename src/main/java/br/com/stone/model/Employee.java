package br.com.stone.model;
import java.util.Date;
public class Employee {
	
//	"matricula": "0008601",
//	"nome": "Taylor Mccarthy",
//	"area": "Relacionamento com o Cliente", 
//	"cargo": "Auxiliar de Ouvidoria", 
//	"salario_bruto": "R$ 1.800,16",
//	"data_de_admissao": "2017-03-31"
	
	public String matricula;
	public String nome;
	public String area;
	public String cargo;
	public String salario_bruto;
	public String data_de_admissao;
	
	
	public  double calculate(){
		return 0;
	}
	
	public String toString(){
		return matricula + "\n" + nome + "\n"+ area + "\n"+ cargo + "\n"+salario_bruto+ "\n"+ data_de_admissao;
	}
	
	private int getFeeByArea(){
		if (this.area.equals(EnumArea.Diretoria)){
			return 1;
			
		}
		
		if (this.area.equals(EnumArea.Contabilidade) ||
				this.area.equals(EnumArea.Financeiro) ||
				this.area.equals(EnumArea.Tecnologia)){
			return 2;
			
		}
		if (this.area.equals(EnumArea.SGeral)){
			return 3;
			
		}else{
			return 5;
		}
		
		
	}

}
