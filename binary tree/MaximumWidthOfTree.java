import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidthOfTree {

    public static void main(String[] args) {
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

        int ans = maxWidth(root);
        System.out.println("The maximum width of tree is " + ans);
    }

    static int maxWidth(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;

            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                TreeNode node = curr.node;
                int index = curr.index - minIndex;

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}