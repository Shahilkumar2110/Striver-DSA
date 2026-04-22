import java.util.*;

class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class first_graph_representation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes and edges:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Pair>> graph = new ArrayList<>();

        // 1-based indexing
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter u v weight:");

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w)); // undirected
        }

        // print (1-based)
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (Pair p : graph.get(i)) {
                System.out.print("(" + p.node + "," + p.weight + ") ");
            }
            System.out.println();
        }

        sc.close();
    }
}