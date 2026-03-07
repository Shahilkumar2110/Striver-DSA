import java.util.Queue;
import java.util.LinkedList;


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int node) {
        this.value = node;
        this.left = this.right = null;
    }
}

class position{
    TreeNode node;
    int num;
    position(TreeNode node, int num){
        this.node=node;
        this.num=num;
    }
}



public class maximum_width_of_tree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(45);
        root.left.right.right = new TreeNode(55);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(25);


        int max=funct(root);                      // time complexity==O(n)
                                                  // space complexity==O(n)
        System.out.println("the maximum width of tree is "+ max);
    }
    
    static int funct(TreeNode root){
        if(root==null) return 0;
        
        Queue<position> q=new LinkedList<>();
        q.add(new position(root,0));

        int ans=0;

        while(!q.isEmpty()){
            int n=q.size();
            int zero=q.peek().num;
            int first=0;
            int last=0;
            for(int i=0;i<n;i++){
                position pos=q.poll();
                TreeNode node =pos.node;
                int num=pos.num-zero;

                if(i==0)first=num;
                if(i==n-1) last=num;

                if(node.left!=null)q.add(new position(node.left, 2*num+1));
                if(node.right!=null) q.add(new position(node.right, 2*num+2));
            }
            ans=Math.max(last-first+1,ans);

        }



        return ans;
    }
}
