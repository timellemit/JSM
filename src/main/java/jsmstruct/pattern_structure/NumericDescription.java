package main.java.jsmstruct.pattern_structure;

import java.util.ArrayList;

public class NumericDescription extends AbstractDescription {
	
	public NumericDescription(ArrayList<NumericDescriptionElement> desc){
		super();
		for (int i = 0; i < desc.size(); i++) {
			super.description.add(desc.get(i));
		}
	}
	
	@Override
	public AbstractDescription intersect(AbstractDescription description2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
