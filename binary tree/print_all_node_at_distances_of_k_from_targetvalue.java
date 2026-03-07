import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList; 
import java.util.Queue;
import java.util.LinkedList;



// return all the node which is at distances of k from the target node ;



class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}




public class print_all_node_at_distances_of_k_from_targetvalue {
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

        System.out.println("enter the target node : ");
        int target=sc.nextInt();
        System.out.println("enter the distance of node to find from target node: ");
        int k=sc.nextInt();

        TreeNode targetnode=find_position(root,target);
        if(targetnode==null){
            System.out.println("target node not present in the tree");
            return;
        }

        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        add_address(root,map);

        ArrayList<Integer> result=new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        find_node(targetnode,result,k,map,visited);
        System.out.println("the node at distancce of k from the target node is "+result);

    }

    static void add_address(TreeNode root,HashMap<TreeNode,TreeNode> map){

        if(root==null) return;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode nod=q.poll();

                if(nod.left!=null){
                    map.put(nod.left,nod);
                    q.add(nod.left);
                }
                if(nod.right!=null){
                    map.put(nod.right,nod);
                    q.add(nod.right);
                }
            }
        }
    }

    static TreeNode find_position(TreeNode root,int target){
        if(root==null) return null;

        if(root.value==target)return root;

        TreeNode left=find_position(root.left,target);
        if(left!=null){
            return left;
        }
        return find_position(root.right,target);

    }


    static void find_node(TreeNode root, ArrayList<Integer> result,int k,HashMap<TreeNode, TreeNode> map,HashSet<TreeNode> visited){

        if(root==null) return;

        if (visited.contains(root)) return;
        visited.add(root);

        if(k==0){
            result.add(root.value);
            return;
        }

        find_node(root.left, result, k - 1, map, visited);
        find_node(root.right, result, k - 1, map, visited);
        find_node(map.get(root), result, k - 1, map, visited);
    }
}   
