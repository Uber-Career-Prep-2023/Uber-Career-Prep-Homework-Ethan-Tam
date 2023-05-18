// Queue
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstKBinary {

    public static void main(String[] args) {
        FirstKBinary f = new FirstKBinary();
        System.out.println(f.addResults(0));
        System.out.println(f.addResults(1));
        System.out.println(f.addResults(5));
        System.out.println(f.addResults(10));
        System.out.println(f.addResults(20));
    }

    public ArrayList<String> addResults(int k) {
        ArrayList<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        if (k == 0) {
            return result;
        }
        result.add("0");
        q.add("1");
        for (int i = 0; i < k - 1; i++) {
            String s = q.poll();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return result;
    }
}

// I finished this problem in 40 minutes.
