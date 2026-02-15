import java.util.Scanner;




class node {
    int data;
    node left, right;

    node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class check_two_tree_are_identical {
    public static void main(String[] args) {
        node tree = new node(1);
        tree.left = new node(2);
        tree.right = new node(3);
        tree.left.left = new node(4);
        tree.left.right = new node(5);
        tree.right.left = new node(6);
        tree.right.right = new node(7);
        tree.right.right.left = new node(7);

        node tree2 = new node(1);
        tree2.left = new node(2);
        tree2.right = new node(3);
        tree2.left.left = new node(4);
        tree2.left.right = new node(5);
        tree2.right.left = new node(6);
        tree2.right.right = new node(7);
        tree2.right.right.left = new node(7);

        if(match(tree,tree2)) System.out.println("both tree is identical");
        else System.out.println("both tree is not identical");

    }
    public static boolean match(node root,node root2){
        if(root==null||root2==null) return (root==root2);

        return (root.data==root2.data) && match(root.left,root2.left) && match(root.right,root2.right);

    }
}
