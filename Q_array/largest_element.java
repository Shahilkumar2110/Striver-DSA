import java.util.Scanner;

// public class largest_element {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         sort(arr,0,n-1);
//         System.out.println("the sorted array is:-");
//         for(int element:arr){
//             System.out.print(element+" ");
//         }
//         System.out.println();

//         System.out.println("the largest number is "+arr[n-1]);

//     }
//     public static void sort(int[] arr,int start,int high){
//         if(start<high){                                       //we use quick sort to sort the array and then find the largest number in array
//                                                              // time complexity=== O(nlog(n))
//                                                              // space complexity== O(1)
//             int index=quicksort(arr,start,high);
//             sort(arr,start,index-1);
//             sort(arr,index+1,high);
//         }
//     }
//     public static int quicksort(int[] arr,int low,int high){
//         int i=low+1,j=high;
//         int pivot=low;
//         while(i<=j){
//             while(i<=high&&arr[i]<=arr[pivot]){
//                 i++;
//             }
//             while(j>=low&&arr[j]>arr[pivot]){
//                 j--;
//             }
//             if(i<j){
//                 int temp=arr[i];
//                 arr[i]=arr[j];
//                 arr[j]=temp;
//             }
//         }
//         int temp=arr[pivot];
//         arr[pivot]=arr[j];
//         arr[j]=temp;
//         return j;
//     }
    
// }



public class largest_element {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
                                               // simple method to find largest number in array
                                               // time complexity ==O(n)
                                               // space complexity ==O(1) 
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max) max=arr[i];
        }

        System.out.println("the largest number of given array is: "+max);

    }
}
