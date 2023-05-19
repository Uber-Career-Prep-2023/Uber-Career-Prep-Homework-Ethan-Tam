// Stack
// Time Complexity: O(N)
// Space Complexity: O(N)

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        System.out.println(r.reverse("Uber Career Prep"));
        System.out.println(r.reverse("Emma lives in Brooklyn, New York."));
    }
    public String reverse(String s) {
        String total = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            temp += c;
            // if this is the last word
            if (i == s.length() - 1) {
                temp += " ";
                total = temp + total;
            }
            // if we've reached the end of a word
            if (c == ' ') {
                total = temp + total;
                temp = "";
            }
        }
        return total;
    }
}

// I spent 20 minutes on this problem.
