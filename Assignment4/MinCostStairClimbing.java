package hw.Assignment4;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinCostStairClimbing {
    public static void main(String[] args) {
        int[] a = {4, 1, 6, 3, 5, 8};
        int[] b = {11, 8, 3, 4, 9, 13, 10};

        MinCostStairClimbing m = new MinCostStairClimbing();
        System.out.println(m.findMinCost(a));
        System.out.println(m.findMinCost(b));
    }
    public static class Toll {
        int fee;
        int index;
        public Toll(int fee, int index) {
            this.fee = fee;
            this.index = index;
        }
    }

    public int findMinCost(int[] steps) {
        Queue<Toll> q = new LinkedList<>();
        PriorityQueue<Integer> allCosts = new PriorityQueue<>();
        q.add(new Toll(steps[0], 0));
        q.add(new Toll(steps[1], 1));

        while (!q.isEmpty()) {
            Toll t = q.poll();

            // take one step
            if (t.index + 1 < steps.length) {
                Toll oneStep = new Toll(t.fee + steps[t.index+1], t.index + 1);
                q.add(oneStep);
            }

            // take two steps
            if (t.index + 2 < steps.length) {
                Toll twoStep = new Toll(t.fee + steps[t.index+2], t.index + 2);
                q.add(twoStep);
            }

            // if at last step or second-to-last step
            if (t.index == steps.length - 2 || t.index == steps.length - 1) {
                allCosts.add(t.fee);
            }
        }
        return allCosts.poll();
    }

}
