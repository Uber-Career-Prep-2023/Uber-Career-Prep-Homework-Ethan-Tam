import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {
    public ArrayList<Pair> edges;

    public AdjacencyList() {
        this.edges = new ArrayList<>();
    }

    public static void main(String[] args) {

        System.out.println("adjacency list test case");
        // adjacency list test case
        AdjacencyList a = new AdjacencyList();
        a.edges.add(new Pair(1,2));
        a.edges.add(new Pair(2,3));
        a.edges.add(new Pair(1,3));
        a.edges.add(new Pair(3,2));
        a.edges.add(new Pair(2,0));

        Map<Integer, Set<Integer>> m = a.adjacencySet(a.edges);

        for (int i : m.keySet()) {
            System.out.println(i + " : " + m.get(i).toString());
        }

        AdjacencyList b = new AdjacencyList();
        b.edges.add(new Pair(0,1));
        b.edges.add(new Pair(0,3));
        b.edges.add(new Pair(1,0));
        b.edges.add(new Pair(1,2));
        b.edges.add(new Pair(2,1));
        b.edges.add(new Pair(2,3));
        b.edges.add(new Pair(3,0));
        b.edges.add(new Pair(3,2));

        Map<Integer, Set<Integer>> m1 = b.adjacencySet(b.edges);
        for (int i : m1.keySet()) {
            System.out.println(i + " : " + m1.get(i).toString());
        }

        // bfs test case
        System.out.println(" ");
        System.out.println("bfs test case");
        System.out.println(b.bfs(2, m1));
        System.out.println(b.bfs(4, m1));
        System.out.println(" ");

        // dfs test case
        AdjacencyList b1 = new AdjacencyList();
        b1.edges.add(new Pair(0,1));
        b1.edges.add(new Pair(0,2));
        b1.edges.add(new Pair(0,3));
        b1.edges.add(new Pair(1,0));
        b1.edges.add(new Pair(1,2));
        b1.edges.add(new Pair(2, 0));
        b1.edges.add(new Pair(2,1));
        b1.edges.add(new Pair(2,4));
        b1.edges.add(new Pair(3,0));
        b1.edges.add(new Pair(4,2));

        Map<Integer, Set<Integer>> m3 = b1.adjacencySet(b1.edges);
        for (int i : m3.keySet()) {
            System.out.println(i + " : " + m3.get(i).toString());
        }
        System.out.println(" ");
        System.out.println("dfs test case");
        System.out.println(b1.dfs(2, m3));
        System.out.println(b1.dfs(5, m3));


        // topological sort test case from GeeksforGeeks
        System.out.println(" ");
        System.out.println("topological sort test case");
        AdjacencyList c = new AdjacencyList();
        c.edges.add(new Pair(2,3));
        c.edges.add(new Pair(3,1));
        c.edges.add(new Pair(4,0));
        c.edges.add(new Pair(4,1));
        c.edges.add(new Pair(5,2));
        c.edges.add(new Pair(5,0));

        Map<Integer, Set<Integer>> m2 = c.adjacencySet(c.edges);
        for (int i : m2.keySet()) {
            System.out.println(i + " : " + m2.get(i).toString());
        }
        
        System.out.println("Sorted order: " + c.topologicalSort(m2));
        
    }

    public static class Pair {
        private final int key;
        private final int value;
    
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    
        public int getKey() {
            return this.key;
        }
    
        public int getValue() {
            return this.value;
        }
    }

    // returns the adjacency list representation of an unweighted, undirected graph's edges
    /* 
     * 
    Input: [(1, 2), (2, 3), (1, 3), (3, 2), (2, 0)]
    Output:
    {
        0: []
        1: [2, 3]
        2: [0, 3]
        3: [2]
    }
     */
    public Map<Integer, Set<Integer>> adjacencySet(ArrayList<Pair> edges) {
        Map<Integer, Set<Integer>> m = new HashMap<>();
        for (Pair p : edges) {
            int node1 = p.getKey();
            int node2 = p.getValue();
            if (!m.containsKey(node1)) {
                m.put(node1, new HashSet<>());
            }
            if (!m.containsKey(node2)) {
                m.put(node2, new HashSet<>());
            }
            m.get(node1).add(node2);
        }
        return m;
    }

    // search for target node using breadth-first-search
    // return true if target node exists, false if not
    public boolean bfs(int target, Map<Integer, Set<Integer>> graph) {
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> visited = new ArrayList<>();
        int firstKey = (Integer) graph.keySet().toArray()[0];
        q.add(firstKey);

        while (q.size() > 0) {
            int popFirst = q.poll();
            if (popFirst == target) {
                return true;
            }
            if (!visited.contains(popFirst)) {
                visited.add(popFirst);
            }
            
            Set<Integer> s = graph.get(popFirst);
            for (int i : s) {
                if (!visited.contains(i)) {
                    q.add(i);
                }
            }
        }
        System.out.println("Visited order: " + visited);
        return false;
    }

    // search for target node using depth-first-search
    // return true if target node exists, false if not
    // tie-breaking methodology is by greatest to least
    public boolean dfs(int target, Map<Integer, Set<Integer>> graph) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> visited = new ArrayList<>();
        int firstKey = (Integer) graph.keySet().toArray()[0];
        s.push(firstKey);

        while (s.size() > 0) {
            int popLast = s.pop();
            if (popLast == target) {
                return true;
            }
            if (!visited.contains(popLast)) {
                visited.add(popLast);
            }
            
            // if tie-breaking methodology was by least to greatest, simply reverse this set
            Set<Integer> val = graph.get(popLast);
            for (int i : val) {
                if (!visited.contains(i)) {
                    s.push(i);
                }
            }
        }
        System.out.println("Visited order: " + visited);
        return false;
    }

    // returns topological sort of a graph
    public ArrayList<Integer> topologicalSort(Map<Integer, Set<Integer>> graph) {
        ArrayList<Integer> visited = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> sorted = new ArrayList<>();

        for (int i : graph.keySet()) {
            if (!visited.contains(i)) {
                topologicalSortHelper(i, visited, s, graph);
                System.out.println(s.toString());
            }
        }

        while (!s.empty()) {
            sorted.add(s.pop());
        }
        return sorted;
    }


    public void topologicalSortHelper(int v, ArrayList<Integer> visited, Stack<Integer> s, Map<Integer, Set<Integer>> graph) {
        visited.add(v);
        for (int i: graph.get(v)) {
            if (!visited.contains(i)) {
                topologicalSortHelper(i, visited, s, graph);
            }
        }
        s.push(v);
    }



}