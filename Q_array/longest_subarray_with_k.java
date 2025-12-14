import java.util.Scanner;


// find longest subarray of sum is k

// public class longest_subarray_with_k{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total element in array");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("enter the value which is match: ");
//         int k=sc.nextInt();
//         int maxlen=0;
//         for(int i=0;i<n;i++){                               // it work on number include either positive , negative and zero .
//                                                             // time complexity== O(n^2)
//                                                             // space complexity==O(1)
//             int sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=arr[j];
//                 if(sum==k){
//                     maxlen=Math.max(maxlen,j-i+1);
//                     break;
//                 }
//             }
//         }
// System.out.println("the maximum subarray of array which sum is "+ k+" of length is "+maxlen);

//         sc.close();
//     }
// }







// import java.util.HashMap;
// public class longest_subarray_with_k{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total element in array");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("enter the value which is match: ");
//         int k=sc.nextInt();

//         HashMap<Integer,Integer> arr2=new HashMap<>();
//         int sum=0;
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){                         // this code is only for positive number in array aur without duplicates
//                                                       // time complexity ==O(n)
//                                                       //space complexity==O(n)
//             sum+=arr[i];
//             if(sum==k){
//                 max=Math.max(max,i+1);
//             }

//             int left=sum-k;
//             if(arr2.containsKey(left)){
//                 max=Math.max(max,i-(arr2.get(left)));
//             }

//             arr2.put(sum,i);

//         }

//         System.out.println("the maximum subarray of array which sum is "+ k+" of length is "+max);
//         sc.close();
//     }
// }







// import java.util.HashMap;
// public class longest_subarray_with_k{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total element in array");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("enter the value which is match: ");
//         int k=sc.nextInt();

//         HashMap<Integer,Integer> arr2=new HashMap<>();
//         int sum=0;
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){                         // this code is for positive , negative and zero.
//                                                       // time complexity ==O(n)
//                                                       //space complexity==O(n)
//             sum+=arr[i];
//             if(sum==k){
//                 max=Math.max(max,i+1);
//             }

//             int left=sum-k;
//             if(arr2.containsKey(left)){
//                 max=Math.max(max,i-(arr2.get(left))+1);
//             }
//             if(!arr2.containsKey(sum)){
//                 arr2.put(sum,i);
//             }

//         }

//         System.out.println("the maximum subarray of array which sum is "+ k+" of length is "+max);
//         sc.close();
//     }
// }







public class longest_subarray_with_k{
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the total element in array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the value which is match: ");
        int k=sc.nextInt();

        int i=0,j=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(i<n){                                         // this code only for positive number in array
                                                            // time complexity==O(2n)
                                                            // space complexity==O(1)
            
                sum+=arr[i];
                i++;
            while(sum>k&&j<=i){
                sum-=arr[j++];
            }
            
            if(sum==k){
                max=Math.max(max,i-j);
            }
        }
        System.out.println("the maximum subarray of array which sum is "+ k+" of length is "+max);
        sc.close();
    }
}
