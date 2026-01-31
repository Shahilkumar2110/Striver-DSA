import java.util.Scanner;

// given two sorted array of different length, find the median of two array
// time limit in O(min(log(n),log(m))), where n is length of arr1 and m is length of arr2
   


// // brute force 
// public class median_of_two_array {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter length of array1: ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         System.out.println("enter the value of array1 in sorted order: ");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         System.out.println("Enter length of array2: ");
//         int m = sc.nextInt();
//         int[] arr2 = new int[m];
//         System.out.println("enter the value of array2 in sorted order: ");
//         for (int i = 0; i < m; i++) {
//             arr2[i] = sc.nextInt();
//         }                                                         // time complexity==O(n+m)
//                                                                   // space complexity==O(n+m)

//         int total=n+m;
//         int[] result=new int[total];
//         int i=0;
//         int j=0;
//         int k=0;
//         while(i<n&&j<m){
//             if(arr[i]>arr2[j]){
//                 result[k++]=arr2[j++];
//             }else{
//                 result[k++]=arr[i++];
//             }
//         }
//         while(i<n){
//             result[k++]=arr[i++];
//         }
//         while(j<n){
//             result[k++]=arr2[j++];
//         }

//         if(total%2==0){
//             System.out.println("the median of array is "+(result[total/2-1]+result[total/2])/2.0);
//         }else{
//             System.out.println("the median of array is "+result[total/2]);
//         }
//         sc.close();
//     }
// }







// better solution than brute force

// public class median_of_two_array {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter length of array1: ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         System.out.println("enter the value of array1 in sorted order: ");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         System.out.println("Enter length of array2: ");
//         int m = sc.nextInt();
//         int[] arr2 = new int[m];
//         System.out.println("enter the value of array2 in sorted order: ");
//         for (int i = 0; i < m; i++) {
//             arr2[i] = sc.nextInt();
//         } 
//                                                              // time complexity==O(n)
//                                                              // space complexity==O(1)
//         double result=median(arr,arr2);

//         System.out.println("the median of array is "+result);

//         sc.close();
//     }
//     public static double median(int[] arr1,int[] arr2){
//         int n = arr1.length;
//         int m = arr2.length;

//         int i = 0, j = 0;
//         int count = 0;

//         int mid = (n + m) / 2;
//         int prev = 0, curr = 0;

//         while (count <= mid) {
//             prev = curr;

//             if (i < n && (j >= m || arr1[i] <= arr2[j])) {
//                 curr = arr1[i++];
//             } else {
//                 curr = arr2[j++];
//             }
//             count++;
//         }

//         if ((n + m) % 2 == 0) {
//             return (prev + curr) / 2.0;
//         } else {
//             return curr;
//         }
//     }
// }






// optimal solution
// time complexity==O(min(log(n),log(m)))
// space complexity==O(1)

public class median_of_two_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of array1: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the value of array1 in sorted order: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter length of array2: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.println("enter the value of array2 in sorted order: ");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        double result = median(arr, arr2);

        System.out.println("the median of array is " + result);

        sc.close();
    }

    public static double median(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if (n > m)
            return median(arr2, arr1);

        int low = 0, high = n;
        int totalLeft = (n + m + 1) / 2;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = totalLeft - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int r1 = (cut1 == n) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : arr2[cut2];

            if (Math.max(l1, l2) <= Math.min(r1, r2)) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;

    }
}
