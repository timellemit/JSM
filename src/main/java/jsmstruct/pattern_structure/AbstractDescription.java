package main.java.jsmstruct.pattern_structure;

import java.util.ArrayList;

public abstract class AbstractDescription{
	
	protected ArrayList<AbstractDescriptionElement> description;
	
	public AbstractDescription(ArrayList<AbstractDescriptionElement> description){
		this.description = description;
	};
	
	public abstract AbstractDescription intersect(
			AbstractDescription description2);
	
	public abstract void printDescription();
	
}
