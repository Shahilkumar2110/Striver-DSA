import java.util.Scanner;



class node{
    int data;
    node left,right;
    node(int data){
        this.data=data;
        left=right=null;
    }
}



public class maximum_depth_in_binarytree {
    public static void main(String[] args) {
        node tree=new node(1);
        tree.left=new node(2);
        tree.right=new node(3);
        tree.left.left=new node(4);                   // time complexity==O(number of node)
                                                           // space complexity==O(number of node)
        tree.left.right=new node(5);
        tree.right.left=new node(6);
        tree.right.right=new node(7);
        tree.right.right.left=new node(7);


        int max=maxdepth(tree);
        System.out.println("the maximum depth of tree is "+max);


    } 
    public static int maxdepth(node root){
        if(root==null) return 0;

        int left=maxdepth(root.left);
        int right=maxdepth(root.right);


        return 1+Math.max(left,right);
    }
}
