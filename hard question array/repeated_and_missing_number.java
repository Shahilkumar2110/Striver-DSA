import java.util.Scanner;

// given 1 to n number of array where one number is missing and one number is repeated 
// find that number


//brute solution

// public class repeated_and_missing_number {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total element in array:- ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }                                            // time complexity==O(n^2)
//                                                     // space complexity==O(1)

//         int missing=0,repeated=0;

//         for(int i=0;i<n;i++){
//             int count=0;
//             for(int j=0;j<n;j++){
//                 if(arr[j]==i+1){
//                     count++;
//                 }
//             }
//             if(count==0) missing =i+1;
//             else if(count==2) repeated=i+1;
//             if(missing!=0&&repeated!=0) break;
//         }

//         System.out.println("the missing and repeated number of given array is "+missing+" and "+repeated);

//         sc.close();
//     }
// }











// better solution

// public class repeated_and_missing_number {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total element in array:- ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//                                                         //time complexity==O(2n)
//                                                         //space complexity==O(n)
//         int[] hashing=new int[n+1];
//         for(int i=0;i<n;i++){
//             hashing[arr[i]]++;
//         }

//         int missing=0,repeat=0;
//         for(int i=1;i<n+1;i++){
//             if(hashing[i]==0){
//                 missing=i;
//             }
//             else if(hashing[i]==2){
//                 repeat=i;
//             }
//             if(missing!=0&& repeat!=0){
//                 break;
//             }
//         }
//         System.out.println("the missing and repeated number of given array is "+missing+" and "+repeat);

//         sc.close();
//     }
// }
















// optimal solution-1
//here we use maths of 2 variable 

// public class repeated_and_missing_number {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total element in array:- ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }                       
//                                                            // time complexity==O(n)
//                                                            //space complexity==O(1)
//         long missing=0,repeat=0;
//         long sum1=0,sum2=0;
//         for(int i=0;i<n;i++){
//             sum1+=arr[i];
//             sum2+=(arr[i]*arr[i]);
//         }
//         long total1=(n*(n+1))/2;
//         long total2=(n*(n+1)*(2*n+1))/6;

//         long left1=total1-sum1;
//         long left2=total2-sum2;

//         long ad=left2/left1;

//         missing=(ad+left1)/2;
//         repeat=(ad-missing);

//         System.out.println("the missing and repeated number of given array is "+missing+" and "+repeat);

//         sc.close();
//     }
// }














// optimal solution 2
// by use of bit manipulation
// lecture number 41 
// avi nhi bna h 


public class repeated_and_missing_number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the total element in array:- ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }


        




        sc.close();
    }
}
