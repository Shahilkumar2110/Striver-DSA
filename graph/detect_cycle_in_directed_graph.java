
// detect cycle in directed graph 















import java.util.ArrayList;

public class detect_cycle_in_directed_graph {
    public static void main(String[] args) {
        int n = 10;

        // Create graph (1-based indexing)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);

        graph.get(2).add(3);

        graph.get(3).add(4);
        graph.get(3).add(7);

        graph.get(4).add(5);

        graph.get(5).add(6);

        graph.get(7).add(5);

        graph.get(8).add(2);
        graph.get(8).add(9);

        graph.get(9).add(10);

        // graph.get(10).add(8);

        int[] visited = new int[n + 1];
        int[] pathvis = new int[n + 1];
        boolean cycle = false;

        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                if (detect_cycle(i, visited, pathvis, graph)) {
                    cycle = true;
                    break;
                }
            }
        }

        if (cycle) {
            System.out.println("graph have cycle ");
            return;
        } else {
            System.out.println("no cycle in given graph ");
        }

    }

    static boolean detect_cycle(int start, int[] visited, int[] pathvis, ArrayList<ArrayList<Integer>> graph) {
                                                                    //  time complexity==O(n+e)
                                                                    // space complexity==O(2n) ,   n=number of nodes 
        visited[start]=1;
        pathvis[start]=1;

        for(int node:graph.get(start)){
            if(visited[node]==0){
                if(detect_cycle(node, visited, pathvis, graph)){
                    return true;
                }
            }else{
                if(pathvis[node]==1) return true;
            }
        }
        pathvis[start] = 0;
        return false;

    }

}
