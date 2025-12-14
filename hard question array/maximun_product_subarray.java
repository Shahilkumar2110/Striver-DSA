import java.util.Scanner;

// find maximum produxt of subarray in array


//brute solution

// public class maximun_product_subarray {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the total number of element in array:- ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }                                   // time complexity==O(n^2)
//                                             // space complexity==O(1)

//         long max=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             long product=1;
//             for(int j=i;j<n;j++){
//                 product*=arr[j];
//                 max=Math.max(max,product);
//             }
//         }
//         System.out.println("the maximum product of subarray is "+max);

//         sc.close();
//     }
// }













// optimal solution

public class maximun_product_subarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the total number of element in array:- ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        long max=Integer.MIN_VALUE;
        int left=1,right=1;                      // time complexity==O(n)
                                                 // space complexity==O(1)

        for(int i=0;i<n;i++){
            if(left==0) left=1;
            if(right==0) right=1;
            left*=arr[i];
            right*=arr[n-1-i];
            max=Math.max(max,Math.max(left,right));
        }

        System.out.println("the maximum product of subarray is "+max);

        sc.close();
    }
}
