
// You are given:
// An array  of numbers.
// A start value.
// An end value.

// In one operation, you can choose any number x from arr and do:
//                                                          -->  newValue=(currentValue×x)mod100000
// Your task is to find the minimum number of multiplications needed to reach end from start value.
// If it is impossible, return -1.




import java.util.*;


public class minimum_multiplication_to_reach_dst {
    public static void main(String[] args) {
        int[] arr   = {2, 3, 7};
        int start = 5;
        int end  = 60480;

        // int[] arr   = {3, 4, 65};
        // int start = 7;
        // int end  = 66175;


        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{start,0});

        int[] steps=new int[100000];
        Arrays.fill(steps,Integer.MAX_VALUE);
        steps[start]=0;
        
                                                                         // time complexity==O(100000*length of array )---> this is most hypothetical time complexity
                                                                          //  due to in pratical life its impossible to cover all the number between 1 to 100000
        while(!q.isEmpty()){
            int[] nod=q.poll();

            int node=nod[0];
            int step=nod[1];
            
            for(int ele:arr){

                int value=(node*ele)%100000;

                if(step+1<steps[value]){
                    steps[value]=step+1;
                    if(value==end){
                        System.out.println("total step to reach the end value is "+(step+1));
                        return;
                    }
                    q.add(new int[]{value,step+1});
                }

            }

        }
        System.out.println("there is no way to reach the end value. ");
        

    }
}
