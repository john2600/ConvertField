import java.util.List;
import java.util.function.Predicate;

public class FilterLambdas {
	public  void filter(List<String> names, Predicate condition) { 
		
		for(String name: names) { 
			if(condition.test(name)) { 
				System.out.println(name + " "); 
			} 
		} 
	}
	
	public  void filter(List<String> names, Predicate condition, Predicate condition2) { 
		
		for(String name: names) { 
			if(condition.test(name)) { 
				System.out.println(name + " "); 
			} 
		} 
	}
	
	public void filterLambdasFilter(){
		
	}
}

	


