class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}



public class children_sum_property {
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

        funct(root);

    }
    static void funct(TreeNode root){
        if(root==null) return ;
        int sum=0;
        if(root.left!=null) sum+=root.left.value;
        if(root.right!=null) sum+=root.right.value;

        if(sum<root.value){
            if(root.left!=null)root.left.value=root.value;
            if(root.right!=null)root.right.value=root.value;
        }

        funct(root.left);
        funct(root.right);

        int tot=0;
        if(root.left!=null) tot+=root.left.value;
        if(root.right!=null) tot+=root.right.value;

        if(root.left!=null||root.right!=null) root.value=tot;

    } 
}
