package main.java.jsmstruct.pattern_structure;

import java.util.*;

public class Concept {
        int position;
        //Set<Integer> intent;
        Description intent;
        Set<Integer> parents;
        public Concept() {
                position = -1;
                intent = new Description();
                parents = new HashSet<Integer>();
        }
        public void setPosition(int newPosition){
               position = newPosition;
        }
        public void setIntent(Description newIntent){
               intent = newIntent;
        }
        public void setParents(Set<Integer> newParents){
               //parents = newParents;
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
                 Concept c1 = new Concept();
                 c1.printConcept();
                 c1.setPosition(10);
                 c1.printConcept();
                 Description desc1 = new Description(new ArrayList(Arrays.asList(
                   		 Arrays.asList(1.38, 2.56),
                   		 Arrays.asList(1.52, 4.56)
                   		 )));
            		
            		Description desc2 = new Description(new ArrayList(Arrays.asList(
                   		 Arrays.asList(1.24, 2.78),
                   		 Arrays.asList(0.56, 3.56)
                   		 )));
                 c1.setIntent(desc1);

                 c1.printConcept();
                 
                 Concept c2 = new Concept();
                 c2.printConcept();
                 c2.setPosition(10);
                 c2.printConcept();
          
                 c2.setIntent(desc2);

         }
}

