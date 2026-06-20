// Dijkstra's algorithm implemented through Set




import java.util.*;



class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class implement_through_set {

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected weighted graph
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

        int src = 0;

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // {distance, node}
        TreeSet<int[]> set = new TreeSet<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );

        set.add(new int[]{0, src});

        while (!set.isEmpty()) {

            int[] curr = set.first();
            set.remove(curr);

            int dis = curr[0];
            int node = curr[1];

            for (Pair nbr : graph.get(node)) {

                int adjNode = nbr.node;
                int wt = nbr.weight;

                if (dis + wt < dist[adjNode]) {

                    // Remove the old pair if it exists
                    if (dist[adjNode] != Integer.MAX_VALUE) {
                        set.remove(new int[]{dist[adjNode], adjNode});
                    }

                    // Update distance
                    dist[adjNode] = dis + wt;

                    // Insert new pair
                    set.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + dist[i]);
        }
    }
}