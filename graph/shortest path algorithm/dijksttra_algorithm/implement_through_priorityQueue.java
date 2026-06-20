// Dijkstra's algorithm implemented through priorityqueue 


import java.util.*;





class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class implement_through_priorityQueue {
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

        int[] dist=new int[V];

        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
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
                                                            //  time complexity==O(e * logv) where 
                                                                            //          e == number of edge in graph 
                                                                            //          v == number of node in graph 
        while(!q.isEmpty()){
            int[] node=q.poll();
            int dis=node[0];
            int nod=node[1];

            if (dis > dist[nod]) {
                continue;
            }

            for(Pair ele:graph.get(nod)){
                if(dist[ele.node]>dis+ ele.weight ){
                    dist[ele.node]=dis+ ele.weight ;
                    q.add(new int[]{
                        ele.weight+dis,ele.node
                    });
                }
            }
        }

        System.out.println("the shortest distance from src node to other node is ");

        for(int e:dist){
            System.out.print(e+"    ");
        }




    }
}
