import java.util.Scanner;
// find subarray of maximum sum in array which included negative , positive and zero number 


//brute method 
// public class maximum_subarray_sum{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int max=Integer.MIN_VALUE;
//         int sum=0;                             // time complexity==O(n^2)
//                                                // space complexity==O(1)
//         for(int i=0;i<n;i++){
//             sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=arr[j];
//                 max=Integer.max(max,sum);
//             }
//         }
//         System.out.println("the maximum subarray sum is : "+max);
        
//     }
// }








// Optimal solution

// kadane's algorithm 
// public class maximum_subarray_sum{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int max=Integer.MIN_VALUE;
//         int sum=0;
//         int start=-1;
//         int end=-1;
//         int str=-1;
//         boolean done=false;                    // time complexity==O(n)
//                                               // space complexity==O(1)
//         for(int i=0;i<n;i++){
//             if(sum==0&&done ==false) {
//                 str=i;
//                 done=true;
//             }
//             sum+=arr[i];
//             max=Integer.max(max,sum);
//             if(max==sum){
//                 start=str;
//                 end=i;
//             }
//             if(sum<0) {sum=0;
//                 done=false;
//             }
//         }
//         System.out.println("the maximum subarray sum is : "+max);
//         System.out.println("and the subarray index is "+start+" to "+end);

//     }
// }