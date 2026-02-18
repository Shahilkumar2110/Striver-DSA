import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


//         1 
//      2     3
//    4   5  6   7  
//  traversel= 1 ,3 ,2 ,4,5,6,7,---> return this type of traversal


class node {
    int data;
    node left, right;

    node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class zig_zag_traversal {
    public static void main(String[] args) {
        node tree = new node(1);
        tree.left = new node(2);
        tree.right = new node(3);
        tree.left.left = new node(4);
        tree.left.right = new node(5);
        tree.right.left = new node(6);
        tree.right.right = new node(7);
        tree.right.right.left = new node(7);

        ArrayList<Integer> result=new ArrayList<>();

        boolean lefttoright=true;
        zig_zag(tree,result,lefttoright);

        System.out.println("the zig-zag traversal is "+result);

    }

    public static void zig_zag(node root, ArrayList<Integer> result,boolean lefttoright){
        if(root==null) return;
        Queue<node> arr=new LinkedList<>();
        arr.add(root);
        while(!arr.isEmpty()){
            int n=arr.size();
            int[] part=new int[n];
            for(int i=0;i<n;i++){
                node temp=arr.poll();
                int val=temp.data;
                int index=lefttoright?i:n-i-1;
                part[index]=val;
                if(temp.left!=null) arr.add(temp.left);
                if(temp.right!=null) arr.add(temp.right);

            }

            lefttoright=!lefttoright;
            for(int i:part){
                result.add(i);
            }
        }
    }

}
