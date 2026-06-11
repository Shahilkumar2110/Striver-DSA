
// Course Schedule 1 – Problem
// Given:   Total courses = numCourses
//          Prerequisites list

// Each pair:   [a, b]

// means:  Course a lene se pehle course b complete karo

// Ask:  Kya tum saare courses complete kar sakte ho?

// Return:
// true  -> yes
// false -> no
// solution --> for yes or no we detect the cycle occurance 
// if yes then return false;
//        otherwise return true;

// in course schedule 2 - Problem
// return  -  valid sequence if possible
//            empty list if impossible
// Solution  -->  for return the sequences therefore we use the kahn's algorithm 








import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;



public class course_schedule_1_and_2 {
    public static void main(String[] args) {
        int n= 7;

        int[][] prerequisites = {
                { 1, 0 }, 
                { 2, 0 }, 
                { 3, 1 }, 
                { 3, 2 }, 
                { 4, 1 }, 
                { 5, 3 }, 
                { 5, 4 }, 
                { 6, 2 }, 
                { 7, 5 }, 
                { 7, 6 } 
        };

        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree=new int[n+1];

        for(int i=0;i<=n;i++){
            for(int node:graph.get(i)){
                indegree[node]++;
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
            int node=q.poll();

            result.add(node);
            for(int i:graph.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }

        if(result.size()!=n+1){
            System.out.println("its not possibe to complete all the courses. ");
            return;

        }

        System.out.println("the sequences to complete all the courses is ");

        for(int i:result){
            System.out.print(i+"    ");
        }





        






    }
}
