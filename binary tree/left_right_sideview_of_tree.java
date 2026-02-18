import java.util.*;

class nodeposition {
    TreeNode node;
    int row;

    nodeposition(TreeNode node, int row) {
        this.node = node;
        this.row = row;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}

public class left_right_sideview_of_tree {
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
        root.right.right.right = new TreeNode(7);

        ArrayList<Integer> result = funct(root);
        ArrayList<Integer> result2 = funct2(root);
        ArrayList<Integer> result3 = new ArrayList<>();
        leftViewHelper(root, 0, result3);
        ArrayList<Integer> result4 = new ArrayList<>();
        rightViewHelper(root, 0, result4);

        System.out.println("the left view of the tree is " + result);
        System.out.println("the right view of the tree is " + result2);
        System.out.println("the left view of the tree by using recursive methed is " + result3);
        System.out.println("the right view of the tree by using recursive methed is " + result4);

    }

    public static ArrayList<Integer> funct(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<nodeposition> q = new LinkedList<>();
        q.add(new nodeposition(root, 0));

        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!q.isEmpty()) {
            nodeposition nod = q.poll();
            int row = nod.row;
            TreeNode val = nod.node;

            if (!map.containsKey(row))
                map.put(row, val.value);
            if (val.left != null)
                q.add(new nodeposition(val.left, row + 1));
            if (val.right != null)
                q.add(new nodeposition(val.right, row + 1));
        }

        for (Integer val : map.values()) {
            result.add(val);
        }

        return result;
    }

    public static ArrayList<Integer> funct2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<nodeposition> q = new LinkedList<>();
        q.add(new nodeposition(root, 0));

        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!q.isEmpty()) {
            nodeposition nod = q.poll();
            int row = nod.row;
            TreeNode val = nod.node;

            if (!map.containsKey(row))
                map.put(row, val.value);

            if (val.right != null)
                q.add(new nodeposition(val.right, row + 1));
            if (val.left != null)
                q.add(new nodeposition(val.left, row + 1));
        }

        for (Integer val : map.values()) {
            result.add(val);
        }

        return result;
    }

    private static void rightViewHelper(TreeNode node, int level, ArrayList<Integer> result) {
        if (node == null)
            return;

        if (level == result.size()) {
            result.add(node.value);
        }

        rightViewHelper(node.right, level + 1, result);
        rightViewHelper(node.left, level + 1, result);
    }

    private static void leftViewHelper(TreeNode node, int level, ArrayList<Integer> result) {
        if (node == null)
            return;

        if (level == result.size()) {
            result.add(node.value);
        }
        
        leftViewHelper(node.left, level + 1, result);
        leftViewHelper(node.right, level + 1, result);
    }
}
