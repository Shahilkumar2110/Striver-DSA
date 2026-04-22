import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;






// detect cycle in undirected graph by dft(depth first tree)






class pair{
    int curr;
    int pre;
    pair(int first, int second){
        curr=first;
        pre=second;
    }
}

public class detect_cyclc_in_undirected_graph_2 {
    public static void main(String[] args) {
        int n = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // edges
        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(1);
        graph.get(2).add(4);
        graph.get(2).add(5);

        graph.get(3).add(1);
        graph.get(3).add(4);

        graph.get(4).add(2);
        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(2);
        graph.get(5).add(4);

        boolean[] visited=new boolean[n+1];

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                if(dft(graph, i,visited)){
                    System.out.println("given graph form a cycle");
                    return;
                }
            }
        }
        System.out.println("no any cycle form in graph");

    }

    static boolean dft(ArrayList<ArrayList<Integer>> graph,int start, boolean[] visited){    // space complexity==O(n)+O(n)
                                                                                             // time complexity ==O(n+2e)+O(n)
                                                                                                                  
                                               
        Stack<pair> st=new Stack<>();
        st.push(new pair(start,-1));
        visited[start]=true;

        while(!st.isEmpty()){
            int curr=st.peek().curr;
            int pre=st.peek().pre;
            st.pop();

            for(int neigh:graph.get(curr)){
                if(!visited[neigh]){
                    st.push(new pair(neigh,curr));
                    visited[neigh]=true;
                }else if(pre!=neigh) return true;

            }

        }
        return false;


    }
}
