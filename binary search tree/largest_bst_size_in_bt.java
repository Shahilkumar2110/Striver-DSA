class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}

class node_range{
    public int size, minrange, maxrange;
    node_range(int size ,int  minrange ,int maxrange){
        this.size=size;
        this.minrange=minrange;
        this.maxrange=maxrange;
    }
}

public class largest_bst_size_in_bt {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);

        System.out.println("the maximum range is "+ funct(root).size);
    }

    static node_range funct(TreeNode root){
        if(root==null){
            return new node_range(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        node_range left=funct(root.left);
        node_range right=funct(root.right);

        if(left.maxrange<root.value && right.minrange> root.value){
            return new node_range(left.size+right.size+1,Math.min(root.value,left.minrange), Math.max(root.value, right.maxrange) );
        }

        return new node_range(Math.max(left.size,right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
