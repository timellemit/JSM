package main.java.jsmstruct.pattern_structure;

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalDescription extends AbstractDescription{
		
	public IntervalDescription(ArrayList<IntervalDescriptionElement> desc) {
		super();
		for (int i = 0; i < desc.size(); i++) {
			super.description.add(desc.get(i));
		}
	}
	
	@Override
	public IntervalDescription intersect(AbstractDescription description2) {
		ArrayList<IntervalDescriptionElement> intersection = new ArrayList<IntervalDescriptionElement>();
		for (int i = 0; i < description2.description.size(); i++) {
			intersection.add(((IntervalDescriptionElement)description.get(i)).
					meet(description2.description.get(i)));
		}
		return new IntervalDescription(intersection);
	}
	
	@Override
	public String toString() {
		String repr = "<";
		for (AbstractDescriptionElement desc : description) {
			repr += desc.toString()+",";
		}
		repr += ">";
		return repr;
	}

	public static void main(String[] args) {
		IntervalDescriptionElement interval1 = new IntervalDescriptionElement(1.3,4.5);
		IntervalDescriptionElement interval2 = new IntervalDescriptionElement(3.5,5.9);
		IntervalDescriptionElement interval3 = new IntervalDescriptionElement(1.2,4.7);
		IntervalDescriptionElement interval4 = new IntervalDescriptionElement(3.4,5.7);
		IntervalDescription desc1 = new IntervalDescription(
				new ArrayList<IntervalDescriptionElement>(Arrays.asList(interval1, interval2)));
		IntervalDescription desc2 = new IntervalDescription(
				new ArrayList<IntervalDescriptionElement>(Arrays.asList(interval3, interval4)));
		desc2.printDescription();
		desc1.intersect(desc2).printDescription();
	}

	
}
