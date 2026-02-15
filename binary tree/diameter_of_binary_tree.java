import java.util.Scanner;

// return diameter of the binary tree 
//diameter --> longest path between 2 different nodes  
//         --> path doesnot need to pass root of tree




class node{
    int data;
    node left,right;
    node(int data){
        this.data=data;
        left=right=null;
    }
}


public class diameter_of_binary_tree {
    public static void main(String[] args) {
        node tree = new node(1);
        tree.left = new node(2);
        tree.right = new node(3);
        tree.left.left = new node(4);
        tree.left.right = new node(5);
        tree.right.left = new node(6);
        tree.right.right = new node(7);
        tree.right.right.left = new node(7);
        int[] diameter=new int[1];
        funct(tree,diameter);
        System.out.println("the longest diameter of tree is "+diameter[0]);
    }

    public static int funct(node root,int[] max){
        if(root==null) return 0;

        int left=funct(root.left,max);
        int right=funct(root.right,max);

        max[0]=Math.max(max[0],left+right);
        return 1+Math.max(left,right);


    }

}


