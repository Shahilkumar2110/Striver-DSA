import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;




// detect cycle in undirected graph by bft(breadth first tree)






class pair {
    int curr, pre;
    pair(int c, int p) {
        curr = c;
        pre = p;
    }
}

public class detect_cycle_in_undirected_graph {

    public static void main(String[] args) {

        int n = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // edges
        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(1);
        graph.get(2).add(4);
        graph.get(2).add(5);

        graph.get(3).add(1);
        graph.get(3).add(4);

        graph.get(4).add(2);
        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(2);
        graph.get(5).add(4);

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (bfs(i, graph, visited)) {
                    System.out.println("Graph has a cycle");
                    return;
                }
            }
        }

        System.out.println("Graph has no cycle");
    }

    static boolean bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(start, -1));

        visited[start] = true;

        while (!q.isEmpty()) {
            pair node = q.poll();

            for (int neigh : graph.get(node.curr)) {

                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(new pair(neigh, node.curr));
                } else if (neigh != node.pre) {
                    return true; 
                }
            }
        }

        return false;
    }
}