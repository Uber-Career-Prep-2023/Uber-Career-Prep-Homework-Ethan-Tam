import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> arr;
    private int size;

    public Heap() {
        arr = new ArrayList<>();
        // filler for first element of backing array
        this.insert(Integer.MAX_VALUE);
        this.size = 0;
    }

    public ArrayList<Integer> getArr() {
        return arr;
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(5);
        h.insert(3);
        h.insert(8);
        h.insert(2);
        h.insert(9);

        System.out.println("Smallest element: " + h.top());
        System.out.println("Heapified array after insertions: " + h.arr);
        h.remove();
        System.out.println( "Heapified array after deleting smallest element: " + h.arr);
        System.out.println("Smallest element: " + h.top());

        Heap h1 = new Heap();
        h1.insert(1);
        h1.insert(2);
        h1.insert(3);
        h1.insert(4);
        h1.insert(5);

        h1.insert(1);
        h1.insert(3);
        h1.insert(5);
        h1.insert(7);
        h1.insert(9);
        

        System.out.println("Smallest element: " + h1.top());
        System.out.println("Heapified array after insertions: " + h1.arr);
        h1.remove();
        System.out.println( "Heapified array after deleting smallest element: " + h1.arr);
        System.out.println("Smallest element: " + h1.top());


        Heap h2 = new Heap();
        h2.insert(12);
        h2.insert(13);
        h2.insert(13);
        h2.insert(15);
        h2.insert(16);
    
    
        System.out.println("Smallest element: " + h2.top());
        System.out.println("Heapified array after insertions: " + h2.arr);
        h2.remove();
        System.out.println( "Heapified array after deleting smallest element: " + h2.arr);
        System.out.println("Smallest element: " + h2.top());

    }

    public int top() {
        try {
            return arr.get(1);
        } catch (Exception e) {
            System.out.println("There are no elements in the heap.");
            return -1;
        }
    }

    public void insert(int x) {
        size += 1;
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
        size -= 1;
        // swap top element with last element
        int temp = arr.get(arr.size() - 1);
        arr.set(arr.size() - 1, arr.get(1));
        arr.set(1, temp);

        // remove last element (previous top element)
        arr.remove(arr.size() - 1);

        // heapify
        int leftIndex = 2;
        int rightIndex = 3;
        int left = 0;
        int right = 0;
        
        if (arr.size() > 2) {
            left = arr.get(leftIndex);
        } else {
            left = Integer.MAX_VALUE;
        }

        if (arr.size() > 3) {
            right = arr.get(rightIndex);
        } else {
            right = Integer.MAX_VALUE;
        }
        int xIndex = 1;
        int x = 0;

        if (arr.size() > 1) {
            x = arr.get(xIndex);
        }
        int chosenIndex = 0;
        int chosen = 0;
    
        while (chosen < x && chosenIndex < arr.size() - 1 && (left != Integer.MAX_VALUE || right != Integer.MAX_VALUE)) {
            // System.out.println("chosen: " + chosen);
            // System.out.println("chosenIndex: " + chosenIndex);
            // System.out.println("x: " + x);
            // System.out.println("xIndex: " + xIndex);
            // System.out.println("left: " + left);
            // System.out.println("leftIndex: " + leftIndex);
            // System.out.println("right: " + right);
            // System.out.println("rightIndex: " + rightIndex);
            // System.out.println(arr);
            // System.out.println("");

            if (left > x && right > x) {
                break;
            }

            if (left < right) {
                chosenIndex = leftIndex;
                chosen = left;
            } else {
                chosenIndex = rightIndex;
                chosen = right;
            }
            arr.set(chosenIndex, x);
            arr.set(xIndex, chosen);
            xIndex = chosenIndex;
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

    public int getSize() {
        return size;
    }
}