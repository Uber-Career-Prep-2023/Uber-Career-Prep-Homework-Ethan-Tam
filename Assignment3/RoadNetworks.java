// Adjacency List
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class RoadNetworks {
    Map<String, ArrayList<String>> aL;
    Map<String, Boolean> visited;
    ArrayList<ArrayList<String>> groups;
    

    public static class Pair {
        private final String key;
        private final String value;
        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return this.key;
        }
        public String getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> towns = new ArrayList<>();
        ArrayList<Pair> roads = new ArrayList<>();
        towns.add("Kona");
        towns.add("Hilo");
        towns.add("Volcano");
        towns.add("Lahaina");
        towns.add("Hana");
        towns.add("Haiku");
        towns.add("Kahului");
        towns.add("Princeville");
        towns.add("Lihue");
        towns.add("Waimea");

        roads.add(new Pair("Kona", "Volcano"));
        roads.add(new Pair("Volcano", "Hilo"));
        roads.add(new Pair("Lahaina", "Hana"));
        roads.add(new Pair("Kahului", "Haiku"));
        roads.add(new Pair("Hana", "Haiku"));
        roads.add(new Pair("Kahului", "Lahaina"));
        roads.add(new Pair("Princeville", "Lihue"));
        roads.add(new Pair("Lihue", "Waimea"));

        RoadNetworks r = new RoadNetworks(towns, roads);

        System.out.println("");
        System.out.println("adajcency list");
        r.printAL();
        System.out.println("");
        System.out.println("Total Networks: " + r.totalNetworks());
        System.out.println("");
        System.out.println("visited");
        r.printVisited();
        System.out.println("");
        System.out.println("groups: " + r.groups);
    }

    public RoadNetworks(ArrayList<String> towns, ArrayList<Pair> roads) {
        this.aL = new HashMap<>();
        this.visited = new HashMap<>();
        this.groups = new ArrayList<>();

        // instantiate visited map
        for (String t : towns) {
            visited.put(t, false);
        }

        // instantiate adjacency list
        for (Pair p : roads) {
            String key = p.getKey();
            String value = p.getValue();
            if (!aL.containsKey(key)) {
                aL.put(key, new ArrayList<>());
            }
            aL.get(key).add(value);
        }
    }


    public int totalNetworks() {
        int count = 0;
        for (String s : aL.keySet()) {
            if (!visited.get(s)) {
                ArrayList<String> group = new ArrayList<>();
                visited.put(s, true);
                if (allChildrenVisited(s)) {
                    continue;
                }
                findConnections(s, group);
                groups.add(group);
                count += 1;
            }
        }
        return count;
    }

    public void findConnections(String s, ArrayList<String> group) {
       visited.put(s, true);
       group.add(s);
       if (aL.containsKey(s)) {
            for (String t : aL.get(s)) {
                if (!visited.get(t)) {
                    findConnections(t, group);
                }
            }
        }
    }

    public void printAL() {
        for (String key : aL.keySet()) {
            System.out.println(key + ":" + aL.get(key));
        }
    }

    public void printVisited() {
        for (String key: visited.keySet()) {
            System.out.println(key + ": " + visited.get(key));
        }
    }

    public boolean allChildrenVisited(String key) {
        for (String s : aL.get(key)) {
            if (!visited.get(s)) {
                return false;
            }
        }
        return true;
    }
}

// I spent 40 minutes on this problem.