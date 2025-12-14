import java.util.Scanner;

// public class missing_number_ItoN {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n-1];
//         for(int i=0;i<n-1;i++){
//             arr[i]=sc.nextInt();
//         }

//         for(int i=0;i<n-1;i++){                 // here we directly use nexted loop 
                                                   // time complexity== O(n^2)
                                                   //space complexity==O(1)
//             boolean present=false;
//             for(int j=0;j<n-1;j++){
//                 if(i+1==arr[j]){
//                     present=true;
//                     break;
//                 }
                
//             }
//             if(!present){
//                     System.out.println("the "+(i+1)+" element is not present in array. ");
//                     return ;
//                 }
//         }
//         System.out.println("the "+n+" element is not present in array. ");

//     }
// }



// public class missing_number_ItoN {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n-1];
//         for(int i=0;i<n-1;i++){
//             arr[i]=sc.nextInt();
//         }

//         int[] temp=new int[n];                 // here we use hashing method to find the missing number 
//                                                // time complexity== O(2n)
//                                                // space complexity==O(n)

//         for(int i=0;i<n-1;i++){

//             temp[arr[i]-1]++;
//         }
//         for(int i=0;i<n;i++){
//             if(temp[i]==0){
//                 System.out.println("the missing element is "+(i+1)+" in array: ");
//             }
//         }
//     }
// }



// public class missing_number_ItoN {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n-1];
//         for(int i=0;i<n-1;i++){              // here we use math formula to sum of 1 to n terms 
//                                              // time complexity ==O(n)
//                                              //sapce complexity==O(1)
//                                              //but we can't prefer this method to find missing number between 1 to n 
//                                              // due to the sum of the largest number is not store in int data type   
//             arr[i]=sc.nextInt();
//         }

//         int total =(n*(n+1))/2;
//         int sum=0;
//         for(int element:arr){
//             sum+=element;
//         }

//         System.out.println("the missing element is "+(total-sum)+" in the array: ");
//     }
// }




public class missing_number_ItoN {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n-1];
        for(int i=0;i<n-1;i++){
            arr[i]=sc.nextInt();
        }
        int xor1=0;
        int xor2=0;                //here we use xor method to find missing number
                                   // time complexity==O(n)
                                   //space complexity==O(1)
                                   // xor never be exited his limit 
        for(int i=0;i<n-1;i++){
            xor1^=arr[i];
            xor2^=(i+1);
        }
        xor2^=n;
        System.out.println("the missing element is "+(xor1^xor2)+" in the array: ");
    }
}
