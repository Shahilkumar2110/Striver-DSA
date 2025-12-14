import java.util.Scanner;

// find total number of subarray of take XOR of that subarray is equal to target element.

// brute solution

// public class total_subarray_of_xor_is_k {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total number of array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("enter the target number: ");
//         int target=sc.nextInt();
        
//         int count=0;                       // time complexity==O(n^2)
//                                           // space complexity==O(1)
//         for(int i=0;i<n;i++){
//             int xor=0;
//             for(int j=i;j<n;j++){
//                 xor^=arr[j];
//                 if(xor==target){
//                     count++;
//                 }
//             }
//         }
//         System.out.println("the total number of subarray of xor is "+target+"  are "+ count);

//         sc.close();
//     }
// }


















// optimal solution 

import java.util.HashMap;
public class total_subarray_of_xor_is_k {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the total number of array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the target number: ");
        int target=sc.nextInt();
                                                              // time complexity==O(n)
                                                              // space complexity==O(n)
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int xor=0;
        int count=0;
        for(int i=0;i<n;i++){
            xor^=arr[i];
            int remains=xor^target;
            if(map.containsKey(remains)){
                count+=map.get(remains);
            }
            map.put(xor,map.getOrDefault(xor, 0)+1);
        }
        System.out.println("the total number of subarray of xor is "+target+"  are "+ count);

        sc.close();
    }
}
