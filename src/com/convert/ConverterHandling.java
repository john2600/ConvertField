package com.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConverterHandling {

	private Pattern first = Pattern.compile("(\\d+)~(\\d+)~[\\_]{3}$");
	private Pattern second = Pattern.compile("(\\d+)~[\\_]~(\\d+)");
	Map<String, Runnable> commands;
	private List<Pattern> listaPatrones;
	List<String> fields;

	public ConverterHandling() {
		fields = new ArrayList<String>();
		listaPatrones = new ArrayList<Pattern>();
		listaPatrones.add(first);
		listaPatrones.add(second);
		commands = new HashMap<>();
	}

	public void checkString(String s) {
		for (Pattern px : this.listaPatrones) {
			if (px.matcher(s).find()) {
				callAction(px.toString(), s);
			}
		}
	}
	

	public void callAction(String command, String c) {
		
		commands.put(first.toString(), ()-> formOne(c));
		commands.put(second.toString(), ()-> formTwo(c));
		commands.get(command).run();
	}

	public void formOne(String c) {
		List<String> stream = Stream.of(c.split("~")).collect(Collectors.toList());
		for (String values : stream) {
			//if (values.toString().equals(("___")))
				//fields.add("\t\t\t");
			//fields.add(values);
			
			System.out.println(values);
		}

	}

	public void formTwo(String c) {
		List<String> stream = Stream.of(c.split("~")).collect(Collectors.toList());
		for (String values : stream) {
			if (values.toString().equals(("_")))
				fields.add("\t");
			fields.add(values);
		}

	}

	public List<String> getFields() {
		return this.fields;
	}

}
