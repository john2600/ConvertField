package com.convert;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ConverterHandlingTest {

	@Test
	public void test() {
		ConverterHandling x = new ConverterHandling();
		x.checkString("123~3333~___~");
		ArrayList<String> datos = (ArrayList<String>) x.getFields();
		assertEquals("123",datos.get(0));
		//assertEquals("3333",datos.get(1));
		//assertEquals("\t\t\t",datos.get(2));
	}

}
