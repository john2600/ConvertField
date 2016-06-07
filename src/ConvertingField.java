import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ConvertingField {
	

	private String account;
	private List<String> list = Arrays.asList("________","_____"," ");
	private List<String> accountValues;

	public ConvertingField(String account) {
		this.account = account;
		this.accountValues = new ArrayList<String>();
	}

	public List<String> getConverterAccount() {
		String [] result = this.account.split("~");
		String value;
		String ultimo="";
		
		
		for(String values : result){
			value= determinValues(values);
			this.accountValues.add(value);
			
			if(result.length>3){
				StringBuilder sb = new StringBuilder(result[3]);
				sb.append("-").append(result[4]).append("-").append(result);
				ultimo = sb.toString();
				this.accountValues.add(ultimo);
			}
			
		}
		return this.accountValues;
	}
	
	private String determinValues(String value){
		String returnValue ="";
		if(value.equals(list.get(0)) || value.equals(list.get(1))){
			return returnValue;
		} 
		return value;
		
	}
	
	public List<String> getStreamValuesAccount(){
		this.accountValues = Arrays.asList(this.account.split("~"));
		return this.accountValues;
	}
	
	public List<User> process(List<User> users, Predicate<User> predicate) {
		  List<User> result = new ArrayList<>();
		  for (User user : users) {
		    if (predicate.test(user)) {
		        result.add(user);
		    }
		    
		  }
		 
		  return result;
		}


}
