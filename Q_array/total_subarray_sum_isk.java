import java.util.Scanner; 

// we calculate total number of subarray of sum is k.
// the array contain negative and positive number both.

//brute solution
// public class total_subarray_sum_isk {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total number of element in array");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("enter the number to be match: ");
//         int k=sc.nextInt();
//                                                        // time complexity==O(n^2)
//                                                        // space complexity==O(1)
//         int count=0;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=arr[j];
//                 if(sum==k){
//                 count++;
//                 }
//             }
            
//         }
//         System.out.println("the total number of subarray of sum is equal to "+k+" is "+count +".");
        
//         sc.close();
//     }
// }













//optimal solution
import java.util.HashMap;
public class total_subarray_sum_isk {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the total number of element in array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the number to be match: ");
        int k=sc.nextInt();

        System.out.println();
        HashMap<Integer,Integer> map=new HashMap<>();


        // Average case: O(1)  --- for get value and to check contains  
        // Worst case: O(n)--------for get value and to check contains

        int count=0;
        int sum=0;                              // time complexity==O(n)
                                                // space complexity==O(n)
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem=sum-k;
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }

            map.put(sum,map.getOrDefault(map.get(sum),0)+1);
            
            
        }

        System.out.println("the total number of subarray of sum is equal to "+k+" is "+count +".");
        
        sc.close();
    }
}


