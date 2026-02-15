import java.util.Scanner;

// return maximum sum pf path in tree 

class node {
    int data;
    node left, right;

    node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class maximum_path_sum {
    public static void main(String[] args) {

        node tree = new node(1);
        tree.left = new node(2);
        tree.right = new node(3);
        tree.left.left = new node(4);
        tree.left.right = new node(5);
        tree.right.left = new node(6);
        tree.right.right = new node(7);
        tree.right.right.left = new node(7);
        int[] sum = new int[1];
        funct(tree, sum);
        System.out.println("the maximum sum of the path in tree is " + sum[0]);


    }

    public static int funct(node root,int[] max){
        if(root==null) return 0;
        
        int left=Math.max(0,funct(root.left,max));
        int right=Math.max(0,funct(root.right,max));

        max[0]=Math.max(max[0],left+right+root.data);

        return Math.max(left,right)+root.data;
    }
}
