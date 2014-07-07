package main.java.jsmstruct.pattern_structure;

import java.util.*;

public class Concept2<M extends AbstractDescription> {
        int position;
        M intent;
        Set<Integer> parents;
        public Concept2() {
                position = -1;
//                intent = new M();
                parents = new HashSet<Integer>();
        }
        public void setPosition(int newPosition){
               position = newPosition;
        }
        public void setIntent(M newIntent){
               intent = newIntent;
        }
        public void setParents(Set<Integer> newParents){
                parents.clear();
                parents.addAll(newParents);
        }
        
        public void printConcept() {
                System.out.println("Concept position:" + position);
                System.out.println("Concept intent:" + intent);
                System.out.println("Concept parents:" + parents);
        }
         @SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String []args) {
                 Concept2 c1 = new Concept2();
                 c1.printConcept();
                 c1.setPosition(10);
                 IntervalDescriptionElement interval1 = new IntervalDescriptionElement(1.3,4.5);
         		 IntervalDescriptionElement interval2 = new IntervalDescriptionElement(3.5,5.9);
         		 IntervalDescription desc1 = new IntervalDescription(
         				new ArrayList<IntervalDescriptionElement>(Arrays.asList(interval1, interval2)));
                 c1.setIntent(desc1);
                 c1.printConcept();


         }
}

