import java.util.Scanner;
import java.util.HashMap;


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}



public class construct_binarytree_by_preorder_and_inorder {                              // here error means no tree formation
                                                                                        //  dur to wrong data in preorder and inorder 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the length of array: ");
        int len=sc.nextInt();

        int[] preorder=new int[len];
        int[] inorder=new int[len];

        System.out.println("enter the value of preorder and inorder: ");
        for(int i=0;i<len;i++){
            preorder[i]=sc.nextInt();
            inorder[i]=sc.nextInt();
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(inorder[i],i);
        }

        TreeNode result=connect_node(preorder,0,len-1,inorder,0,len-1,map);

        System.out.println("the tree is ready");

    }

    static TreeNode connect_node(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend, HashMap<Integer,Integer> map){

        if(prestart>preend|| instart>inend) return null;

        TreeNode node=new TreeNode(preorder[prestart]);

        int index=map.get(preorder[prestart]);
        int num_in_left=index-instart;


        node.left=connect_node(preorder,prestart+1,prestart+num_in_left,inorder,instart,index-1,map);
        node.right=connect_node(preorder,prestart+num_in_left+1,preend,inorder,index+1,inend,map);

        return node;
    }
}
