import java.util.*;


// find the tree is symmetric along the root of the tree 
// where root.left is mirror symmetric of root.right


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}

public class check_symmetric_binery_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.left.right.left = new TreeNode(45);
        // root.left.right.right = new TreeNode(55);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        // root.right.right.right = new TreeNode(7);

        if(symmetric(root.left,root.right)){
            System.out.println("the tree is mirror symmetric along the root");
        }else{
            System.out.println("the tree is not mirror symmetric along the root ");
        }
    }

    static boolean symmetric(TreeNode rootleft,TreeNode rootright){

        if(rootleft==null && rootright==null) return true;
        if(rootleft==null || rootright==null) return false;

        if(rootleft.value!=rootright.value) return false;

        return symmetric(rootleft.left,rootright.right) &&symmetric(rootleft.right,rootright.left);

    }


}
