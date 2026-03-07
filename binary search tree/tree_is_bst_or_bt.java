// class TreeNode {
//     int value;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int value) {
//         this.value = value;
//         this.left = this.right = null;
//     }
// }

// public class tree_is_bst_or_bt {
//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(50);
//         root.left = new TreeNode(10);
//         root.right = new TreeNode(55);
//         root.left.left = new TreeNode(9);
//         root.left.right = new TreeNode(40);
//         root.right.left = new TreeNode(53);
//         root.right.right = new TreeNode(60);

//         boolean bst = funct(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//         if (bst)
//             System.out.println("the tree is binary search tree. ");
//         else
//             System.out.println("the tree is binary tree ");
//     }

//     static boolean funct(TreeNode root, int min, int max) {
//         if (root == null)
//             return true;

//         if (root.value <= min || root.value >= max)
//             return false;

//         return funct(root.left, min, root.value) &&
//                 funct(root.right, root.value, max);
//     }

// }









//   by using queue --> level order traversal

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value = value;
        this.left = this.right = null;
    }
}

class NodeRange{
    TreeNode node;
    long min;
    long max;

    NodeRange(TreeNode node,long min,long max){
        this.node=node;
        this.min=min;
        this.max=max;
    }
}

public class tree_is_bst_or_bt {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);

        boolean bst = funct(root);

        if(bst) System.out.println("Tree is Binary Search Tree");
        else System.out.println("Tree is NOT Binary Search Tree");
    }

    static boolean funct(TreeNode root){

        Queue<NodeRange> q = new LinkedList<>();

        q.add(new NodeRange(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while(!q.isEmpty()){

            NodeRange curr = q.poll();
            TreeNode node = curr.node;

            if(node.value <= curr.min || node.value >= curr.max)
                return false;

            if(node.left != null)
                q.add(new NodeRange(node.left, curr.min, node.value));

            if(node.right != null)
                q.add(new NodeRange(node.right, node.value, curr.max));
        }

        return true;
    }
}