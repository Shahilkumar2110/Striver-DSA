// Given:
// Directed Graph
// Weighted edges
// Graph is DAG (Directed Acyclic Graph)

// Need to find:
// Shortest distance from source node to all node
// Usually source = 0













import java.util.Stack;
import java.util.ArrayList;

class pair {
    int data;
    int weight;

    pair(int first, int second) {
        data = first;
        weight = second;
    }
}

public class shortest_path_of_directed_acyclic_graph {
    public static void main(String[] args) {
        int n = 10; // nodes 0 to 9
        int srcnode = 0;

        ArrayList<ArrayList<pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed Weighted DAG(directed cyclic graph )

        graph.get(0).add(new pair(1, 3));
        graph.get(0).add(new pair(2, 6));
        graph.get(0).add(new pair(3, 5));

        graph.get(1).add(new pair(4, 9));
        graph.get(1).add(new pair(5, 8));

        graph.get(2).add(new pair(4, 4));
        graph.get(2).add(new pair(6, 7));

        graph.get(3).add(new pair(5, 2));
        graph.get(3).add(new pair(6, 6));

        graph.get(4).add(new pair(7, 3));

        graph.get(5).add(new pair(7, 5));
        graph.get(5).add(new pair(8, 4));

        graph.get(6).add(new pair(8, 2));

        graph.get(7).add(new pair(9, 7));

        graph.get(8).add(new pair(9, 1));

        Stack<Integer> st = new Stack<>();
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                travsesal_topology(i, st, visited, graph);
            }
        }

        int[] minpath=new int[n];

        for(int i=0;i<n;i++){
            minpath[i]=Integer.MAX_VALUE;
        }                                                      //  topology   , find_minpath
                                                 // time complexity==O(n+k)+O(n+k)
                                                 // space complexity==O(3n)
        minpath[srcnode]=0;

        while(!st.isEmpty()){
            int node=st.pop();
            int val=minpath[node];
            if(val==Integer.MAX_VALUE) continue;

            for(pair nei:graph.get(node)){
                if(minpath[nei.data]>val+nei.weight){
                    minpath[nei.data]=val+nei.weight;
                }
            }

        }

        System.out.println("the minpath from the source node is   - ");
        for(int i:minpath){
            System.out.print( i+"    ");
        }

    }

    static void travsesal_topology(int node, Stack<Integer> st, int[] visited, ArrayList<ArrayList<pair>> graph) {
        visited[node]=1;
        for(pair i:graph.get(node)){
            if(visited[i.data]==0){
                travsesal_topology(i.data, st, visited, graph);
            }
        }

        st.push(node);
    }
}
