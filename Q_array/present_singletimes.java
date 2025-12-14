// find the number that appears once, and the other number twics.

import java.util.Scanner;

// public class present_singletimes {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the number of element in array: ");
//         int n =sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         for(int i=0;i<n;i++){                 // here we use nexted loop 
                                                 // time complexity==O(n^2)
                                                 //space complexity==O(1)
//             int count =0;
//             for(int j=0;j<n;j++){
//                 if(arr[i]==arr[j]){
//                     count++;
//                 }
//             }
//             if(count ==1){
//                 System.out.println("the number which appear single times is "+arr[i]);
//                 break;
//             }
//         }
//     }
// }







// public class present_singletimes {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the number of element in array: ");
//         int n =sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int max=arr[0];
//         for(int element:arr){
//             max=Math.max(max,element);
//         }
//         int[] arr2=new int[max];                   // here we use hashing method 
//                                                    // time complexity==O(3n)
//                                                    //space complexity==O(max number in array)

//         for(int element:arr){
//             arr2[element-1]++;
//         }
//         for(int i = 0; i < arr2.length; i++) {
//             if(arr2[i] == 1) {
//                 System.out.println("The number which appears single time is " + (i + 1));
//                 break;
//             }
//         }
//     }
// }








// import java.util.Set;
// import java.util.HashSet;
// public class present_singletimes {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the number of element in array: ");
//         int n =sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         Set<Integer> map=new HashSet<>();           // here we use set to find it and we use arraylist and other data structure to perform this method 
//                                                     // time complexity==O(n)
//                                                     //space complexity==O(n)
//         for(int i=0;i<n;i++){
//             if(map.contains(arr[i])){
//                 map.remove(arr[i]);
//             }else{
//                 map.add(arr[i]);
//             }
//         }
//         System.out.println("The number(s) which appear single time:");
//         for (int num : map) {
//             System.out.println(num);
//         }
//     }
// }




public class present_singletimes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of element in array: ");
        int n =sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){                  
            arr[i]=sc.nextInt();
        }
        int xor=0;
        for(int element:arr){                 // here we use "XOR"
                                              // time complexity==O(n)
                                              //space complexity==O(1)
            xor^=element;
        }
        System.out.println("The number which appears single time is "+xor);

    }
}
