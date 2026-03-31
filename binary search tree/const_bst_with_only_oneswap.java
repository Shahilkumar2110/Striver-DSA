class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}

public class const_bst_with_only_oneswap {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);
        
        bst_recover recov=new bst_recover();
        recov.funct(root);
        recov.swap();

        System.out.println("the correct bst form successfully ");

    }
}

class bst_recover{
    TreeNode first=null, middle=null, last=null;
    TreeNode pre=null;

    void funct(TreeNode root){
        if(root==null){
            return ;
        }

        funct(root.left);
        if(pre!=null && root.value<pre.value){

            if(first==null){
                middle=root;
                first=pre;
            }else{
                last=root;
            }

        }
        pre=root;
        funct(root.right);


    }

    void swap(){
        if(first!=null && last!=null){
            int temp=first.value;
            first.value=last.value;
            last.value=temp;
        }else if(first!=null && middle !=null){
            int temp=first.value;
            first.value=middle.value;
            middle.value=temp;
        }
    }
}
