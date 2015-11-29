package CoffeeService;

import java.util.List;

import com.remoteTiger.CoffeeSpringDao;

import CoffeeModel.Model;
import CoffeeServiceInterface.CoffeeServiceInt;

//import com.remoteTiger.CoffeeSpringDao;

public class CoffeeServiceLayer implements CoffeeServiceInt {
	
	
	private CoffeeSpringDao cDAO = new CoffeeSpringDao();
	
	public void addCoffee(Model c) {
		cDAO.addCoffee(c);
	}
	
	public List<Model> getCoffee(){
		return cDAO.getCoffee();
	}
	
	

}
