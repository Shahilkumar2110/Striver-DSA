import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

// return the minimum time take to delete all the node from the tree ,starting from the targetnode 



class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}




public class minimum_time_taken_toburn_the_complete_tree_from_a_target_node {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

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

        System.out.println("enter the target node value : ");
        int target=sc.nextInt();

        TreeNode targetnode=node_position(root,target);
        if(targetnode==null){
            System.out.println("target value node is not present in the tree: ");
            return ;
        }

        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        mapping(root,map);

        HashSet<TreeNode > visited=new HashSet<>();

        int result=delete_node(targetnode,visited,0,map);
        System.out.println("the minimum time taken to delete all the node from the target node is "+result);
    }

    static TreeNode node_position(TreeNode root,int target){
        if(root==null) return null;
        if(root.value==target) return root;

        TreeNode left=node_position(root.left,target);
        if(left!=null){
            return left;
        }
        return node_position(root.right, target);

    }


    static void mapping(TreeNode root,HashMap<TreeNode ,TreeNode > map){
        if(root==null) return ;                          // for mapping ,here I use recursive method to mapping the 
                                                         //child node to its parent node 
                                                         // this is also correct but in pratical life , level-wise traversal is best by use of queue.

        if(root.left!=null){
            map.put(root.left,root);
            mapping(root.left,map);
        }

        if(root.right!=null){
            map.put(root.right,root);
            mapping(root.right,map);
        }

    }

    static int delete_node(TreeNode root,HashSet<TreeNode> visited,int burn,HashMap<TreeNode , TreeNode > map){
        if(root==null) return burn;

        if(visited.contains(root))return burn;
        visited.add(root);

        int max=burn;
        if(root.left!=null){
            max=Math.max(delete_node(root.left,visited,burn+1,map),max);
        }
        if(root.right!=null){
            max=Math.max(delete_node(root.right,visited,burn+1,map),max);
        }
        if(map.containsKey(root)&& !visited.contains(map.get(root))){
            max=Math.max(delete_node(map.get(root),visited,burn+1,map),max);
        }
        return max;
    }
}
