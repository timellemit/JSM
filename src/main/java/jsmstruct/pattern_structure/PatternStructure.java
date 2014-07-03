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


       
}