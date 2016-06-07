import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitExample {
	private final Pattern first = Pattern.compile("(\\d+)~(\\d+)~[\\_]{3}$");
	private Pattern second = Pattern.compile("(\\d+)~[\\_]~(\\d+)");
	private List<Pattern> listaPatrones;
	List<String> fields;

	public SplitExample() {
		fields = new ArrayList<String>();
		listaPatrones = new ArrayList<Pattern>();
		listaPatrones.add(first);
		listaPatrones.add(second);

	}

	public void checkString(String s) {
		 
		for (Pattern px : this.listaPatrones) {
			if (px.matcher(s).find()) {
				callAction(px.toString(),s) ;
				transformingData(s,px);
			}
		}
		
				
	}
	public void callAction(String command, String c){
		Map<String, Runnable> commands = new HashMap<>();
		 commands.put(first.toString(),()->transformacion1(c));
	     commands.put(second.toString(),()->transformacion2(c));
	     commands.get(command).run();
		
	}
	
	public void transformacion1(String c){
		 List<String> stream = Stream.of(c.split("~"))
	        .collect(Collectors.toList());
		 for(String values:stream){
			 if (values.toString().contains(("_")))
					fields.add("");
				fields.add(values.toString());
		 }
		
		
	}
	public void transformacion2(String c){
		
	}
	

	private void transformingData(String s, Pattern ox) {
		
		Object[] splitAsStream = Pattern.compile("~").
				splitAsStream(s).
				sequential().
				
				toArray();
		for (Object values : splitAsStream) {
			if (values.toString().contains(("_")))
				fields.add("");
			fields.add(values.toString());
		}
	
		
		String[] inputArray = {"Token1:Token2:Token3:other",
		        "foo:bar:baz:qux", "test:test"};
		Map<String, String[]> map = Arrays.stream(inputArray)
		    .map(Pattern.compile("([^:]++):([^:]++):?(.+)?")::matcher)
		    
		    .filter(Matcher::matches)
		    .collect(Collectors.toMap(m -> m.group(1), m -> new String[] {m.group(2), m.group(3)}));
		map.forEach((k, v) -> {
		//    System.out.println(k+" => "+Arrays.toString(v));
		});
		
		

	}

	public List<String> getFields() {
		return this.fields;
	}

	public static void main(String[] args) {
		SplitExample x = new SplitExample();
		x.checkString("123~3333~___");
		ArrayList<String> datos = (ArrayList<String>) x.getFields();
		//System.out.println(datos.get(0));
		//System.out.println(datos.get(1));
		//System.out.println(datos.get(2));

		x.checkString("123~_~3333");
		//datos = (ArrayList<String>) x.getFields();
		//	System.out.println(datos.get(0));
		//	System.out.println(datos.get(1));
		//	System.out.println(datos.get(2));
		// x.checkString("123-");
		// x.checkString("-4567");
		// x.checkString("123-4567-890");
	}

}
