import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;







// You are given a graph (nodes + edges).

// 👉 Your task:
// Check whether the graph is bipartite or not with two color 1 and 2 












public class bipartite_graph_bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        int n = 5;

        // Create graph (1-based indexing)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected)
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

        int[] color=new int[n+1];
        boolean bipartite=true;

        for(int i=1;i<=n;i++){
            if(color[i] ==0){
                bipartite=check(i, graph,color);
            }
            if(!bipartite) break;
        }

        if(bipartite){
            System.out.println("given graph is bipartite graph " );
        }else{
            System.out.println("given graph is not the bipatite graph");
        }





    }

    static boolean check(int start, ArrayList<ArrayList<Integer>> graph, int[] color){
        int n=graph.size();                                           // time complexity==O(n*m)
                                                                      //space complexity==O(n*m)

        Queue<Integer> q=new LinkedList<>();

        q.add(start);
        color[start]=1;

        while(!q.isEmpty()){
            int node=q.poll();


            for(int i: graph.get(node)){
                if(color[i]==0 ){
                    q.add(i);
                    color[i]=color[node]==1?2:1;
                }else{
                    int temp=color[node]==1?2:1;
                    if(color[i]!=temp)  return false;
                }
            }

        }


        return true;
    }
}
