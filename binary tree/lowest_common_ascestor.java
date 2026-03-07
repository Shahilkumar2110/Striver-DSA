import java.util.*;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}

public class lowest_common_ascestor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(45);
        root.left.right.right = new TreeNode(55);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(25);

        System.out.println("Enter first and second node:");
        int first = sc.nextInt();
        int second = sc.nextInt();

        TreeNode lca = findLCA(root, first, second);                    //time complexity==O(n)
                                                                        //space complexity==O(n) 

        if (lca != null)
            System.out.println("Lowest Common Ancestor is: " + lca.value);
        else
            System.out.println("Node not found");
    }

    static TreeNode findLCA(TreeNode root, int first, int second) {

        if (root == null)
            return null;

        if (root.value == first || root.value == second)
            return root;

        TreeNode left = findLCA(root.left, first, second);
        TreeNode right = findLCA(root.right, first, second);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }
}