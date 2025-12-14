import java.util.Scanner;


// binary search by loop 

// public class binary_search {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("enter the target to be searched:- ");
//         int target=sc.nextInt();
        
//         int low=0,high=n-1;

//         int index=-1;
//         while(low<=high){
//             int mid=low+(high-low)/2;
//             if(arr[mid]==target) {
//                 index=mid;
//                 break;
//             }else if(arr[mid]>target) high=mid-1; 
//             else low=mid+1;
//         }

//         if(index==-1) System.out.println("target element is not found in array.");
//         else System.out.println("the index of target in array is "+index);

//         sc.close();
//     }
// }










// binary search by recursion 

public class binary_search {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the target to be searched:- ");
        int target=sc.nextInt();
        
        int index =found(arr,0,n-1,target);
        
        if(index==-1) System.out.println("target element is not found in array.");
        else System.out.println("the index of target in array is "+index);

        sc.close();
    }

    public static int found(int[] arr,int low,int high,int target){
        if(low>high) return -1;
        int mid=low+(high-low)/2;
        if(arr[mid]==target) return mid;
        else if(arr[mid]>target) return found(arr,low,mid-1,target);
        else return found(arr,mid+1,high,target);
    }

}
