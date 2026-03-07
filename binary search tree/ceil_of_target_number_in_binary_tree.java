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


public class ceil_of_target_number_in_binary_tree {
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

        int ceil=Integer.MAX_VALUE;
        while(root!=null){
            if(root.value==target){
                System.out.println("the target element is found. ");
                return;
            }
            if(root.value>target){
                ceil=root.value;
                root=root.left;
            }else{
                root=root.right;
            }
        }

        System.out.println("the ceil value of target number in tree is "+ceil);
    }
}
