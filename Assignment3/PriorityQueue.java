import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Pair> arr;

    public PriorityQueue() {
        arr = new ArrayList<>();
        // filler for first element of backing array
        this.insert("start", Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert("a", 5);
        pq.insert("b", 3);
        pq.insert("c", 8);
        pq.insert("d", 2);
        pq.insert("e", 9);

        System.out.println("Smallest element: " + pq.top());
        System.out.println("Heapified array after insertions: " + pq.printArr());
        pq.remove();
        System.out.println( "Heapified array after deleting smallest element: " + pq.printArr());
        System.out.println("Smallest element: " + pq.top());
    }

    public static class Pair {
        private final String key;
        private final int value;
    
        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    
        public String getKey() {
            return this.key;
        }
    
        public int getValue() {
            return this.value;
        }
    }

    public int top() {
        return arr.get(1).getValue();
    }

    public void insert(String x, int weight) {
        arr.add(new Pair(x, weight));
        
        int xIndex = arr.size() - 1;

        int parentIndex = xIndex / 2;
        Pair parent = arr.get(parentIndex);

        // keep swapping until the parent is less than or equal to x
        while (parent.getValue() > weight && parent.getValue() != Integer.MAX_VALUE) {
            arr.set(parentIndex, new Pair(x, weight));
            arr.set(xIndex, parent);
            xIndex = parentIndex;
            parentIndex = xIndex / 2;
            parent = arr.get(parentIndex);
        }
    }

    public void remove() {
        // swap top element with last element
        Pair temp = arr.get(arr.size() - 1);
        arr.set(arr.size() - 1, arr.get(1));
        arr.set(1, temp);

        // remove last element (previous top element)
        arr.remove(arr.size() - 1);

        // heapify
        int leftIndex = 2;
        Pair left = arr.get(leftIndex);
        int rightIndex = 3;
        Pair right = arr.get(rightIndex);
        int xIndex = 1;
        Pair x = arr.get(xIndex);
        int chosenIndex = 0;
        Pair chosen = new Pair("temp", Integer.MIN_VALUE);
    
        while (chosen.getValue() < x.getValue() && chosenIndex < arr.size() - 1) {
            if (left.getValue() < right.getValue()) {
                chosenIndex = leftIndex;
                chosen = left;
            } else {
                chosenIndex = rightIndex;
                chosen = right;
            }
            arr.set(chosenIndex, x);
            arr.set(xIndex, chosen);
            if (chosen == left) {
                xIndex = leftIndex;
            } else {
                xIndex = rightIndex;
            }
            leftIndex = xIndex * 2;
            rightIndex = (xIndex * 2) + 1;

            // if there is no left or right side, just set the variable 
            // to an extremely large number to make sure we don't swap with it

            if (leftIndex < arr.size()) {
                left = arr.get(leftIndex);
            } else {
                left = new Pair("temp", Integer.MAX_VALUE);
            }

            if (rightIndex < arr.size()) {
                right = arr.get(rightIndex);
            } else {
                right = new Pair("temp", Integer.MAX_VALUE);
            }
        }
    }

    public String printArr() {
        String s = "{";
        for (Pair p : arr) {
            s += "(" + p.getKey() + ", " + p.getValue() + "), ";
        }
        s = s.substring(0, s.length() - 2);
        s += "}";
        return s;
    }
}