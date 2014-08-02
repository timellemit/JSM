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
<<<<<<< HEAD
=======
>>>>>>> fc87174bcc1a43924312d9e42cdb860ae75ff4f4
	public void printDescription() {
		System.out.println(toString());
	}
	
<<<<<<< HEAD
=======
>>>>>>> bbed7f6411cac2807198647b2ce552179ba99841
>>>>>>> fc87174bcc1a43924312d9e42cdb860ae75ff4f4
}
