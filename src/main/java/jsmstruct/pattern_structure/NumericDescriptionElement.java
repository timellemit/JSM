package main.java.jsmstruct.pattern_structure;

public class NumericDescriptionElement extends AbstractDescriptionElement {
	
	private Double a;
	public NumericDescriptionElement(Double a){
		this.a = a;
	}
	@Override
	public NumericDescriptionElement meet(AbstractDescriptionElement descElem2) {
		if (a.equals(((NumericDescriptionElement) descElem2).a)) 
			return new NumericDescriptionElement(a);
		else return null;
	}

	@Override
	public String toString() {
		return a.toString();
	}

}
