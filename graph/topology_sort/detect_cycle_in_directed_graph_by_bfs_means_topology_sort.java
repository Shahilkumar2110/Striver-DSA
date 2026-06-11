import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

 
// concept--> if size of topology array is equal to number of node then graph have no cycle 
//             otherwise cycle occur




public class detect_cycle_in_directed_graph_by_bfs_means_topology_sort {
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

        int[] indegree=new int[n+1];

        for(int i=0;i<=n;i++){
            for(int node:graph.get(i)){
                indegree[node]++;
            }
        }
                                                                            // time complexity==O(n+e)
                                                                            // space complexity==O(2n)
        Queue<Integer> q=new LinkedList<>();


        for(int i=0;i<=n;i++){
            if(indegree[i]==0) q.offer(i);
        }

        int count=0;

        while(!q.isEmpty()){
            int node=q.poll();
            count++;

            for(int i:graph.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }

        }

        if(count==n+1){
            System.out.println("graph not form any cycle ");
        }else{
            System.out.println("graph form cycle ");
        }

    }
}
