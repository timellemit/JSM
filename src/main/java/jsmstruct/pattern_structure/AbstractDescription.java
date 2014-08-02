package main.java.jsmstruct.pattern_structure;

import java.util.ArrayList;

public abstract class AbstractDescription{
	
	protected ArrayList<AbstractDescriptionElement> description;
	
	public AbstractDescription(){
		description = new ArrayList<AbstractDescriptionElement>();
	};
	
	public abstract AbstractDescription intersect(
			AbstractDescription description2);
	
	public abstract String toString();
	
	public void printDescription() {
		System.out.println(toString());
	}
	
}
