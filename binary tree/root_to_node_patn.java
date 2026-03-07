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


public class root_to_node_patn {
    
    static ArrayList<Integer> result=new ArrayList<>();

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

        System.out.println("enter the target node to find the path from the root: ");
        int target=sc.nextInt();

        boolean done= funct(root,target);
        if(done) System.out.println("the path between root and target node is: "+ result);
        else System.out.println("the target node is not present in the given tree. ");
        

    }

    static boolean funct(TreeNode root,int target){
        if(root==null) return false;

        if(root.value==target){
            result.add(root.value);
            return true;
        }

        result.add(root.value);

        if(funct(root.left,target)||funct(root.right,target)) return true;

        result.remove(result.size()-1);
        return false;

    }

}
