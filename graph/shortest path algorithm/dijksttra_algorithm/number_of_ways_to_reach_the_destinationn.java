


// You are given:- 
//      n nodes (0 to n-1)
//      edges between nodes (usually undirected)
//      each road has a travel time in minute

// 👉 You are at node 0
// 👉 You want to reach node n-1

//   Goal:- 
// You must find:
//              --> Number of different shortest paths from 0 to n-1
// Not just shortest distance — but how many ways give the same minimum distance.






import java.util.*;


public class number_of_ways_to_reach_the_destinationn {
    public static void main(String[] args) {
        int n = 7;

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 4);

        addEdge(graph, 1, 2, 1);
        addEdge(graph, 1, 3, 7);

        addEdge(graph, 2, 4, 3);

        addEdge(graph, 3, 5, 1);
        addEdge(graph, 3, 6, 10);

        addEdge(graph, 4, 3, 2);
        addEdge(graph, 4, 5, 5);

        addEdge(graph, 5, 6, 1);

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->{
            return a[1]-b[1]; 
        });
        q.add(new int[]{0,0});

        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        int[] visited=new int[n];
        visited[0]=1;

        while(!q.isEmpty()){                // time complexity==O(e* log n )
                                          //    e= total edge and n=total node

            int node=q.peek()[0];
            int d=q.peek()[1];
            q.poll();

            if (d > dist[node]) continue;

            for(int[] ele:graph.get(node)){

                int next=ele[0];
                int cost=ele[1];

                if(d+cost<dist[next]){
                    visited[next]=visited[node];
                    dist[next]=d+cost;
                    q.add(new int[]{next, dist[next]});
                }else if(d+cost==dist[next]){
                    visited[next]=visited[next]+visited[node];
                }

            }

        }

        System.out.println("the minimum way and minimum cost to reach the end node is "+visited[n-1]+"  and  "+dist[n-1]);






         
    }


    static void addEdge(ArrayList<ArrayList<int[]>> graph,
                        int u, int v, int wt) {

        graph.get(u).add(new int[]{v, wt});
        graph.get(v).add(new int[]{u, wt});
    }


}
