package main.java.jsmstruct.pattern_structure;

import java.util.ArrayList;
import java.util.Arrays;

public class NumericDescription extends AbstractDescription {
	
	public NumericDescription(ArrayList<NumericDescriptionElement> desc){
		super();
		for (int i = 0; i < desc.size(); i++) {
			super.description.add(desc.get(i));
		}
	}
	
	@Override
	public NumericDescription intersect(AbstractDescription description2) {
		ArrayList<NumericDescriptionElement> intersection = new ArrayList<NumericDescriptionElement>();
		for (int i = 0; i < description2.description.size(); i++) {
			NumericDescriptionElement meet = ((NumericDescriptionElement)description.get(i)).
			meet(description2.description.get(i));
			// meet may be null
			if (meet != null) intersection.add(meet);
		}
		return new NumericDescription(intersection);
	}
	
	@Override
	public String toString() {
		String repr = "[";
		for (AbstractDescriptionElement desc : description) {
			repr += desc.toString()+",";
		}
		repr += "]";
		return repr;
	}
	
	public static void main(String[] args) {
		NumericDescriptionElement num1 = new NumericDescriptionElement(1.3);
		NumericDescriptionElement num2 = new NumericDescriptionElement(5.2);
		NumericDescriptionElement num3 = new NumericDescriptionElement(1.3);
		NumericDescriptionElement num4 = new NumericDescriptionElement(4.6);
		NumericDescription desc1 = new NumericDescription(
				new ArrayList<NumericDescriptionElement>(Arrays.asList(num1, num2)));
		NumericDescription desc2 = new NumericDescription(
				new ArrayList<NumericDescriptionElement>(Arrays.asList(num3, num4)));
		System.out.println(desc1);
		System.out.println(desc2);
		System.out.println(desc1.intersect(desc2));
	}

}
