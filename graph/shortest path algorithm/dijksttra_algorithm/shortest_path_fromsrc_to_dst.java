// print the shortest path from source to destination in the given graph 




import java.util.*;





class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}



public class shortest_path_fromsrc_to_dst {
    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1, 4));
        graph.get(1).add(new Pair(0, 4));

        graph.get(0).add(new Pair(2, 1));
        graph.get(2).add(new Pair(0, 1));

        graph.get(1).add(new Pair(3, 5));
        graph.get(3).add(new Pair(1, 5));

        graph.get(1).add(new Pair(4, 1));
        graph.get(4).add(new Pair(1, 1));

        graph.get(2).add(new Pair(3, 3));
        graph.get(3).add(new Pair(2, 3));

        graph.get(3).add(new Pair(4, 1));
        graph.get(4).add(new Pair(3, 1));

        int src=0;
        int dst=V-1;

        int[] dist=new int[V];
        int[] parent=new int[V];

        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
            parent[i]=i;
        }
        dist[src]=0;

        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );

        q.add(new int[]{0,src});


        while(!q.isEmpty()){              // time complexity==O(e * log v * v)
                                          //  where e= total edge  and v= total node
            int[] node=q.poll();
            int dis=node[0];
            int nod=node[1];

            if (dis > dist[nod]) {
                continue;
            }

            for(Pair ele:graph.get(nod)){
                if(dist[ele.node]>dis+ ele.weight ){
                    dist[ele.node]=dis+ ele.weight ;

                    parent[ele.node]=nod;

                    q.add(new int[]{
                        ele.weight+dis,ele.node
                    });
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            System.out.println("No path exists from source to destination.");
            return;
        }

        ArrayList<Integer> result=new ArrayList<>();

        int curr=dst;

        while(curr!=src){
            result.add(curr);
            curr=parent[curr];
        }
        result.add(src);

        Collections.reverse(result);

        System.out.println("Shortest distance: " + dist[dst]);
        System.out.println("Shortest path: " + result);

    }
}
