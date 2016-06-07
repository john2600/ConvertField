package com.convert;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertingTest {

	@Test
	public void test() throws Exception {
		Converting convert = new Converting();
		// String value="1234567~_____~______~";
		// convert.getString(value);
		 System.out.println("");
		 String value2="1234567~______~______~";
		 convert.getString(value2);
		 System.out.println("");
		 
		 String value3 = "1234567~_____~______~";
		 convert.getString(value3);
		 System.out.println("");
		 
		 String value4 = "1234567~12345~______~";  		 
		 convert.getString(value4);
		 System.out.println("");
		 
		 String value5 = "1234567~12345~123456~";
		 convert.getString(value5);
		 System.out.println("");
		 
		 String value6 = "1234567~_____~123456~";
		 convert.getString(value6);
		 System.out.println("");
		 
		 String value7 = "1234567~_____~______~MX~12345~123";
		 convert.getString(value7);
		 System.out.println("");
		 
		 
	}

}
