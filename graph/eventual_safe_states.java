


// Ye problem Directed Graph ka hai.

// A node is called eventual safe if:
// Us node se start karo
// Jitne bhi paths possible hain
// Sab paths finally kisi terminal node par khatam ho


// Terminal Node kya hota hai?
// Jiske koi outgoing edges nahi hote.


// Unsafe Node  --> Agar kisi node se jaake cycle milta hai, toh unsafe hai.

// return the all safe node of given graph










import java.util.ArrayList;

public class eventual_safe_states {
    public static void main(String[] args) {
        int n = 11;

        // Create graph (1-based indexing)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);

        graph.get(1).add(2);

        graph.get(2).add(3);

        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(6);

        graph.get(5).add(6);

        graph.get(6).add(7);

        graph.get(8).add(1);
        graph.get(8).add(9);

        graph.get(9).add(10);

        graph.get(10).add(8);

        graph.get(11).add(9);

        int[] visited = new int[n + 1];
        int[] pathvis = new int[n + 1];
        int[] safe = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, pathvis, safe, graph);
            }
        }

        System.out.println("Eventual Safe Nodes:");

        for (int i = 0; i <= n; i++) {
            if (safe[i] == 1)
                System.out.print(i + "   ");
        }

    }

    static boolean dfs(int node, int[] visited, int[] pathvis,
                       int[] safe,
                       ArrayList<ArrayList<Integer>> graph) {                    //time complexity==O(n+e)
                                                                                 // space complexity==O(3n)

                                                                                 //in interview , we make this code for better understanding 
                                                                                // if interviewer say for optimize this ,then optimize in single array 

        visited[node] = 1;
        pathvis[node] = 1;
        safe[node]=0;

        for (int nbr : graph.get(node)) {

            if (visited[nbr] == 0) {

                if (dfs(nbr, visited, pathvis, safe, graph)) {
                    safe[node]=0;
                    // cycle found
                    return true;
                }

            } else if (pathvis[nbr] == 1) {
                safe[node]=0;
                // if neighbour already current path me hai
                // means cycle found
                return true;
            }
        }

        // no cycle found
        safe[node] = 1;

        pathvis[node] = 0;

        return false;
    }
}
