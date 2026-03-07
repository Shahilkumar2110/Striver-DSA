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

public class delete_node_from_BST {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(5);
        root.right = new TreeNode(55);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(53);
        root.right.right = new TreeNode(60);

        System.out.println("Enter number to be deleted:");
        int num = sc.nextInt();

        root = deleteNode(root, num);

        System.out.println("Inorder after deletion:");
        inorder(root);
    }

    static TreeNode deleteNode(TreeNode root, int key){

        if(root == null){
            System.out.println("Number not present.");
            return null;
        }

        if(key < root.value){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.value){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode successor = findMin(root.right);
                root.value = successor.value;
                root.right = deleteNode(root.right, successor.value);
            }
        }

        return root;
    }

    static TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    static void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }
}