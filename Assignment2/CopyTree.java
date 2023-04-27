// Level-order (breadth-first) traversal
// Time Complexity: logN
// Space Complexity: N

public class CopyTree extends BinarySearchTree {
    public static void main(String[] args) {
        CopyTree ct = new CopyTree();
        ct.root = new Node(3);
        ct.root.left = new Node(1);
        ct.root.right = new Node(2);

        System.out.println(equals(ct.root, copy(ct.root)));
    }

    public CopyTree() {
        super();
    }

    // creates deep copy of the root and returns it
    public static Node copy(Node root) {
        if (root == null) {
            return null;
        } else {
            Node newRoot = new Node(root.num);
            newRoot.left = copy(root.left);
            newRoot.right = copy(root.right);
            return newRoot;
        }
    }

    // return true if the BST a has the same order of values as BST b; else, return false
    public static boolean equals(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null && b != null) {
            return false;
        } else if (a != null && b == null) {
            return false;
        } else if (a.num != b.num) {
            return false;
        } else {
            return equals(a.left, b.left) && equals(a.right, b.right);
        }
    }

}

// I spent 40 minutes on this problem.
