package main.java.jsmstruct.pattern_structure;

public class IntervalDescriptionElement extends AbstractDescriptionElement {
	
	private Double a;
	private Double b;
	
	public IntervalDescriptionElement(Double lower, Double upper){
		
		a = lower;
		b = upper;
	}
	@Override
	public IntervalDescriptionElement meet(AbstractDescriptionElement descElem2) {
		return new IntervalDescriptionElement(
				Math.min(a, ((IntervalDescriptionElement)descElem2).a),
				Math.max(b, ((IntervalDescriptionElement)descElem2).b));	
	}
	
	@Override
	public String toString() {		
		return "["+a+", "+b+"]";
	}
	
	public static void main(String[] args) {
		IntervalDescriptionElement interval1 = new IntervalDescriptionElement(1.3,4.5);
		IntervalDescriptionElement interval2 = new IntervalDescriptionElement(3.5,5.9);
		interval1.meet(interval2).printElement();
		}
}
