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


public class inorder_successor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);

        System.out.println("enter the number to find her successor number: ");
        int target=sc.nextInt();
        
        TreeNode result=funct(root,target);
        TreeNode result2=funct2(root,target);
        if(result!=null) System.out.println("the successor of number is "+result.value);
        else System.out.println("the successor number is not present .");
        if(result2!=null) System.out.println("the predecessor of number is "+result2.value);
        else System.out.println("the predecessor number is not present .");

    }

    static TreeNode funct(TreeNode root,int target){

        TreeNode result=null;
        while(root!=null){
            if(root.value<=target){
                root=root.right;
            }else{
                result=root;
                root=root.left;
            }
        }
        return result;

    }

    static TreeNode funct2(TreeNode root,int target){

        TreeNode result=null;
        while(root!=null){
            if(root.value>=target){
                root=root.left;
            }else{
                result=root;
                root=root.right;
            }
        }
        return result;

    }
}