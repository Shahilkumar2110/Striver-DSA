


import java.util.*;

public class implementation_of_floyd_warshall_algorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the total nodes in graph ");
        int V = sc.nextInt();

        int[][] dist = new int[V][V];

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                System.out.println("node "+i+"th  to node "+j+"th");
                dist[i][j] = sc.nextInt();
            }
        }

        // Floyd-Warshall                  // time complexity==O(n ^ 3)
                                           // space somplexity==O(n ^ 2)
        for(int k = 0; k < V; k++) {
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {

                    if(dist[i][k] != 1000000 &&
                       dist[k][j] != 1000000) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        System.out.println("Shortest Distance Matrix:");

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}