


import java.util.ArrayList;
import java.util.Stack;


public class topological_sorting_by_dfs {
    public static void main(String[] args) {
        int n=5;

        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(2).add(3);

        graph.get(3).add(1);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(5).add(0);
        graph.get(5).add(2);

        int[] visited=new int[n+1];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<=n;i++){
            if(visited[i]==0){
                traversal(i,visited, st, graph);
            }
        }

        System.out.println("the topological sort is ");
        while(!st.isEmpty()){
            System.out.print(st.pop()+"    ");
        }

    }
    static void traversal(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> graph){
                                                                    // time complexit==O(n+e)
                                                                    // space complexity==O(2n)


        visited[node]=1;


        for(int nod:graph.get(node)){
            if(visited[nod]==0){
                traversal(nod,visited, st, graph);
            }
        }


        st.push(node);
    }
}
