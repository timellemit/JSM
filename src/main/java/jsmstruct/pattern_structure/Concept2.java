package main.java.jsmstruct.pattern_structure;

import java.util.*;

public class Concept2<M extends AbstractDescription> {

	int position;
	M intent;
	Set<Integer> parents;

	public Concept2() {
		position = -1;
		parents = new HashSet<Integer>();
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int newPosition) {
		position = newPosition;
	}

	public M getIntent() {
		return intent;
	}

	public void setIntent(M newIntent) {
		intent = newIntent;
		// intent = new M();
		parents = new HashSet<Integer>();
	}

	public void setParents(Set<Integer> newParents) {
		parents.clear();
		parents.addAll(newParents);
	}

	public void printConcept() {
		System.out.println("Concept position:" + position);
		System.out.println("Concept intent:" + intent);
		System.out.println("Concept parents:" + parents);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Concept2 c1 = new Concept2();
		c1.setPosition(10);
		c1.setIntent(new IntervalDescription(
				new ArrayList<IntervalDescriptionElement>(Arrays.asList(
						new IntervalDescriptionElement(1.3, 4.5),
						new IntervalDescriptionElement(3.5, 5.9)))));
		c1.printConcept();

		Concept2 c2 = new Concept2();
		c2.setPosition(11);
		c2.setIntent(new NumericDescription(
				new ArrayList<NumericDescriptionElement>(Arrays.asList(
						new NumericDescriptionElement(1.3),
						new NumericDescriptionElement(5.2)))));
		c2.setParents(new HashSet<Integer>(Arrays.asList(c1.getPosition())));
		c2.printConcept();
		c1.printConcept();
		c1.setPosition(10);
		IntervalDescriptionElement interval1 = new IntervalDescriptionElement(
				1.3, 4.5);
		IntervalDescriptionElement interval2 = new IntervalDescriptionElement(
				3.5, 5.9);
		IntervalDescription desc1 = new IntervalDescription(
				new ArrayList<IntervalDescriptionElement>(Arrays.asList(
						interval1, interval2)));
		c1.setIntent(desc1);
		c1.printConcept();

	}
}
