package main.java.jsmstruct.pattern_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IntervalDescription extends AbstractDescription{
	
	public IntervalDescription(ArrayList<IntervalDescriptionElement> description) {
		super(((ArrayList<AbstractDescriptionElement>) description));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public AbstractDescription intersect(AbstractDescription description2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printDescription() {
		System.out.println(description);
	}
	public static void main(String[] args) {
		IntervalDescriptionElement interval1 = new IntervalDescriptionElement(1.3,4.5);
		IntervalDescriptionElement interval2 = new IntervalDescriptionElement(3.5,5.9);
		ArrayList<AbstractDescriptionElement> desc = 
				new ArrayList<IntervalDescriptionElement>(Arrays.asList(interval1, interval2));
		IntervalDescription desc1 = new IntervalDescription(desc);
	}
}
