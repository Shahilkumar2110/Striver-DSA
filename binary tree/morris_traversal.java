import java.util.ArrayList;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}

public class morris_traversal {
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

        ArrayList<Integer> arr=new ArrayList<>();
        inorder_through_morris(root,arr);
        System.out.println("the traversal like inorder by morris is "+arr);

        ArrayList<Integer> arr2=new ArrayList<>();
        preorder_through_morris(root,arr2);
        System.out.println("the traversal like preorder by morris is "+arr2);
    }

    static void inorder_through_morris(TreeNode root,ArrayList<Integer> arr){
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                arr.add(curr.value);
                curr=curr.right;
            }else{
                TreeNode leftmost=curr.left;
                while(leftmost.right!=null && leftmost.right!=curr){
                    leftmost=leftmost.right;
                }
                if(leftmost.right==null){
                    leftmost.right=curr;
                    curr=curr.left;
                }else{
                    leftmost.right=null;
                    arr.add(curr.value);
                    curr=curr.right;
                }
            }
        }
    }

    static void preorder_through_morris(TreeNode root,ArrayList<Integer> arr){
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                arr.add(curr.value);
                curr=curr.right;
            }else{
                TreeNode leftmost=curr.left;
                while(leftmost.right!=null && leftmost.right!=curr){
                    leftmost=leftmost.right;
                }
                if(leftmost.right==null){
                    leftmost.right=curr;
                    arr.add(curr.value);
                    curr=curr.left;
                }else{
                    leftmost.right=null;
                    curr=curr.right;
                }
            }
        }
    }


}
