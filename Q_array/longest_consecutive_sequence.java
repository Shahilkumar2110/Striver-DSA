import java.util.Scanner;


// find the longest consecutive sequence in array.
// means 1,2,3,4,   here answer is 4 continue number


//brute solution
// public class longest_consecutive_sequence {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);

//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         int max=Integer.MIN_VALUE;

//         for(int i=0;i<n;i++){           // time complexity of linear search==O(n) 
//             int element=arr[i];            // time complexity of these code is ==O(n^2)
//                                           // space complexity ==O(1)
//             int count=1;
//             while(linearsearch(arr,element+1)){
//                 count++;
//                 element+=1;
//             }
//             max=Math.max(max,count);
//         }

//         System.out.println("the longest consecutive sequance of array is "+max+".");

//         sc.close();
//     }
//     public static boolean linearsearch(int[] arr,int element){

//         for(int i=0;i<arr.length;i++){
//             if(element==arr[i]){
//                 return true;
//             }
//         }
//         return false;
//     }
// }










// better solution 
// import java.util.Arrays;
// public class longest_consecutive_sequence {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);

//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         Arrays.sort(arr);                // time complexity of sorting==O(nlogn)
//                                          // time complexity ==O(n+nlogn)
//                                          // space complexity==O(1)
//         int count=1;
//         int max=1;
        
//         for(int i=1;i<n;i++){
//             if (arr[i] == arr[i - 1] + 1) {   
//                 count++;
//             } 
//             else if (arr[i] != arr[i - 1]) { 
//                 count = 1;
//             }
//             max = Math.max(max, count);
//         }



//         System.out.println("the longest consecutive sequance of array is "+max+".");

//         sc.close();
//     }
    
// }












import java.util.HashSet;
public class longest_consecutive_sequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        System.out.println("enter the total number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        HashSet<Integer> arr2=new HashSet<>();
        for(int element:arr){
            arr2.add(element);                     //Har insert average case me O(1) hota hai.
                                                   //Total = O(n)
        }
        int count=0;
        int max=0;                          
                                            
        for(int element:arr2){
            if(arr2.contains(element-1)){      //Har element ke liye check arr2.contains(element-1) → O(1)
                continue;
            }else{
                while(arr2.contains(element)){             // therefore the overall time complexity ==O(2n)
                                                            // space complexity==O(n)
                    count++;
                    element+=1;
                }
                max=Math.max(max,count);
            }
            count=0;
        }

        System.out.println("the longest consecutive sequance of array is "+max+".");

        sc.close();
    }
    
}