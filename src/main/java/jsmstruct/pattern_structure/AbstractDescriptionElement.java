package main.java.jsmstruct.pattern_structure;

public abstract class AbstractDescriptionElement {
	
	public AbstractDescriptionElement(){};
	
	public abstract AbstractDescriptionElement meet(AbstractDescriptionElement descElem2);
	
	public abstract void printElement();
	

}
