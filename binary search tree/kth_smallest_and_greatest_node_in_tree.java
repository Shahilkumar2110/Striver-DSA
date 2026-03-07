import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class kth_smallest_and_greatest_node_in_tree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(10);
        root.right = new TreeNode(55);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(53);
        root.right.right = new TreeNode(60);

        TreeNode root2 = new TreeNode(50);
        root2.left = new TreeNode(10);
        root2.right = new TreeNode(55);
        root2.left.left = new TreeNode(9);
        root2.left.right = new TreeNode(40);
        root2.right.left = new TreeNode(53);
        root2.right.right = new TreeNode(60);

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int num2 = kthLargest(root, k);
        int num1 = kthSmallest(root2, k);

        System.out.println("The " + k + "th smallest number is " + num1);
        System.out.println("The " + k + "th greatest number is " + num2);
    }

    // Morris Inorder Traversal
    static int kthSmallest(TreeNode root, int k) {

        TreeNode curr = root;
        int count = 0;

        while (curr != null) {

            if (curr.left == null) {

                count++;
                if (count == k)
                    return curr.value;

                curr = curr.right;
            } else {

                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;

                    count++;
                    if (count == k)
                        return curr.value;

                    curr = curr.right;
                }
            }
        }

        return -1;
    }

    // Reverse Morris Traversal
    static int kthLargest(TreeNode root, int k) {

        TreeNode curr = root;
        int count = 0;

        while (curr != null) {

            if (curr.right == null) {

                count++;
                if (count == k)
                    return curr.value;

                curr = curr.left;
            } else {

                TreeNode succ = curr.right;

                while (succ.left != null && succ.left != curr) {
                    succ = succ.left;
                }

                if (succ.left == null) {
                    succ.left = curr;
                    curr = curr.right;
                } else {
                    succ.left = null;

                    count++;
                    if (count == k)
                        return curr.value;

                    curr = curr.left;
                }
            }
        }

        return -1;
    }
}