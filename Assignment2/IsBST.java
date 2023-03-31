public class IsBST extends BinarySearchTree {
    public static void main(String[] args) {
        Node a = new Node(10);
        a.left = new Node(8);
        a.right = new Node(16);
        a.left.right = new Node(9);
        a.right.left = new Node(13);
        a.right.right = new Node(17);
        a.right.right.right = new Node(20);


        Node b = new Node(10);
        b.left = new Node(8);
        b.right = new Node(16);
        b.left.right = new Node(9);
        b.right.left = new Node(13);
        b.right.right = new Node(17);
        b.right.right.right = new Node(15);

        System.out.println(isBST(a));
        System.out.println(isBST(b));
    }

    public IsBST() {
        super();
    }

    public static boolean isBST(Node n) {
        return isBSTHelper(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTHelper(Node n, int min, int max) {
        if (n == null) {
            return true;
        } else if (n.num < min || n.num > max) {
            return false;
        } else {
            return isBSTHelper(n.left, min, n.num) && isBSTHelper(n.right, n.num, max);
        }
    }
}