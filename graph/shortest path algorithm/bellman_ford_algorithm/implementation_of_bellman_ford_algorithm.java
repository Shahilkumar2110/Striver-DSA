



import java.util.*;

public class implementation_of_bellman_ford_algorithm {

    static class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number of node ");
        int V = sc.nextInt();
        System.out.println("enter the number of edge in graph ");
        int E = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            System.out.println("for "+i+"th edge ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            edges.add(new Edge(u, v, wt));
        }

        System.out.println("enter the scr node ");
        int src = sc.nextInt();

        bellmanFord(V, edges, src);
    }

    static void bellmanFord(int V, ArrayList<Edge> edges, int src) {               //time complexity ==O(v*e) 
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.wt < dist[e.v]) {

                    dist[e.v] = dist[e.u] + e.wt;
                }
            }
        }

        // Check negative cycle
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE &&
                dist[e.u] + e.wt < dist[e.v]) {

                System.out.println("Negative Weight Cycle Found");
                return;
            }
        }

        System.out.println("Shortest Distances:");
        for (int i = 0; i < V; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }
}