package hw.Assignment4;
// Time Complexity: N
// Space Complexity: N

public class LargestSquareOf1s {

    public static void main(String[] args) {
        LargestSquareOf1s l = new LargestSquareOf1s();
        int[][] a = {
            {0, 1, 0, 1},
            {0, 0, 1, 1},
            {0, 1, 1, 1},
            {0, 0, 1, 1}
        };
        int[][] b = {
            {0, 1, 0, 1, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 0, 0}
        };
        System.out.println(l.findLargestSquare(a));
        System.out.println(l.findLargestSquare(b));
    }

    public int findLargestSquare(int[][] matrix) {
        int[][] dynamicMatrix = new int[matrix.length][matrix[0].length];
        int highestSide = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dynamicMatrix[i][j] = 1;
                } else {
                    if (matrix[i][j] == 1) {
                        int top = dynamicMatrix[i-1][j];
                        int left = dynamicMatrix[i][j-1];
                        int topLeft = dynamicMatrix[i-1][j-1];
                        int minVal = Math.min(top, Math.min(left, topLeft));
                        dynamicMatrix[i][j] = minVal + 1;
                    }
                }
                highestSide = Math.max(highestSide, dynamicMatrix[i][j]);
            }
        }
        return highestSide;
    }
}
// I spent 40 minutes on this problem.