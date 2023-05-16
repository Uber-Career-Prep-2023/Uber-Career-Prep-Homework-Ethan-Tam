import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> arr;

    public Heap() {
        arr = new ArrayList<>();
        // filler for first element of backing array
        this.insert(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(5);
        h.insert(3);
        h.insert(8);
        h.insert(2);
        h.insert(9);

        System.out.println(h.arr);
        h.remove();
        System.out.println(h.arr);
    }

    public int top() {
        return arr.get(1);
    }

    public void insert(int x) {
        arr.add(x);
        
        int xIndex = arr.size() - 1;

        int parentIndex = xIndex / 2;
        int parent = arr.get(parentIndex);

        // keep swapping until the parent is less than or equal to x
        while (parent > x && parent != Integer.MAX_VALUE) {
            arr.set(parentIndex, x);
            arr.set(xIndex, parent);
            xIndex = parentIndex;
            parentIndex = xIndex / 2;
            parent = arr.get(parentIndex);
        }
    }

    public void remove() {
        // swap top element with last element
        int temp = arr.get(arr.size() - 1);
        arr.set(arr.size() - 1, arr.get(1));
        arr.set(1, temp);

        // remove last element (previous top element)
        arr.remove(arr.size() - 1);

        // heapify
        int leftIndex = 2;
        int left = arr.get(leftIndex);
        int rightIndex = 3;
        int right = arr.get(rightIndex);
        int xIndex = 1;
        int x = arr.get(xIndex);
        int chosenIndex = 0;
        int chosen = 0;
    
        while (chosen < x && chosen < arr.size()) {
            System.out.println(chosenIndex);
            if (left < right) {
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
                left = Integer.MAX_VALUE;
            }

            if (rightIndex < arr.size()) {
                right = arr.get(rightIndex);
            } else {
                right = Integer.MAX_VALUE;
            }
        }
    }
}