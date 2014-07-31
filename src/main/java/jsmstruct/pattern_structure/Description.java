package main.java.jsmstruct.pattern_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Description {

	public List<List<Double>> desc;
	
	public Description(){
		desc = new ArrayList<List<Double>>();
	}
	
	public Description(List<List<Double>> newDescription){
		desc = new ArrayList<List<Double>>();
        desc.addAll(newDescription);
	}
	
	public Description intersect(Description desc2) {
		List<List<Double>> intersection = new ArrayList<List<Double>>();
		for (int i = 0; i < desc2.desc.size(); i++) {
			intersection.add(Description.meet(desc.get(i), desc2.desc.get(i)));
		}
		return new Description(intersection);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Double> meet(List<Double> interval1, List<Double> interval2) {
    	return new ArrayList(Arrays.asList(Math.min(interval1.get(0), interval2.get(0)),
    			Math.max(interval1.get(1), interval2.get(1))));	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Description desc1 = new Description(new ArrayList(Arrays.asList(
       		 Arrays.asList(1.38, 2.56),
       		 Arrays.asList(1.52, 4.56)
       		 )));
		
		Description desc2 = new Description(new ArrayList(Arrays.asList(
       		 Arrays.asList(1.24, 2.78),
       		 Arrays.asList(0.56, 3.56)
       		 )));
		
		System.out.println(desc1.intersect(desc2).desc);
	}
}
