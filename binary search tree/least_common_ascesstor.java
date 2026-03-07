import java.util.Scanner;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value = value;
        this.left = this.right = null;
    }
}


public class least_common_ascesstor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);

        System.out.println("enter the two number to find the least common ascesstor: ");
        int num1=sc.nextInt();
        int num2=sc.nextInt();

        int result=funct(root,num1,num2);
        System.out.println("the least common ascesstor of "+num1+" and "+num2+" is "+result);
    }
    static int funct(TreeNode root,int num1,int num2){
        if(root==null) return -1;
        
        if(root.value>num1 && root.value>num2){
            return root.left!=null? funct(root.left,num1,num2):root.value;
        }
        if(root.value<num1 && root.value<num2){
            return root.right!=null?funct(root.right,num1,num2):root.value;
        }

        return root.value;
    }
}
