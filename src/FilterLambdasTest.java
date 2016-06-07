import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FilterLambdasTest {

	@Test
	public void test() {
		FilterLambdas filter = new FilterLambdas();
		List<String> languages = new ArrayList<String>();
		languages =  Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp"); 
		System.out.println("Languages which starts with J :"); 
		filter.filter(languages, (str)->((String) str).startsWith("S")); 

	}

}
