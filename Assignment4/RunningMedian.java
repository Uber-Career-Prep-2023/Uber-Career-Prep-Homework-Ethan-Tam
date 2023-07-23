
// Heap
// Time Complexity: NlogN (for all numbers)
// Space Complexity: N
package hw.Assignment4;
import java.util.PriorityQueue;
public class RunningMedian {

    public static void main(String[] args) {
        RunningMedian r = new RunningMedian();
        int[] numbers = {1, 11, 4, 15, 12};
        for (int num : numbers) {
            r.addNum(num);
            System.out.println(r.findMedian());
        }
    }

    private PriorityQueue<Integer> maxHeap; // smaller half of the numbers
    private PriorityQueue<Integer> minHeap; // larger half of the numbers
    
    // decide that maxHeap will always have one value greater than minHeap
    public RunningMedian() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int x) {
        // add number
        if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
            maxHeap.add(x);
        } else {
            minHeap.add(x);
        }
        // balance heap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

// I spent 40 minutes on this problem.