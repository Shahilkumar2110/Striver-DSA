import java.util.*;

// Tree Node Definition
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

// Helper class to store node with its coordinates
class NodePosition {
    TreeNode node;
    int column;   // horizontal distance
    int row;      // level (depth)

    NodePosition(TreeNode node, int column, int row) {
        this.node = node;
        this.column = column;
        this.row = row;
    }
}

public class VerticalTraversal {

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

        List<List<Integer>> result = verticalOrderTraversal(root);

        System.out.println("Vertical Traversal: " + result);
    }

    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // column -> row -> minHeap(values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnMap =
                new TreeMap<>();

        Queue<NodePosition> queue = new LinkedList<>();
        queue.offer(new NodePosition(root, 0, 0));

        while (!queue.isEmpty()) {

            NodePosition current = queue.poll();
            TreeNode currentNode = current.node;
            int column = current.column;
            int row = current.row;

            columnMap.putIfAbsent(column, new TreeMap<>());
            columnMap.get(column).putIfAbsent(row, new PriorityQueue<>());

            columnMap.get(column).get(row).offer(currentNode.value);

            if (currentNode.left != null) {
                queue.offer(new NodePosition(currentNode.left, column - 1, row + 1));
            }

            if (currentNode.right != null) {
                queue.offer(new NodePosition(currentNode.right, column + 1, row + 1));
            }
        }

        // Build result
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : columnMap.values()) {

            List<Integer> columnValues = new ArrayList<>();

            for (PriorityQueue<Integer> minHeap : rows.values()) {
                while (!minHeap.isEmpty()) {
                    columnValues.add(minHeap.poll());
                }
            }

            result.add(columnValues);
        }

        return result;
    }
}
