import java.util.Scanner;

// here we have given a sorted array in which every element appears twice except for one element which appears only once
//and we have to find that single element which appears only once


// brute solution 
// public class single_element_sorted_array {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the number of element in array: ");

//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//                                                      // here we search the every element with her left and right element
//                                                      // time complexity==O(n)
//                                                      // space complexity==O(1) 
//         for(int i=0;i<n;i=i+2){
//             if(i==n-1 || arr[i]!=arr[i+1]){
//                 System.out.println("the single element in given array is "+arr[i]);
//                 break;
//             }
//         }
//         sc.close();
//     }
// }





















// optimal solution

public class single_element_sorted_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of element in array: ");

        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int left =1;
        int right =n-2;
        int index=-1;

        while(left<=right){
            if(n==1){
                index=0;
                break;
            }

            if(arr[0]!=arr[1]){
                index=0;
                break;
            }
            if(arr[n-1]!=arr[n-2]){
                index=n-1;
                break;
            }
            

            int mid=left+(right-left)/2;

            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]){
                index=mid;
                break;
            }
            if(mid%2==0){
                if(arr[mid]==arr[mid+1]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(arr[mid]==arr[mid-1]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        if(index==-1){
            System.out.println("all the element in array is sorted ");
        }else{
            System.out.println("the "+index+"th index element  is unique element in given array of value is "+arr[index]);
        }



        sc.close();
    }
}