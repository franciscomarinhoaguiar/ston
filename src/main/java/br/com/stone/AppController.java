package br.com.stone;

import java.util.HashMap;
import java.util.Map;

import br.com.stone.model.Employee;

public class AppController {
	
	private static AppController instance;
	
	private Map<String, Employee> contentProvider = new HashMap<>();
	
	private AppController(){};
	
	public static AppController getInstance(){
        if(instance == null){
            instance = new AppController();
        }
        return instance;
    }
	
	public Map<String, Employee> getModel(){
        return contentProvider;
    }

}
