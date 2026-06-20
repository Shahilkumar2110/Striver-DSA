
// SCC is used in a directed graph.
// A group of vertices forms an SCC if:
// Every vertex can reach every other vertex in that group.
//  return number of scc and print all the scc groups 








import java.util.*;

public class number_of_scc_by_korasaju_algorithm {
    public static void main(String[] args) {
        

        int n = 10;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);

        adj.get(1).add(2);

        adj.get(2).add(0);
        adj.get(2).add(3);

        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(4).add(7);

        adj.get(5).add(6);

        adj.get(6).add(4);

        adj.get(7).add(8);

        adj.get(8).add(9);

        adj.get(9).add(7);

        int[] visited=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,adj, st,visited);
            }
        }

        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();
        for(int i=0;i<n;i++){
            reverse.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            visited[i]=0;
            for(int ele:adj.get(i)){
                reverse.get(ele).add(i);
            }
        }

        int count_scc=0;
        ArrayList<ArrayList<Integer>> prints=new ArrayList<>();


        while(!st.isEmpty()){
            int node=st.pop();

            ArrayList<Integer> scc=new ArrayList<>();
            if(visited[node]==0){
                count_scc++;
                final_dfs(node,scc, visited, reverse);
            }
            if(scc.size()>0)
            prints.add(scc);

        }


        System.out.println("total number of scc is "+ count_scc);
        System.out.println("the scc is "+prints);




    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> graph,  Stack<Integer> st , int[] visited){

        visited[node]=1;
        for(int ele:graph.get(node)){
            if(visited[ele]==0){
                dfs(ele,graph,st,visited);
            }
        }
        st.push(node);
    }

    static void final_dfs(int node, ArrayList<Integer> prints , int[] visited , ArrayList<ArrayList<Integer>> graph){

        visited[node]=1;
        for(int ele:graph.get(node)){
            if(visited[ele]==0){
                final_dfs(ele, prints,visited, graph);
            }
        }

        prints.add(node);

    }
}
