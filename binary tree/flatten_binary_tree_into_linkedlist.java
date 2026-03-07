import java.util.Stack;

// rearrange the tree node to make like a linked list 


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}




public class flatten_binary_tree_into_linkedlist {
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

        // flatten_approze_i(root);
        // System.out.println("flatten is successfull by using methed 1 with recursive: ");

        
        // flatten_approze_ii(root);
        // System.out.println("flatten is successfull by using methed 2 with stack data structure :");


        flatten_approze_iii(root);
        System.out.println("flatten is successfull by using method 3 with morris traversal: ");

    }

    static TreeNode pre=null;
    static void flatten_approze_i(TreeNode root){                   //time complexity==O(n)
                                                                   //space complexity==O(n) 
        if(root==null) return ;
        flatten_approze_i(root.right);
        flatten_approze_i(root.left);   

        root.right=pre;
        root.left=null;
        pre=root;
    }

    static void flatten_approze_ii(TreeNode root){                  //time complexity==O(n)
                                                                   //space complexity==O(n)       
        if(root==null) return;

        Stack<TreeNode> sta=new Stack<>();
        sta.push(root);

        while(!sta.isEmpty()){
            TreeNode element=sta.pop();
            if(element.right!=null) sta.push(element.right);
            if(element.left!=null) sta.push(element.left);

            if(!sta.empty()) element.right=sta.peek();
            element.left=null;
        }
    }

    static void flatten_approze_iii(TreeNode root){                  //time complexity==O(n)
                                                                   //space complexity==O(1) 
        if(root==null) return ;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pre=curr.left;

                while(pre.right!=null){
                    pre=pre.right;
                }
                pre.right=curr.right;
                curr.right=curr.left;
                curr.left=null;

            }
            curr=curr.right;

        }
    }

}
