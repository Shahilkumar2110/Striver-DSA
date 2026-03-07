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



public class insert_a_given_node {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);

        System.out.println("enter the number to be inserted : ");
        int num=sc.nextInt();

        while(true){
            if(root.value>num){
                if(root.left!=null){
                    root=root.left;
                }else{
                    root.left=new TreeNode(num);
                    break;
                }
            }else{
                if(root.right!=null){
                    root=root.right;
                }else{
                    root.right=new TreeNode(num);
                    break;
                }
            }
        }
        System.out.println("number be inserted successful. ");


    }
}
