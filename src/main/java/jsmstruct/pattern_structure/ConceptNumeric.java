package main.java.jsmstruct.pattern_structure;

import java.util.*;

public class ConceptNumeric {
        int position;
        //Set<Integer> intent;
        DescriptionNumeric intent;
        Set<Integer> parents;
        public ConceptNumeric() {
                position = -1;
                intent = new DescriptionNumeric();
                parents = new HashSet<Integer>();
        }
        public void setPosition(int newPosition){
               position = newPosition;
        }
        public void setIntent(DescriptionNumeric newIntent){
               intent = newIntent;
        }
        public void setParents(Set<Integer> newParents){
               //parents = newParents;
                parents.clear();
                parents.addAll(newParents);
        }
        
        public void printConcept() {
                System.out.println("Concept position:" + position);
                System.out.println("Concept intent:" + intent.desc);
                System.out.println("Concept parents:" + parents);
        }
         @SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String []args) {
                 ConceptNumeric c1 = new ConceptNumeric();
                 c1.printConcept();
                 c1.setPosition(10);
                 c1.printConcept();
                 DescriptionNumeric desc1 = new DescriptionNumeric(new ArrayList(Arrays.asList(
                		 1.38, 2.56
                   		 )));
            		
            		DescriptionNumeric desc2 = new DescriptionNumeric(new ArrayList(Arrays.asList(
                   		 1.24, 2.78
                   		 )));
                 c1.setIntent(desc1);

                 c1.printConcept();
                 
                 ConceptNumeric c2 = new ConceptNumeric();
                 c2.printConcept();
                 c2.setPosition(10);
                 c2.printConcept();
          
                 c2.setIntent(desc2);

         }
}

