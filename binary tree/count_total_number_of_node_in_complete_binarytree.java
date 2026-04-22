

// complete binary tree==All levels are completely filled, except possibly the last level.
//                     ==The last level nodes are filled from left to right.


//  this is most optimal solution by use of formula 
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}


public class count_total_number_of_node_in_complete_binarytree {
    public static void main(String[] args) {                          
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
                                                                //   time complexity==O((logn)^2)
                                                                // space complexity==O(logn)
        int result=countNodes(root);
        System.out.println("total node is "+result);

    }

    static int countNodes(TreeNode root) {
    if (root == null) return 0;

    int leftHeight = leftHeight(root);
    int rightHeight = rightHeight(root);

    if (leftHeight == rightHeight) {
        return (1 << leftHeight) - 1;   // perfect tree
    }

    return 1 + countNodes(root.left) + countNodes(root.right);
}

static int leftHeight(TreeNode node) {
    int height = 0;
    while (node != null) {
        height++;
        node = node.left;
    }
    return height;
}

static int rightHeight(TreeNode node) {
    int height = 0;
    while (node != null) {
        height++;
        node = node.right;
    }
    return height;
}

}
