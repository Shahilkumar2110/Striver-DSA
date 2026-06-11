


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
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;



public class eventual_safe_states_by_topology_sort {
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

        ArrayList<ArrayList<Integer>> reverse=new ArrayList<>();
        for(int i=0;i<=n;i++){
            reverse.add(new ArrayList<>());
        }
                                                                           // time complexity==O(n+e) +O(nlogn)
                                                                           // space complexxity===O()
        int[] indegree=new int[n+1];

        for(int i=0;i<=n;i++){
            for(int node:graph.get(i)){
                reverse.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        ArrayList<Integer> result=new ArrayList<>();

        while(!q.isEmpty()){
            int node =q.poll();
            result.add(node);

            for(int nod:reverse.get(node)){
                indegree[nod]--;
                if(indegree[nod]==0){
                    q.add(nod);
                }
            }


        }

        Collections.sort(result);

        System.out.println("the eventual safe state node is ");
        for(int i:result){
            System.out.print(i+"      ");
        }





    }
}
