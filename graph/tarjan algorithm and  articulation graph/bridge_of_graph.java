
// A Bridge is an edge in an undirected graph whose removal increases the number of connected components.
//  return the number of bridge










import java.util.*;

public class bridge_of_graph {
    public static void main(String[] args) {
        int n = 10;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Cycle 1: 0-1-2-3-0
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);

        // Bridge
        adj.get(2).add(4);
        adj.get(4).add(2);

        // Cycle 2: 4-5-6-4
        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(6).add(4);
        adj.get(4).add(6);

        // Bridges
        adj.get(6).add(7);
        adj.get(7).add(6);

        adj.get(7).add(8);
        adj.get(8).add(7);

        // Leaf node
        adj.get(8).add(9);
        adj.get(9).add(8);

        int[] visited = new int[n];
        int[] time_in = new int[n];
        int[] time_low = new int[n];

        List<List<Integer>> result = new ArrayList<>();

        dfs(0, -1, visited, adj, time_in, time_low, result);

        System.out.println("the bridge are " + result);

    }

    static int timer = 1;

    static void dfs(int node, int parent, int[] visited, ArrayList<ArrayList<Integer>> graph, int[] time_in,
            int[] time_low, List<List<Integer>> result) {

        visited[node] = 1;
        time_in[node] = time_low[node] = timer;

        timer++;    

        for (int ele : graph.get(node)) {

            if (ele == parent)
                continue;
            if (visited[ele] == 0) {
                dfs(ele, node, visited, graph, time_in, time_low, result);
                time_low[node] = Math.min(time_low[node], time_low[ele]);
                if (time_in[node] < time_low[ele]) {
                    result.add(Arrays.asList(node,ele));
                }

            } else {

                time_low[node] = Math.min(time_low[node], time_in[ele]);

            }

        }

    }

}
