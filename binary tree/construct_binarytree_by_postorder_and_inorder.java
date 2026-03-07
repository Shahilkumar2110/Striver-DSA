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



public class construct_binarytree_by_postorder_and_inorder {
    public static void main(String[] args) {              
                                                                                            //   error means no tree formed 
                                                                                            //  dur to wrong data of postorder and inorder
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the length of array: ");
        int len=sc.nextInt();

        int[] postorder=new int[len];
        int[] inorder=new int[len];

        System.out.println("enter the value of postorder and inorder: ");
        for(int i=0;i<len;i++){
            postorder[i]=sc.nextInt();
            inorder[i]=sc.nextInt();
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(inorder[i],i);
        }

        TreeNode node=connect_node(postorder,0,len-1,inorder,0,len-1,map);
        System.out.println("the binary tree is ready");

    }

    static TreeNode connect_node(int[] postorder,int poststart,int postend,int[] inorder,int instart,int inend,HashMap<Integer, Integer> map){

        if(poststart>postend||instart>inend){
            return null;
        }

        TreeNode node=new TreeNode(postorder[postend]);

        int index=map.get(postorder[postend]);
        int leftnum=index-instart;

        node.left=connect_node(postorder,poststart,poststart+leftnum-1,inorder,instart,index-1,map);
        node.right=connect_node(postorder,poststart+leftnum,postend-1,inorder,index+1,inend,map);


        return node;
    }
}
