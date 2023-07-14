package hw.Assignment4;

// Time Complexity: O(8^k)
// Space Complexity: O(allwords.length())

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Boggle extends Trie {

    public static void main(String[] args) {
        Boggle b = new Boggle();
        ArrayList<String> dictionary = new ArrayList<>(Arrays.asList(
                "Ace", "Ape", "Cape", "Clap", "Clay", "Gape", "Grape",
                "Lace", "Lap", "Lay", "Mace", "Map", "May", "Pace", "Pay",
                "Rap", "Ray", "Tap", "Tape", "Trace", "Trap", "Tray", "Yap"
        ));
        char[][] board = {
            {'A', 'D', 'E'},
            {'R', 'C', 'P'},
            {'L', 'A', 'Y'}
        };
        System.out.println(b.validWords(dictionary, board));
    }
 

    public HashSet<String> validWords(ArrayList<String> dictionary, char[][] board) {
        // make board all lowercase
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Character.toLowerCase(board[i][j]);
            }
        }
        // make dictionary all lowercase before trie insertion
        for (String s : dictionary) {
            if (s.length() >= 3) {
                this.insert(s.toLowerCase());
            }
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        HashSet<String> output = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i,j,board,"", this.root, visited, output);
            }
        }
        return output;
    }

    public void dfs(int row, int col, char[][] board, String word, TrieNode node, boolean[][] visited, HashSet<String> output) {
        // out of board bounds
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }

        // next character is not part of any word path in trie
        if (!node.children.containsKey(board[row][col])) {
            return;
        }

        // have already visited this character on this path 
        if (visited[row][col]) {
            return;
        }
       
        word += board[row][col];
        node = node.children.get(board[row][col]);
        if (node.validWord) {
            output.add(word);
        }
        visited[row][col] = true;

        dfs(row-1, col, board, word, node, visited, output);
        dfs(row-1, col-1, board, word, node, visited, output);
        dfs(row-1, col+1, board, word, node, visited, output);
        dfs(row+1, col, board, word, node, visited, output);
        dfs(row+1, col-1, board, word, node, visited, output);
        dfs(row+1, col+1, board, word, node, visited, output);
        dfs(row, col-1, board, word, node, visited, output);
        dfs(row, col+1, board, word, node, visited, output);
        visited[row][col] = false;
    }
}

// I spent 40 minutes on this problem.