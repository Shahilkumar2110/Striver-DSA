import java.util.Scanner;

// lower bound ===> smallest index such that ---> arr[index]>=target --in sorted array 



// public class lower_bound {
//     public static void main(String[] args) {
        
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];

//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();                             
//         }                                                        //time complexity==O(log n  base 2)
//         System.out.println("enter the target to be searched the lower bound:- ");
//         int target=sc.nextInt();
        
//         int low=0;
//         int high=n-1;

//         int index=n;
//         while(high>=low){
//             int mid=low+(high-low)/2;
//             if(arr[mid]>=target){
//                 index=mid;
//                 high=mid-1;
//             }else{
//                 low=mid+1;
//             }
//         }
//         System.out.println("the lowest bound in array of target is "+ index);
//         sc.close();
//     }
// }












// upper bound ===>smallest index such that ---> arr[index]>target --in sorted array 


// public class lower_bound {
//     public static void main(String[] args) {
        
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];

//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         System.out.println("enter the target to be searched the upper bound:- ");
//         int target=sc.nextInt();
        
//         int low=0;
//         int high=n-1;

//         int index=n;
//         while(high>=low){
//             int mid=low+(high-low)/2;
//             if(arr[mid]>target){
//                 index=mid;
//                 high=mid-1;
//             }else{
//                 low=mid+1;
//             }
//         }
//         System.out.println("the lowest bound in array of target is "+ index);
        
//         sc.close();
//     }
// }












// floor and ceil in sorted array 
// floor -----> largest number in array <=target
// ceil  -----> smallest number in array >=target



public class lower_bound {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("enter the target to be searched the floor and ceil:- ");
        int target=sc.nextInt();

        int low=0,high=n-1;
        int floor=-1;
        int ceil=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                ceil =mid;
                high=mid-1;
            }else{
                floor=mid;
                low=mid+1;
            }
        }

        System.out.println("the floor and ceil index of array is "+floor+" and "+ceil+".");



        
        sc.close();
    }
}


