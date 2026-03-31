import java.util.Stack;


class TreeNode{
    int value;
    TreeNode left,right;
    TreeNode(int data){
        value=data;
        left=right=null;
    }
}

public class bst_iterator {
    public static void main(String[] args) {

        TreeNode root=new TreeNode(50);
        root.left=new TreeNode(10);
        root.right=new TreeNode(55);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(40);
        root.right.left=new TreeNode(53);
        root.right.right=new TreeNode(60);

        iterator ite=new iterator(root);

        System.out.println(ite.next());
        System.out.println(ite.next());
        System.out.println(ite.hasnext());
        System.out.println(ite.next());
        System.out.println(ite.next());
        System.out.println(ite.hasnext());

    }
}                                                               

class iterator{                                                     // time complexity==O(1) dur to we acces the top of stack 
                                                                    // space complexity==O(maximum heigth of tree)
        private  Stack<TreeNode> st=new Stack<>();

        iterator(TreeNode root){
            leftmost(root);
        }

        int next(){
            TreeNode nex=st.pop();
            leftmost(nex.right);
            return nex.value;
        }

        boolean hasnext(){
            return !st.isEmpty();
        }

        void leftmost(TreeNode root){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
        }
    }
