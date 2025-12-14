import java.util.Scanner;

// find the peak element in sorted array
// arr[index]>arr[index-1] && arr[index]>arr[index+1]
// there are only one peak element in given array 


// here the array is may be incresing order or decresing order or normal array 
// on the time of incresing order the peak element is the last element of array 
// on the time of decresing order the peak element is the first element of array



// public class find_peak_element_sorted_array {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
    
//         int low=1;
//         int high=n-2;
//         int index=-1;
//         while(low<=high){
//             int mid=low+(high-low)/2;

//             if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){
//                 index=mid;
//                 break;
//             }
//             if(arr[mid]>arr[mid+1]){
//                 high=mid-1;
//             }else{
//                 low=mid+1;
//             }
//         }

//         if(index==-1){
//             if(n==2){
//                 if(arr[0]>arr[1]){
//                     index=0;
//                 }else{
//                     index=1;
//                 }
//             }else if(n==1){
//                 index=0;
//             }else if(arr[0]>arr[1]) index=0;
//             else if (arr[0]<arr[1]) index=n-1;
//         }

//         System.out.println("the "+index+"th index element  is the peak element in sorted array of value is "+arr[index]);

//         sc.close();
//     }
// }

















// find the peak element in array
// arr[index]>arr[index-1] && arr[index]>arr[index+1]
// there are multiple peak element in array 
// here the array is may be incresing order or decresing order or normal array 

// on the time of incresing order the peak element is the last element of array 
// on the time of decresing order the peak element is the first element of array
// we have to return single peak element in array 



public class find_peak_element_sorted_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
    
        int low=1;
        int high=n-2;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){
                index=mid;
                break;
            }
            if(arr[mid]>arr[mid+1]){
                high=mid-1;
            }else if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }else{
                high=mid-1;                        // array =1 , 5, 1, 4, 1
                                                   //  here the mid =2 of value is 1 and it not greater than its left and right element
                                                   // therefore we add a addition contition  
            }
        }

        if(index==-1){
            System.out.println("no peak element is present in array ");
        }else{
            System.out.println("the "+index+"th index element  is the peak element in sorted array of value is "+arr[index]);
        }


        sc.close();
    }
}
