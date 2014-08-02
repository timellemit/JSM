package main.java.jsmstruct.pattern_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DescriptionNumeric {

	public List<Double> desc;
	
	public DescriptionNumeric(){
		desc = new ArrayList<Double>();
	}
	
	public DescriptionNumeric(List<Double> newDescription){
		desc = new ArrayList<Double>();
        desc.addAll(newDescription);
	}
	
	public DescriptionNumeric intersect(DescriptionNumeric desc2) {
		List<Double> intersection = new ArrayList<Double>();
		for (int i = 0; i < desc2.desc.size(); i++) {
			intersection.add(DescriptionNumeric.meet(desc.get(i), desc2.desc.get(i)));
		}
		return new DescriptionNumeric(intersection);
	}
	
	public static Double meet(Double num1, Double num2) {
		System.out.println(num1.toString() +" " + num2.toString());
		if (num1.equals(num2)) return num1;
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		DescriptionNumeric desc1 = new DescriptionNumeric(new ArrayList(Arrays.asList(
				1.38, 2.56
       		 )));
		
		DescriptionNumeric desc2 = new DescriptionNumeric(new ArrayList(Arrays.asList(
				1.38, 2.78
       		 )));
		
		System.out.println(desc1.intersect(desc2).desc);
	}
}

