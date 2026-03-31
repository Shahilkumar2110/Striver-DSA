import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}


// better approach by concept of iterator  

public class two_sum_in_bst {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);

        System.out.println("enter the target value that sum of two number ");
        int target=sc.nextInt();

        boolean present= funct(root,target);                           // time complexity==O(n)
                                                                           // space complexxity==O(maximum  height of tree)
        if(present){
            System.out.println("such pair is present ");
        }else{
            System.out.println("such pair is not present ");
        }
    }
    
    static Stack<TreeNode> st1=new Stack<>();
    static Stack<TreeNode> st2=new Stack<>();
    static boolean funct(TreeNode root,int target){
        leftmost(root);
        rightmost(root);
        while(st1.peek().value<st2.peek().value){
            TreeNode num1=st1.peek();
            TreeNode num2=st2.peek();
            int sum=num1.value+num2.value;

            if(sum==target){
                return true;
            }else if(sum>target){
                st2.pop();
                rightmost(num2.left);
            }else{
                st1.pop();
                leftmost(num1.right);
            }

        }
        return false;

    }

    static void leftmost(TreeNode root){
        while(root!=null){
            st1.push(root);
            root=root.left;
        }
    }
    static void rightmost(TreeNode root){
        while(root!=null){
            st2.push(root);
            root=root.right;
        }
    }
}


