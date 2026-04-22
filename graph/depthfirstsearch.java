import java.util.*;

public class depthfirstsearch {
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

        ArrayList<Integer> result = funct(graph, start, n);
        System.out.println("D.F.S traversal is " + result);
    }

    static ArrayList<Integer> funct(ArrayList<ArrayList<Integer>> graph, int start, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                result.add(node);

                for (int neigh : graph.get(node)) {
                    if (!visited[neigh]) {
                        stack.push(neigh);
                    }
                }
            }
        }

        return result;
    }

    //  2nd way to dfs by recursion 

    // static ArrayList<Integer> funct(ArrayList<ArrayList<Integer>> graph, int start, int n) {
    //     ArrayList<Integer> result = new ArrayList<>();
    //     boolean[] visited = new boolean[n + 1];

    //     dfs(graph, start, visited, result);
    //     return result;                                            // time complexity==O(n)+O(2*e) where e=number of edge , this is only for undirected graph 
                                                                     //  for directed gragh its depent on number of edge 
                                                                     // space complexity==O(n)+o(n)+O(n)
                                                                //             storing the data,  visited  ,   recursion call
    // }
    // static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, ArrayList<Integer> result) {
    //     visited[node] = true;
    //     result.add(node);

    //     for (int neigh : graph.get(node)) {
    //         if (!visited[neigh]) {
    //             dfs(graph, neigh, visited, result);
    //         }
    //     }
    // }

}
