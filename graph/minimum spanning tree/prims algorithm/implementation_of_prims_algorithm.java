

import java.util.*;




class pair{
    int wt;
    int node;
    int parent;
    pair(int wt, int node, int parent){
        this.wt=wt;
        this.node=node;
        this.parent=parent;
    }
}

public class implementation_of_prims_algorithm {
    public static void main(String[] args) {

        int n=5;

        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new int[]{1,2});
        graph.get(0).add(new int[]{2,1});

        graph.get(1).add(new int[]{0,2});
        graph.get(1).add(new int[]{2,1});

        graph.get(2).add(new int[]{0,1});
        graph.get(2).add(new int[]{1,1});
        graph.get(2).add(new int[]{3,2});
        graph.get(2).add(new int[]{4,2});

        graph.get(3).add(new int[]{2,2});
        graph.get(3).add(new int[]{4,1});

        graph.get(4).add(new int[]{3,1});
        graph.get(4).add(new int[]{2,2});

        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->{
           return a.wt - b.wt;
        });

        boolean[] visited= new boolean[n];
        ArrayList<int[]> path=new ArrayList<>();
        int sum=0;


        q.add(new pair(0,0,-1));

        while(!q.isEmpty()){     // e                    // time complexity==O(eloge)+O(eloge)
                                               //               for iteration and for traversal and put into queue
            
            
            // loge
            pair no=q.poll();
            int wt=no.wt;
            int node=no.node;
            int parent=no.parent;

            if(visited[node]){
                continue;
            }

            visited[node]=true;
            sum+=wt;
            if(parent!=-1){
                path.add(new int[]{parent,node});
            }

            // eloge
            for(int[] ele:graph.get(node)){

                if(!visited[ele[0]]){
                    q.add(new pair(ele[1],ele[0],node));
                }

            }

        }

        System.out.println("sum of weight of minimum spanning tree is "+ sum );

    }
}
