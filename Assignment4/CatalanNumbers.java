package hw.Assignment4;

// Time Complexity: O(N^2)
// Space Complexity: O(1)
public class CatalanNumbers {
    public static void main(String[] args) {
        printCatalan(5);
    }
    public static long catalan(int n) {
        if (n == 0) {
            return 1;
        }

        long catalan = 1;
        for (int i = 1; i <= n; i++) {
            catalan = catalan * (2 * (2 * i - 1)) / (i + 1);
        }
        return catalan;
    }

    public static void printCatalan(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(catalan(i) + " ");
        }
    }

}
// I spent 40 minutes on this problem.