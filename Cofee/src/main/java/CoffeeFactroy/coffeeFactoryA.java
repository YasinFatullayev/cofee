package CoffeeFactroy;

//import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import CoffeeServiceInterface.CoffeeServiceInt;
import com.remoteTiger.CoffeeSpringDao;

//import CoffeeDaoInterfaces.CoffeeDAOInt;
import CoffeeModel.Model;
import CoffeeService.CoffeeServiceLayer;
import CoffeeServiceInterface.CoffeeServiceInt;

public class coffeeFactoryA {
	
	public static CoffeeServiceInt getCofe(int name){
		
		
		if(name==1){
			ApplicationContext context= 
		    		new ClassPathXmlApplicationContext("SpringBeans.xml");
			
			  Model co = (Model)context.getBean("addCofee");
		       
		        CoffeeSpringDao cof = (CoffeeSpringDao)context.getBean("CofeeDao");
		        cof.getCoffee();
		        cof.addCoffee(co);
				
				System.out.println(co.getCountry()+"   "+co.getName()+"   "
				+co.getPRODUCT_NO()+"   "+co.getQuantity());
		
			return new CoffeeServiceLayer();	
			
		}
		else{
		System.out.println("you are about to going SUPPLIER");
		return null;
		}
	}
}
