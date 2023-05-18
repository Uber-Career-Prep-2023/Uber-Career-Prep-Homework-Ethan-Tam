// Graph : Breadth First Search
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.Arrays;

public class NumberOfIslands {
    int[][] arr;
    boolean[][] visited;
    int count;
    boolean foundOne;

    public NumberOfIslands(int arr[][]) {
        this.arr = arr;
        this.visited = new boolean[arr.length][arr[0].length];
        this.count = 0;
        this.foundOne = false;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,0,1,1,1}, {1,1,0,1,1}, {0,1,0,0,0}, {0,0,0,1,0}, {0,0,0,0,0}};
        int[][] arr2 = {{1,0,0}, {0,0,0}};
        NumberOfIslands n1 = new NumberOfIslands(arr1);
        NumberOfIslands n2 = new NumberOfIslands(arr2);
        System.out.println(n1.numIslands());
        System.out.println(n2.numIslands());
    }

    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

    public int numIslands() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                // only search unvisited nodes
                if (!visited[i][j]) {
                    search(i, j);
                    if (foundOne) {
                        count += 1;
                        foundOne = false;
                    }
                }
            }
        }
        return count;
    }

    
    public void search(int row, int column) {
        // only recurse if the index is a 1 and has not yet been visited
        if (arr[row][column] == 1 && !visited[row][column]) {
            visited[row][column] = true;

            // up
            if (row - 1 >= 0) {
                search(row - 1 , column);
            }

            // down
            if (row + 1 < arr.length) {
                search(row + 1, column);
            }

             // left
            if (column - 1 >= 0) {
                search(row, column - 1);
            }

            // right
            if (column + 1 < arr[0].length) {
                search(row, column + 1);
            }

            foundOne = true;
        }
    }
}

// I finished this problem in 30 minutes.