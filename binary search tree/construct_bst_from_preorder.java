import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}


public class construct_bst_from_preorder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] preorder=new int[n];

        for(int i=0;i<n;i++){
            preorder[i]=sc.nextInt();
        }

        funct(preorder,Integer.MAX_VALUE);
        System.out.println("the bst is form successfully. ");

    }


    static int index=0;
    static TreeNode funct(int[] preorder,int upperbound){
        if (index == preorder.length || preorder[index] > upperbound) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index]);
        index++;

        node.left = funct(preorder, node.value);
        node.right = funct(preorder, upperbound);

        return node;
    }
}
