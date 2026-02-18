import java.util.*;


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
    int column; 
    
    NodePosition(TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}

public class bottom_view_of_bnary_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.left.right.left = new TreeNode(45);
        // root.left.right.right = new TreeNode(55);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);

        ArrayList<Integer> result=funct(root);
        System.out.println("the bottom view of the tree is "+result); 
    }
    public static ArrayList<Integer> funct(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null) return result;

        Queue<NodePosition> q=new LinkedList<>();
        q.add(new NodePosition(root,0));
        TreeMap<Integer,Integer> map=new TreeMap<>();

        while(!q.isEmpty()){
            NodePosition nod=q.poll();
            TreeNode val=nod.node;
            int col=nod.column;

            map.put(col,val.value);

            if(val.left!=null) q.add(new NodePosition(val.left, col-1));                
            if(val.right!=null) q.add(new NodePosition(val.right, col+1));
            map.put(col,val.value);
        }

        for(Integer value:map.values()){
            result.add(value);
        }
        return result;

    }
}
