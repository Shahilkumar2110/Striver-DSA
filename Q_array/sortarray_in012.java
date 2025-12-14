import java.util.Scanner;

// array only involved 1,2,3 where we can only rearrange it 

// public class sortarray_in012 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("enter the total element in array: ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         System.out.println("enter the value of array of 0,1,and 2: ");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         System.out.println("before the array is: ");
//         show(arr);                                       // here we use sort to arrange the 0 as first , 1 as second and 3 as last 

//         quicksort(arr, 0, n - 1);                    // time complexity==O(nlog(n))
//                                                          // space complexity==O(1)
//         System.out.println("after the algorithm apply, arra is: ");
//         show(arr);

//         sc.close();
//     }

//     public static void show(int[] arr) {
//         for (int element : arr) {
//             System.out.print(element + " ");
//         }
//         System.out.println();
//     }

//     public static void quicksort(int[] arr, int low, int high) {
//         if (low < high) {
//             int ind = sort(arr, low, high);
//             quicksort(arr, low, ind - 1);
//             quicksort(arr, ind + 1, high);
//         }
//     }

//     public static int sort(int[] arr, int low, int high) {
//         int i = low + 1, j = high;
//         int pivot = low;
//         while (i < j) {
//             while (i <= high && arr[i] <= arr[pivot]) {
//                 i++;
//             }
//             while (j >= 0 && arr[j] > arr[pivot]) {
//                 j--;
//             }
//             if (j > i) {
//                 int temp = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = temp;
//             }
//         }
//         int temp=arr[j];
//         arr[j]=arr[pivot];
//         arr[pivot]=temp;

//         return j;
//     }
// }









// public class sortarray_in012 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("enter the total element in array: ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         System.out.println("enter the value of array of 0,1,and 2: ");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         System.out.println("before the array is: ");
//         show(arr);

//         int count0=0,count1=0,count2=0;
//         for(int element:arr){
//             if(element==0) count0++;
//             else if(element==1) count1++;
//             else count2++;
//         }
//         for(int i=0;i<count0;i++){                 // here we first count number of zero , one and two, ki kitne baar aaya h 
                                                       // time complexity==O(2n)
                                                    //    space complexity==O(1)
//             arr[i]=0;
//         }
//         for(int i=count0;i<count0+count1;i++){
//             arr[i]=1;
//         }
//         for(int i=count0+count1;i<n;i++){
//             arr[i]=2;
//         }
//         System.out.println("after the algorithm apply, arra is: ");
//         show(arr);

//         sc.close();
//     }
//     public static void show(int[] arr) {
//         for (int element : arr) {
//             System.out.print(element + " ");
//         }
//         System.out.println();
    
//     }
// }










// Dutch national flag algorithm using to solve these problem 
// public class sortarray_in012 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("enter the total element in array: ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         System.out.println("enter the value of array of 0,1,and 2: ");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         System.out.println("before the array is: ");
//         show(arr);

//         int low=0;int mid=0;int high=n-1;
//         while(mid<=high){                             // time complexity==O(n)
                                                        // space complexity==O(1) 
//             if(arr[mid]==0){
//                 int temp=arr[mid];
//                 arr[mid]=arr[low];
//                 arr[low]=temp;
//                 low++;
//                 mid++;
//             }else if(arr[mid]==1){
//                 mid++;
//             }else{
//                 int temp=arr[high];
//                 arr[high]=arr[mid];
//                 arr[mid]=temp;
//                 high--;
//             }
//         }
//         System.out.println("after the algorithm apply, array is: ");
//         show(arr);

//         sc.close();
//     }

//     public static void show(int[] arr) {
//         for (int element : arr) {
//             System.out.print(element + " ");
//         }
//         System.out.println();
    
//     }
// }








