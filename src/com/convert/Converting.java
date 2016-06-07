package com.convert;

import java.util.ArrayList;


public class Converting {
	

	public void getString(String g) throws Exception {
		
		String[] values = g.split("~");
		if(values==null){
			throw new Exception(" ERROR ");
		}
		
		ArrayList<String> valores = new ArrayList<String>();
		String ultimo="";
		if(values.length>3){
			StringBuilder sb = new StringBuilder(values[3]);
			sb.append("-").append(values[4]).append("-").append(values[5]);
			ultimo = sb.toString();
		}
		for(int i=0; i<3; i++){
			values[i] = values[i].replaceAll("______", "");
			values[i]  = values[i] .replaceAll("_____", "");
			valores.add(values[i]);
		}
		valores.add(ultimo);
		

	    System.out.print(valores.get(0));
		System.out.print("\t");
		System.out.print(valores.get(1));
		System.out.print("\t");
		System.out.print(valores.get(2));
		System.out.print("\t");
		System.out.print(valores.get(3));
		
		
		

	}
}

