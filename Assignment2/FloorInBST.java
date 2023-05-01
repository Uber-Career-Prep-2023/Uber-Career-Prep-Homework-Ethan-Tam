// BST Search
// Time Complexity: logN
// Space Complexity: 1

public class FloorInBST extends BinarySearchTree {
    
    public FloorInBST() {
        super();
    }

    public int getFloor(int target) {
        Node prev = null;
        Node curr = this.root;

        while (curr != null) {
            if (curr.num == target) {
                return curr.num;
            } else if (curr.num < target) {
                prev = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return prev.num;
    }
}

// I spent 30 minutes on this problem.