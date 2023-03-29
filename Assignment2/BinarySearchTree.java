public class BinarySearchTree {
    public static void main(String[] args) {
        
    }

    public Node root;
    public BinarySearchTree() {
        this.root = null;
    }

    public static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }
    }

    public int min() {
        Node p = root;

        while(p.left != null) {
            p = p.left;
        }

        return p.num;
    }

    public int max() {
        Node p = root;
        
        while(p.right != null) {
            p = p.right;
        }

        return p.num;
    }

    public boolean contains(int val) {
        return containsHelper(val, root);
    }

    public boolean containsHelper(int val, Node p) {
        boolean result = false;
        if (p == null) {
            result = false;
        } else if (p.num == val) {
            result = true;
        } else if (p.num > val) {
            result = containsHelper(val, p.left);
        } else if (p.num < val) {
            result = containsHelper(val, p.right);
        }
        return result;
    }

    public void insert(int val) {
        insertHelper(val, root);
    }

    public void insertHelper(int val, Node p) {
        if (p == null) {
            p = new Node(val);
        } else if (p.num > val) {
            insertHelper(val, p.left);
        } else if (p.num < val) {
            insertHelper(val, p.right);
        }
    }
}
