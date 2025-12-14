import java.util.Scanner;

// find majority element atleast (size of array/2)

// brute  solution
// public class majority_element {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();

//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int element =-1;                          // we use nexted loop
//                                                   // tiime complexity==O(n^2)
//                                                   // space complexity==O(1)
//         for(int i=0;i<n;i++){
//             int count =0;
//             for(int j=0;j<n;j++){
//                 if(arr[i]==arr[j]){
//                     count++;
//                 }
//             }
//             if(count>n/2){
//                 element=arr[i];
//                 break;
//             }
//         }
//         if(element!=-1){
//             System.out.println("the majority element among array is "+element);
//         }else{
//             System.out.println("no any element is greater than "+n/2);
//         }
//         sc.close();
//     }
// }








// better solution
// import java.util.HashMap;
// import java.util.Map;        // --->it is unordered map therefore it take O(n) to search the element and other activity
// public class majority_element {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();

//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         HashMap<Integer,Integer> arr2=new HashMap<>();
//                                                                // time complexity==O(2n)
//                                                                //space complexity==O(n)
//         for(int element:arr){
//             arr2.put(element,arr2.getOrDefault(element,0)+1);
//         }
//         for (Map.Entry<Integer , Integer> done : arr2.entrySet()){
//             if(done.getValue()>n/2){
//                 System.out.println("the majority element among array is "+done.getKey());
//                 break;
//             }
//         }
//         sc.close();
//     }
// }










// Moore's Voting Algorithm
// public class majority_element {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();

//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int element=arr[0];
//         int count =0; 
//         for(int i=0;i<n;i++){               //time complexity==O(2n)
//                                             //space complexity==O(1)
//             if(count ==0){
//                 count++;
//                 element=arr[i];
//             }
//             if(element ==arr[i]){
//                 count++;
//             }else{
//                 count--;
//             }
//         }
//         count =0;
//         for(int number:arr){
//             if(element==number){
//                 count++;
//             }
//         }
//         if(count>n/2){
//             System.out.println("the majority element among array is "+element);
//         }else{
//             System.out.println("no one element is greater than "+n/2);
//         }
//         sc.close();
//     }
// }




