// Time Complexity: (k*m) where k = number of char in t
// Space Complexity: (n*m) where n = number of words in dictionary and m = average length of a word in the dictionary

package hw.Assignment4;
import java.util.Queue;
import java.util.LinkedList;

public class WordBreak extends Trie{
    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String[] dictionary = {"Elf", "Go", "Golf", "Man", "Manatee", "Not", "Note", "Pig", "Quip", "Tee", "Teen"};
        System.out.println(w.isWordBreaker(dictionary, "mangolf"));
        System.out.println(w.isWordBreaker(dictionary, "manateenotelf"));
        System.out.println(w.isWordBreaker(dictionary, "quipig"));
    }
    public boolean isWordBreaker(String[] dictionary, String t) {
        for (String s : dictionary) {
            s = s.toLowerCase();
            this.insert(s);
        }
        boolean check = false;
        Queue<int[]> q = new LinkedList<>();
        int[] indexes = {0,1};
        q.add(indexes);

        while (!q.isEmpty()) {
            int[] head = q.poll();
            String subword = t.substring(head[0], head[1]);
            if (this.isValidWord(subword)) {
                // successfully word
                if (head[1] == t.length() ) {
                    check = true;
                    break;
                }
                int[] newIndexes = {head[1], head[1] + 1};
                q.add(newIndexes);
                int[] sameIndexes = {head[0], head[1] + 1};
                q.add(sameIndexes);
            } else {
                if (head[1] != t.length()) {
                    int[] newIndexes = {head[0], head[1] + 1};
                    q.add(newIndexes);
                }
            }
        }
        return check;
    }
}
// I spent 40 minutes on this problem.