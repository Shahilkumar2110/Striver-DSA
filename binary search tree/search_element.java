import java.util.Scanner;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.value=value;
        this.left=this.right=null;
    }
}

public class search_element {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);

        System.out.println("enter the number to be searched: ");
        int target=sc.nextInt();

        Boolean find=funct(root,target);
        if(find) System.out.println("the target element is present in tree. ");
        else System.out.println("the target element is not present in tree. ");

    }

    static boolean funct(TreeNode root,int target){
        if(root==null) return false;

        if(root.value>target){
            return funct(root.left,target);
        }else if(root.value<target){
            return funct(root.right,target);
        }
        return true;
    }

}
