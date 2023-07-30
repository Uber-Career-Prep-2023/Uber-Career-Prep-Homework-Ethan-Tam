package hw.Assignment4;
// Time Complexity: logN
// Space Complexity: N

import java.util.PriorityQueue;
import java.util.Arrays;
public class AdoptAPet {
    public static void main(String[] args) {
        AdoptAPet a = new AdoptAPet();
        a.shelterRequest(new Person("Ethan", "cat"));
        a.shelterRequest(new Pet("Sadie", "dog", 4));
        a.shelterRequest(new Pet("Woof", "cat", 7));
        a.shelterRequest(new Pet("Chirpy", "dog", 2));
        a.shelterRequest(new Pet("Lola", "dog", 1));
        a.shelterRequest(new Person("Bob", "dog"));
        a.shelterRequest(new Pet("Floofy", "cat", 1));
        a.shelterRequest(new Person("Sally", "cat"));
        a.shelterRequest(new Person("Ji", "cat"));
        a.shelterRequest(new Person("Ali", "cat"));
    }
    public static class Pet {
        String name;
        String species;
        int time;
        public Pet(String name, String species, int time) {
            this.name = name;
            this.species = species;
            this.time = time;
        }
    }

    public static class Person {
        String name;
        String species;
        
        public Person(String name, String species) {
            this.name = name;
            this.species = species;
        }
    }

    PriorityQueue<Pet> dogs = new PriorityQueue<>((a, b) -> b.time - a.time);
    PriorityQueue<Pet> cats = new PriorityQueue<>((a, b) -> b.time - a.time);

    public void shelterRequest(Object o) {
        if (o instanceof Pet) {
            // cast o to Pet first!
            Pet pet = (Pet) o;
            if (pet.species.equals("dog")) {
                dogs.add(pet);
            } else if (pet.species.equals("cat")) {
                cats.add(pet);
            }
        } else if (o instanceof Person) {
            // cast o to Person first!
            Person person = (Person) o;
            if (dogs.size() == 0 && cats.size() == 0) {
                System.out.println("Hi " + person.name + ", there are no pets for adoption. Everyone has a home :)");
                return;
            }
            if (person.species.equals("dog") && dogs.size() > 0 || person.species.equals("cat") && cats.size() == 0) {
                Pet dog = dogs.poll();
                String[] output = {dog.name, dog.species};
                System.out.println(Arrays.toString(output));
            }

            if (person.species.equals("cat") && cats.size() > 0 || person.species.equals("dog") && dogs.size() == 0) {
                Pet cat = cats.poll();
                String[] output = {cat.name, cat.species};
                System.out.println(Arrays.toString(output));
            }
        }
    }
}
