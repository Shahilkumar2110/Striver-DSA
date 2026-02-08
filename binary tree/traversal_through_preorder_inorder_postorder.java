import java.util.*;

class node{
    int data;
    node left,right;
    node(int data){
        this.data=data;
        left=right=null;
    }
}

class pair{
    node nod;
    int state;
    pair(node nod,int state){
        this.nod=nod;
        this.state=state;
    }
}

public class traversal_through_preorder_inorder_postorder {
    public static void main(String[] args) {
        node tree=new node(1);
        tree.left=new node(2);
        tree.right=new node(3);
        tree.left.left=new node(4);
        tree.left.right=new node(5);
        tree.right.left=new node(6);
        tree.right.right=new node(7);


        alltraversal(tree);
    }
    public static void alltraversal(node tree){
        Stack<pair> st=new Stack();
        pair p=new pair(tree,1);
        st.push(p);

        ArrayList<Integer> preorder=new ArrayList<>();
        ArrayList<Integer> inorder=new ArrayList<>();
        ArrayList<Integer> postorder=new ArrayList<>();

        while(!st.isEmpty()){
            p=st.pop();
            if(p.state==1){
                preorder.add(p.nod.data);
                p.state++;
                st.push(p);
                if(p.nod.left!=null) st.push(new pair(p.nod.left,1));
            }else if(p.state==2){
                inorder.add(p.nod.data);
                p.state++;
                st.push(p);
                if(p.nod.right!=null) st.push(new pair(p.nod.right,1));
            }else{
                postorder.add(p.nod.data);
            }
        }

        System.out.println("preorder of tree is "+preorder);
        System.out.println("inorder of tree is "+inorder);
        System.out.println("postorder of tree is "+postorder);

    }
}
