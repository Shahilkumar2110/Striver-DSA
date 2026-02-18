import java.util.*;


//  return the boundary traversal of the tree


class node {
    int data;
    node left, right;

    node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class boundary_traversal {

    public static void main(String[] args) {

        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);

        root.left.right.left = new node(45);
        root.left.right.right= new node(55);

        root.right.left = new node(6);
        root.right.right = new node(7);

        ArrayList<Integer> result = boundaryTraversal(root);

        System.out.println("Boundary Traversal: " + result);
    }

    public static ArrayList<Integer> boundaryTraversal(node root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        result.add(root.data);

        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root.right, result);

        return result;
    }

    // 1️⃣ Left Boundary (excluding leaves)
    static void addLeftBoundary(node root, ArrayList<Integer> result) {
        while (root != null) {
            if (!isLeaf(root)) {
                result.add(root.data);
            }

            if (root.left != null)
                root = root.left;
            else
                root = root.right;
        }
    }

    // 2️⃣ Add all Leaf Nodes
    static void addLeaves(node root, ArrayList<Integer> result) {
        if (root == null) return;

        if (isLeaf(root)) {
            result.add(root.data);
            return;
        }

        addLeaves(root.left, result);
        addLeaves(root.right, result);
    }

    // 3️⃣ Right Boundary (excluding leaves, reverse order)
    static void addRightBoundary(node root, ArrayList<Integer> result) {

        Stack<Integer> stack = new Stack<>();

        while (root != null) {
            if (!isLeaf(root)) {
                stack.push(root.data);
            }

            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    static boolean isLeaf(node root) {
        return root.left == null && root.right == null;
    }
}
