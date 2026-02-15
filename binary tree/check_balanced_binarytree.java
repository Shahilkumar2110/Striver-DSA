import java.util.Scanner;

// balanced binary tree  =  (height of left subtree) -(height of right subtree) <=1
//  point to be noted - for all node , balanced number be <=1

class node {
    int data;
    node left, right;

    node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class check_balanced_binarytree {
    public static void main(String[] args) {
        node tree = new node(1);
        tree.left = new node(2);
        tree.right = new node(3);
        tree.left.left = new node(4);
        tree.left.right = new node(5);
        tree.right.left = new node(6);
        tree.right.right = new node(7);
        tree.right.right.left = new node(7);

        int result = funct(tree);
        if (result == -1) {
            System.out.println("the given tree is not a balanced binary tree. ");
        } else {
            System.out.println("the given tree is a balanced binary tree. ");

        }

    }

    public static int funct(node tree) {

        if (tree == null)
            return 0;

        int left = funct(tree.left);
        if (left == -1)
            return -1;

        int right = funct(tree.right);
        if (right == -1)
            return -1;

        int val = Math.abs(left - right);

        if (val > 1)
            return -1;
        return 1 + Math.max(left, right);
    }
}
