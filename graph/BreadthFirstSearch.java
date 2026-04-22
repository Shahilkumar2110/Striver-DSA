import java.util.*;



public class BreadthFirstSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        int n = 5;

        // Create graph (1-based indexing)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected)
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

        System.out.print("Enter starting node: ");
        int start = sc.nextInt();
                                                                      // space complexity==O(3n)
                                                                      // time complexity=O(n+2e)
                                                                    //   n=nnumber of node,  e=total edge
        List<Integer> result = bfs(graph, start, n);
        System.out.println("BFS Traversal: " + result);
    }

    static List<Integer> bfs(ArrayList<ArrayList<Integer>> graph, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return result;
    }
}