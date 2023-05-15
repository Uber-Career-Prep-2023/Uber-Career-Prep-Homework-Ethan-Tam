import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import java.util.Queue;
import java.util.Stack;

public class AdjacencyList {
    public ArrayList<Pair> edges;

    public AdjacencyList() {
        this.edges = new ArrayList<>();
    }

    public static void main(String[] args) {
        AdjacencyList aL = new AdjacencyList();
        aL.edges.add(new Pair(1,2));
        aL.edges.add(new Pair(2,3));
        aL.edges.add(new Pair(1,3));
        aL.edges.add(new Pair(3,2));
        aL.edges.add(new Pair(2,0));

        Map<Integer, Set<Integer>> m = aL.adjacencySet(aL.edges);

        for (int i : m.keySet()) {
            System.out.println(i + " : " + m.get(i).toString());
        }
        
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
    // return true if target node exists, false if no
    public boolean bfs(int target, Map<Integer, Set<Integer>> graph) {
        return false;
    }

    // search for target node using depth-first-search
    // return true if target node exists, false if no
    public boolean dfs(int target, Map<Integer, Set<Integer>> graph) {
        return false;
    }

    // 
    public ArrayList<Integer> topologicalSort(Map<Integer, Set<Integer>> graph) {
        return null;
    }



}