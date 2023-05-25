// Adjacency List, Queue, BFS
// Time Complexity: O(E)
// Space Complexity: O(E)

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class VacationDestinations {

    public static void main(String[] args) {
        ArrayList<Pair> edges = new ArrayList<>();
        edges.add(new Pair("Boston", "New York", 4.0));
        edges.add(new Pair("New York", "Philadelphia", 2.0));
        edges.add(new Pair("Boston", "Newport", 1.5));
        edges.add(new Pair("Washington, D.C.", "Harper's Ferry", 1.0));
        edges.add(new Pair("Boston", "Portland", 2.5));
        edges.add(new Pair("Philadelphia", "Washington, D.C.", 2.5));

        VacationDestinations v = new VacationDestinations();
        System.out.println(v.findDestinations("New York", 5.0, edges));
        System.out.println(v.findDestinations("New York", 7.0, edges));
        System.out.println(v.findDestinations("New York", 8.0, edges));
    }

    public static class Pair {
        String origin;
        String destination;
        double travelTime;
        public Pair(String origin, String destination, double travelTime) {
            this.origin = origin;
            this.destination = destination;
            this.travelTime = travelTime;
        }
    }

    public static class Edge {
        String city;
        double travelTime;
        double k;
        public Edge(String city, double travelTime, double k) {
            this.city = city;
            this.travelTime = travelTime;
            this.k = k;
        }
    }

    public int findDestinations(String start, double k, ArrayList<Pair> edges) {
        // make adjacency list and visited map
        Map<String, ArrayList<Edge>> m = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        ArrayList<String> test = new ArrayList<>();

        // since this graph is undirected, map both the origin and destination in each edge to each other
        for (Pair p : edges) {
            if (!m.containsKey(p.origin)) {
                m.put(p.origin, new ArrayList<>());
            }
            if (!m.containsKey(p.destination)) {
                m.put(p.destination, new ArrayList<>());
            }
            m.get(p.origin).add(new Edge(p.destination, p.travelTime, k));
            m.get(p.destination).add(new Edge(p.origin, p.travelTime, k));
            visited.put(p.origin, false);
            visited.put(p.destination, false);
        }

        // start queue
        Queue<Edge> q = new LinkedList<>();
        for (Edge e : m.get(start)) {
            q.offer(e);
        }
        int count = 0;
        visited.put(start, true);
        
        // once queue is empty, there are no more possible cities to consider
        while (!q.isEmpty()) {
            Edge curr = q.poll();
            // if it is possible to travel to this city, then it is valid 
            // AND check where that city leads to for additional possible cities
            if (curr.k - curr.travelTime >= 0 && !visited.get(curr.city)) {
                visited.put(curr.city, true);
                count += 1;
                test.add(curr.city);
                // insert the city with its travelTime and updated k into the queue
                for (Edge e : m.get(curr.city)) {
                    q.offer(new Edge(e.city, e.travelTime, curr.k - curr.travelTime - 1));
                }
            }
            System.out.println(test);
        }
        return count;
    }
}

// I spent 40 minutes on this problem.
