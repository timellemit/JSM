package main.java.jsmstruct.pattern_structure;

import java.util.*;

public class PatternStructure {
        int objectCount;
        int attributeCount;
        ArrayList<Concept> conceptList;
        public PatternStructure(int objectCounts, int attributeCounts) {
                objectCount = objectCounts;
                attributeCount = attributeCounts;
                conceptList = new ArrayList<Concept>();
                Concept bottom = new Concept();
                /*Set<Integer> b_intent = new HashSet<Integer>();
                for (int index = 0; index < attributeCount; ++index) {
                        b_intent.add(index);
                }
                bottom.setIntent(b_intent);*/
                bottom.setPosition(0);
                conceptList.add(bottom);
        }
        public int GetMaximalConcept(Description intent, int Generator) {
                boolean parentIsMaximal = true;
                while(parentIsMaximal) {
                        parentIsMaximal = false;
                        for (int parent : conceptList.get(Generator).parents) {
                                if (conceptList.get(parent).intent.desc.containsAll(intent.desc)) {
                                        Generator = parent;
                                        parentIsMaximal = true;
                                        break;
                                }
                        }
                }
                return Generator;
        }
        public int AddIntent(Description intent, int generator) {
                System.out.println("debug");
                System.out.println("called for " + intent);
                //printLattice();
                int generator_tmp = GetMaximalConcept(intent, generator);
                generator = generator_tmp;
                if (conceptList.get(generator).intent.equals(intent)) {
                        System.out.println("at generator:" + conceptList.get(generator).intent);
                        System.out.println("to add:" + intent);

                        System.out.println("already generated");
                        return generator;
                }
                Set<Integer> generatorParents = conceptList.get(generator).parents;
                Set<Integer> newParents = new HashSet<Integer>();
                for (int candidate : generatorParents) {
                        if (!intent.desc.containsAll(conceptList.get(candidate).intent.desc)) {
                        //if (!conceptList.get(candidate).intent.containsAll(intent)) {
                                //Set<Integer> intersection = new HashSet<Integer>(conceptList.get(candidate).intent);
                                //List<Description> intersection = new ArrayList<Description>(conceptList.get(candidate).intent);
                                //intersection.retainAll(intent);
                                Description intersection = intent.intersect(conceptList.get(candidate).intent);
                                System.out.println("recursive call (inclusion)");
                                candidate = AddIntent(intersection, candidate);
                        }
                        boolean addParents = true;
                        System.out.println("now iterating over parents");
                        Iterator<Integer> iterator = newParents.iterator();
                        while (iterator.hasNext()) {
                                Integer parent = iterator.next();
                                if (conceptList.get(parent).intent.desc.containsAll(conceptList.get(candidate).intent.desc)) {
                                        addParents = false;
                                        break;
                                }
                                else {
                                        if (conceptList.get(candidate).intent.desc.containsAll(conceptList.get(parent).intent.desc)) {
                                                iterator.remove();
                                        }
                                }
                        }

                        if (addParents) {
                                newParents.add(candidate);
                        }
                }
                System.out.println("size of lattice: " + conceptList.size());
                Concept newConcept = new Concept();
                newConcept.setIntent(intent);
                newConcept.setPosition(conceptList.size());
                conceptList.add(newConcept);
                conceptList.get(generator).parents.add(newConcept.position);
                for (int newParent: newParents) {
                        if (conceptList.get(generator).parents.contains(newParent)) {
                                conceptList.get(generator).parents.remove(newParent);
                        }
                        conceptList.get(newConcept.position).parents.add(newParent);
                }
                return newConcept.position;
        }
        public void printLatticeStats() {
                System.out.println("Lattice stats");
                System.out.println("max_object_index = " + objectCount);
                System.out.println("max_attribute_index = " + attributeCount);
                System.out.println("Current concept count = " + conceptList.size());
        }
        public void printLattice() {
                for (int i = 0; i < conceptList.size(); ++i) {
                        printConceptByPosition(i);
                }
        }
        public void printConceptByPosition(int index) {
                System.out.println("Concept at position " + index);
                conceptList.get(index).printConcept();
        }
        
        @SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String []args) {
        	PatternStructure ps = new PatternStructure(4, 4);
//        	Description desc5678 = new Description(new ArrayList(Arrays.asList(
//              		 Arrays.asList(0.55, 0.71),
//              		 Arrays.asList(0.62, 0.72),
//              		Arrays.asList(-0.06, 0.12),
//              		Arrays.asList(0.63, 0.81)
//              		 )));
//        	Description desc567 = new Description(new ArrayList(Arrays.asList(
//             		 Arrays.asList(0.55, 0.63),
//             		 Arrays.asList(0.62, 0.72),
//             		Arrays.asList(-0.06, 0.02),
//             		Arrays.asList(0.63, 0.81)
//             		 )));
//        	Description desc568 = new Description(new ArrayList(Arrays.asList(
//             		 Arrays.asList(0.56, 0.71),
//             		 Arrays.asList(0.62, 0.72),
//             		Arrays.asList(-0.06, 0.12),
//             		Arrays.asList(0.63, 0.66)
//             		 )));
//        	Description desc578 = new Description(new ArrayList(Arrays.asList(
//            		 Arrays.asList(0.55, 0.71),
//            		 Arrays.asList(0.62, 0.63),
//            		Arrays.asList(-0.03, 0.12),
//            		Arrays.asList(0.63, 0.81)
//            		 )));
//        	Description desc67 = new Description(new ArrayList(Arrays.asList(
//           		 Arrays.asList(0.55, 0.56),
//           		 Arrays.asList(0.62, 0.72),
//           		Arrays.asList(-0.06, -0.03),
//           		Arrays.asList(0.64, 0.81)
//           		 )));
        	Description desc5 = new Description(new ArrayList(Arrays.asList(
              		 Arrays.asList(0.63, 0.63),
              		 Arrays.asList(0.63, 0.63),
              		Arrays.asList(0.02, 0.02),
              		Arrays.asList(0.63, 0.63)
              		 )));
        	Description desc6 = new Description(new ArrayList(Arrays.asList(
             		 Arrays.asList(0.56, 0.56),
             		 Arrays.asList(0.72, 0.72),
             		Arrays.asList(-0.06, -0.06),
             		Arrays.asList(0.64, 0.64)
             		 )));
        	Description desc7 = new Description(new ArrayList(Arrays.asList(
            		 Arrays.asList(0.55, 0.55),
            		 Arrays.asList(0.62, 0.62),
            		Arrays.asList(-0.03, -0.03),
            		Arrays.asList(0.81, 0.81)
            		 )));
        	Description desc8 = new Description(new ArrayList(Arrays.asList(
            		 Arrays.asList(0.71, 0.71),
            		 Arrays.asList(0.62, 0.62),
            		Arrays.asList(0.12, 0.12),
            		Arrays.asList(0.66, 0.66)
            		 )));
        	ps.AddIntent(desc5, 0);
        	ps.AddIntent(desc6, 0);
        	ps.AddIntent(desc7, 0);
        	ps.AddIntent(desc8, 0);
        	ps.printLattice();
			
		}

       
}