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
	
<<<<<<< HEAD
=======
	public void printDescription() {
		System.out.println(toString());
	}
	
>>>>>>> bbed7f6411cac2807198647b2ce552179ba99841
}
