import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

public class ConvertingFieldTest {

	@Test
	public void ShoulBeReturnSameAccountValue() {
		//given a field count 
		String account ="1233455";
		//when
		ConvertingField converter = new ConvertingField(account);
		
		//then
		List<String> result = converter.getConverterAccount();
		
		assertEquals("1233455", result.get(0));
		
	}
	
	@Test
	public void ShoulBeReturnSameAccount() {
		//given a field count 
		String account ="1233455~________";
		//when
		ConvertingField converter = new ConvertingField(account);
		
		//then
		List<String> result = converter.getConverterAccount();
		
		assertEquals("1233455", result.get(0));
		assertEquals("", result.get(1));
		
	}
	
	@Test
	public void ShoulBeReturnSameAccountUnderScore() {
		//given a field count 
		String account ="1233455~________";
		//when
		ConvertingField converter = new ConvertingField(account);
		
		//then
		List<String> result  = converter.getConverterAccount();
		
		assertEquals("1233455", result.get(0));
		assertEquals("", result.get(1));
		
		//converter.getStreamValuesAccount().stream().forEach(
			//	p->System.out.println(p));
		
	}
	
	@Test
	public void ShoulBeReturnSameAccounWhenSecondValuesIsPopulate() {
		//given a field count 
		String account ="1233455~453245";
		//when
		ConvertingField converter = new ConvertingField(account);
		
		//then
		List<String> result  = converter.getConverterAccount();
		
		assertEquals("1233455", result.get(0));
		assertEquals("453245", result.get(1));
		
	}
	
	@Test
	public void ShoulBeReturnSameAccounWhenThirdValuesInBlank() {
		//given a field count 
		String account ="1233455~________~_____";
		//when
		ConvertingField converter = new ConvertingField(account);
		
		//then
		List<String> result  = converter.getConverterAccount();
		
		assertEquals("1233455", result.get(0));
		assertEquals("", result.get(1));
		assertEquals("", result.get(2));
		
	}
	@Test
	public void ShoulBeReturnSameAccounWhenThirdValuesIsPopulate() {
		//given a field count 
		String account ="1233455~2133451~33235";
		//when
		ConvertingField converter = new ConvertingField(account);
		
		//then
		List<String> result  = converter.getConverterAccount();
		
		assertEquals("1233455", result.get(0));
		assertEquals("2133451", result.get(1));
		assertEquals("33235", result.get(2));
		
	}
	
	@Test
	public void returnAsListArrayofVAlues(){
		String account ="1233455~2133451~33235";
		//when
		ConvertingField converter = new ConvertingField(account);
		//for(String values:converter.getStreamValuesAccount()){
			//System.out.println(values.toString());
		//}
		//converter.getStreamValuesAccount().stream().forEach(
			//	p->System.out.println(p));
		
	}
	
	@Test
	public void returnAsListArrayofStream(){
		String account ="1233455~2133451~33235";
		AccountNumber count = new AccountNumber();
		Stream<String> stream = Stream.of(account.split("~"));
		stream.forEach(p->count.setCampo1(p));
		
		//System.out.println(count.getCampo2());
		
	}
	@Test
	public void returnAsListArrayofStreamFilter(){
		String account ="1233455~______~33235";
		AccountNumber count = new AccountNumber();
		Stream<String> stream = Stream.of(account.split("~"));
		stream.filter(s->s.equals("______"));
		
		//.forEach(s->System.out.println(s));
		
		
	}
	
	@Test
	public void testLambdas(){
		String account ="1233455~______~33235~____";
		
		ConvertingField count = new ConvertingField(account);
		List<User> users = new ArrayList<>();
		String [] values = account.split("~");
		users.add(new User(values[0], values[1], values[2]));
		//users.add(new User("Peter", "member"));
		List<User> admins = count.process(users, (u) -> u.getRole().equals("______")
				);
		for(User user:admins){
			System.out.println(user.toString());
		}
	}
	
	
}

