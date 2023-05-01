// Level-Order Search

// Time Complexity: N^2
// Space Complexity: N

import java.util.ArrayList;

public class LeftView extends BinarySearchTree {
    
    public LeftView() {
        super();
    }

    public ArrayList<Integer> allLeft() {
        ArrayList<Integer> temp = new ArrayList<>();
        return allLeftHelper(temp);
    }

    public ArrayList<Integer> allLeftHelper(ArrayList<Integer> temp) {
        
        for (int i = 1; i < height(this.root) + 1; i++) {
            ArrayList<Integer> t = new ArrayList<>();
            getCurrentLevel(this.root, i, t);
            temp.add(t.get(0));
        }
    
        return temp;
    }

    public void getCurrentLevel(Node n, int level, ArrayList<Integer> temp) {
        if (level == 1 && n != null) {
            temp.add(n.num);
        } else {
            getCurrentLevel(n.left, level - 1, temp);
            getCurrentLevel(n.right, level - 1, temp);
        }
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight >= rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

}
