
// A node is an articulation point if removing it increases the number of connected components.







import java.util.*;

public class implementation_articulation_graph {

    static int timer = 1;

    public static void main(String[] args) {

        int n = 10;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // same graph as yours
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);
        adj.get(3).add(0); adj.get(0).add(3);

        adj.get(2).add(4); adj.get(4).add(2);

        adj.get(4).add(5); adj.get(5).add(4);
        adj.get(5).add(6); adj.get(6).add(5);
        adj.get(6).add(4); adj.get(4).add(6);

        adj.get(6).add(7); adj.get(7).add(6);
        adj.get(7).add(8); adj.get(8).add(7);
        adj.get(8).add(9); adj.get(9).add(8);


        int[] visited = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        
        boolean[] isArticulation = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, -1, visited, adj, tin, low, isArticulation);
            }
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < n; i++) {
            if (isArticulation[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static void dfs(int node, int parent, int[] visited,
                    ArrayList<ArrayList<Integer>> graph,
                    int[] tin, int[] low,
                    boolean[] isArticulation) {

        visited[node] = 1;
        tin[node] = low[node] = timer++;

        int children = 0;

        for (int nei : graph.get(node)) {

            if (nei == parent) continue;

            if (visited[nei] == 0) {

                children++;
                dfs(nei, node, visited, graph, tin, low, isArticulation);

                low[node] = Math.min(low[node], low[nei]);

                // non-root condition
                if (parent != -1 && low[nei] >= tin[node]) {
                    isArticulation[node] = true;
                }

            } else {
                low[node] = Math.min(low[node], tin[nei]);
            }
        }

        // root condition
        if (parent == -1 && children > 1) {
            isArticulation[node] = true;
        }
    }
}