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

public class serialize_and_deserialize {
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

        String decrypt = serialize(root);
        System.out.println("the decrypt of tree is in form of string  " + decrypt);

        TreeNode node = deserialize(decrypt);
        System.out.println("the serialize of string is successfull");
    }

    static String serialize(TreeNode root) {

        if (root == null)
            return "";

        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode element = q.poll();

            if (element == null) {
                str.append("#,");
            } else {
                str.append(element.value).append(",");
                q.add(element.left); 
                q.add(element.right); 
            }
        }
        return str.toString();
    }

    static TreeNode deserialize(String str) {

        if (str.equals(""))
            return null;

        String[] strarr = str.split(",");
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode node = new TreeNode(Integer.parseInt(strarr[0]));
        q.add(node);

        int i = 1;

        while (!q.isEmpty() && i < strarr.length) {

            TreeNode element = q.poll();
            if (!strarr[i].equals("#")) {
                element.left = new TreeNode(Integer.parseInt(strarr[i]));
                q.add(element.left);
            }
            i++;

            if (i < strarr.length && !strarr[i].equals("#")) {
                element.right = new TreeNode(Integer.parseInt(strarr[i]));
                q.add(element.right);
            }
            i++;
        }

        return node;
    }

}
