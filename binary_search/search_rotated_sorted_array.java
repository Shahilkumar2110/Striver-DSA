import java.util.Scanner;

//   given a array of which some part of array are rotate in rigth side of sorted array
//   you have to find the index where the target is found.
//    arr[]==[7,8,9,1,2,3,4,5]    target==x
//    target =1  then return 3
//    find the x value in array and return the index





// for unique element in array 

// public class search_rotated_sorted_array{
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
        
//         int low=0;
//         int high=n-1;
//         int index=-1;

//         while(low<=high){
//             int mid=low+(high-low)/2;
//             if(arr[mid]==target){
//                 index=mid;
//                 break;
//             }
//             if(arr[low]<=arr[mid]){   // --------> if left array is sorted  
//                 if(arr[mid]>=target&&arr[low]<=target){
//                     high=mid-1;
//                 }else{
//                     low=mid+1;
//                 }
//             }else{            // ------------------> if right array is sorted 
//                 if(arr[mid]<=target&&arr[high]>=target){
//                     low=mid+1;
//                 }else{
//                     high=mid-1;
//                 }
//             }

//         }

//         if(index==-1){
//             System.out.println("target value is not found in given array");
//         }else{
//             System.out.println("the index of target element is "+index);
//         }

//         sc.close();
//     }
// }





















// for duplicate element present in array
// array = [3,1,2,3,3,3,3,3,3]
//   arr[low]==arr[mid]==arr[high]=3
//   therefore we cannot determint the sorted part of array 
//   then we trim the array by low++;  high--; and make small the size of array



// public class search_rotated_sorted_array{
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
        
//         int low=0;
//         int high=n-1;
//         int index=-1;                                 //time complexity==O(log n base 2) 

//         while(low<=high){
//             int mid=low+(high-low)/2;
//             if(arr[mid]==target){
//                 index=mid;
//                 break;
//             }
//             if(arr[low]==arr[mid]&&arr[high]==arr[mid]){  // when arr[low],arr[mid],arr[high] are equal
//                 low++;
//                 high--;
//                 continue;
//             }

//             if(arr[low]<=arr[mid]){   // --------> if left array is sorted  
//                 if(arr[mid]>=target&&arr[low]<=target){
//                     high=mid-1;
//                 }else{
//                     low=mid+1;
//                 }
//             }else{            // ------------------> if right array is sorted 
//                 if(arr[mid]<=target&&arr[high]>=target){
//                     low=mid+1;
//                 }else{
//                     high=mid-1;
//                 }
//             }

//         }

//         if(index==-1){
//             System.out.println("target value is not found in given array");
//         }else{
//             System.out.println("the index of target element is "+index);
//         }
        
//         sc.close();
//     }
// }

















// find minimum element in rotated sorted array

// here every element is unique in array



// public class search_rotated_sorted_array{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];

//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
        
//         int low=0;
//         int high=n-1;
//         int index=0;

//         while(low<=high){
//             int mid=low+(high-low)/2;
//             if(arr[low]<=arr[mid]){   // --------> if left array is sorted  
//                 if(arr[low]<arr[index]){
//                     index=low;
//                 }
//                 low=mid+1;
//             }else{            // ------------------> if right array is sorted 
//                 if(arr[mid]<arr[index]){
//                     index=mid;
//                 }
//                 high=mid-1;
//             }

//         }

//         if(index==-1){
//             System.out.println("the minimum element is not found in given array");
//         }else{
//             System.out.println("the index of minimum element in array is "+index);
//         }
        
//         sc.close();
//     }
// }























// find minimum element in rotated sorted array

// here duplicate element present in array


public class search_rotated_sorted_array{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int low=0;
        int high=n-1;
        int index=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[low]==arr[mid]&&arr[high]==arr[mid]){  // when arr[low],arr[mid],arr[high] are equal
                if(arr[low]<arr[index]){
                    index=low;
                }
                low++;
                high--;
                continue;
            }
            if(arr[low]<=arr[mid]){   // --------> if left array is sorted  
                if(arr[low]<arr[index]){
                    index=low;
                }
                low=mid+1;
            }else{            // ------------------> if right array is sorted 
                if(arr[mid]<arr[index]){
                    index=mid;
                }
                high=mid-1;
            }

        }

        if(index==-1){
            System.out.println("the minimum element is not found in given array");
        }else{
            System.out.println("the index of minimum element in array is "+index);
        }
        
        sc.close();
    }
}


