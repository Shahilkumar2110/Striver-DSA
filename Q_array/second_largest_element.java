import java.util.Scanner;

// public class second_largest_element {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of element in array");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         sort(arr,0,n-1);           //here we use quicksort to sort the array and then find the second largest number in array
//                                         //time complexity== O(nlog(n)+n)
//                                         //space complexity == O(1);


//         int secondmax=arr[n-1];
//         int max=arr[n-1];
//         for(int i=n-2;i>=0;i--){
//             if(secondmax==arr[i]){

//             }else{
//                 secondmax=arr[i];
//                 break;
//             }
//         }
//         if(max==secondmax){
//             System.out.println("here no any second largest element is present. ");
//         }else{
//             System.out.println("the second largest number in array is: "+secondmax);

//         }



//     }
//     public static void sort(int[] arr,int start,int high){
//         if(start<high){
//             int index=quicksort(arr,start,high);
//             sort(arr,start,index-1);
//             sort(arr,index+1,high);
//         }
//     }
//     public static int quicksort(int[] arr,int low,int high){
//         int pivot=high;
//         int i=low-1;
//         for(int j=low;j<high;j++){
//             if(arr[j]<=arr[pivot]){
//                 i++;
//                 int temp=arr[i];
//                 arr[i]=arr[j];
//                 arr[j]=temp;
//             }
//         }
//         i++;
//         int temp=arr[i];
//         arr[i]=arr[pivot];
//         arr[pivot]=temp;
//         return i;
//     }
// }




public class second_largest_element {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the number of element in array");
        int n=sc.nextInt();
        if (n < 2) {
            System.out.println("Second largest doesn't exist.");
            return;
        }
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int max=Integer.MIN_VALUE;
        int second_max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){                       // here we use simple method to find the second largest number in array
                                                    // time complexity==O(n)
                                                    // space complexity==O(1)
            if(arr[i]>max){
                second_max=max;
                max=arr[i];
            }else if(arr[i]<max&&arr[i]>second_max){
                second_max=arr[i];
            }
            
        }
        if(max==second_max){
            System.out.println("here no second largest element is present: ");
        }else{
            System.out.println("the second largest number is: "+second_max);
        }


        
    }
}
