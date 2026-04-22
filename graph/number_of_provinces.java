import java.util.*;



public class number_of_provinces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 7;

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

        graph.get(6).add(7);

        graph.get(7).add(6);

        boolean[] visited=new boolean[n+1];
        int count=0;
        for(int i=1;i<n+1;i++){
            if(!visited[i]){
                count++;
                traversal(graph,i,visited);
            }
        }

        System.out.println("total number of provinces is "+count);

        
    }
    static void traversal(ArrayList<ArrayList<Integer>> graph, int start,boolean[] visited){
                                                                    // space complexity==0(n)+O(n)
                                                                    // time complexity==O(n)+O(2*e)
                                                                     // e=numebr of edge 
        visited[start]=true;
        for(int neigh:graph.get(start)){
            if(!visited[neigh]){
                traversal(graph,neigh,visited);
            }
        }

    }
}
