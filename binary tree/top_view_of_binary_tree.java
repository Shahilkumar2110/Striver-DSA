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

class NodePosition {
    TreeNode node;
    int column;   // horizontal distance
    
    NodePosition(TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}

public class top_view_of_binary_tree {
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


        ArrayList<Integer> result=top_view(root);
        System.out.println("the top view of the binary tree is "+result);
    }

    public static ArrayList<Integer> top_view(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null) return result;

        TreeMap<Integer,Integer> map=new TreeMap<>();

        Queue<NodePosition> q=new LinkedList<>();

        q.add(new NodePosition(root, 0));

        while(!q.isEmpty()){
            NodePosition node_pos=q.poll();
            TreeNode node=node_pos.node;
            int col=node_pos.column;

            if(!map.containsKey(col)){
                map.put(col,node.value);
            }
            if(node.left!=null) q.add(new NodePosition(node.left, col-1));
            if(node.right!=null) q.add(new NodePosition(node.right, col+1));

        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            result.add(e.getValue());
        }
        return result;
    }

}
