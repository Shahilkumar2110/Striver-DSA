import java.util.Scanner;

// the sum of 4 number is = tarket
// arr[i]+arr[j]+arr[k]+arr[l]=target value
// where i != j != k != l


// brute solution

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Collections;
// public class sum_4_isequalto_k {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         System.out.println("enter the target to match :");
//         int target=sc.nextInt();                                // time complexity==O(n^4)
//                                                                 // space complexity==O(number of quadratic)

//         HashSet<ArrayList> list=new HashSet<>();
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 for(int k=j+1;k<n;k++){
//                     for(int l=k+1;l<n;l++){
//                         long sum=arr[i]+arr[j]+arr[k]+arr[l];
//                         if(sum==target){
//                             ArrayList<Integer> quars=new ArrayList<>();
//                             quars.add(arr[i]);
//                             quars.add(arr[j]);
//                             quars.add(arr[k]);
//                             quars.add(arr[l]);
//                             Collections.sort(quars);
//                             list.add(quars);
//                         }
//                     }
//                 }
//             }
//         }

//         System.out.println("the total combination of four element in array are: ");
//         System.out.println(list);

//         sc.close();
//     }
// }















// better solution

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Collections;
// public class sum_4_isequalto_k {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("enter the target to match :");
//         int target=sc.nextInt();
//                                                                  // time complexity==O(n^3 * log(number of quadratic ))
//                                                                  // space complexity==O(n + number of quadratic)

//         HashSet<ArrayList> list=new HashSet<>();
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 ArrayList<Integer> available =new ArrayList<>();
//                 for(int k=j+1;k<n;k++){
//                     int sum=arr[i]+arr[j]+arr[k];
//                     int remains=target-sum;
                    
//                     if(available.contains(remains)){
//                         ArrayList<Integer> arr2=new ArrayList<>();
//                         arr2.add(arr[i]);
//                         arr2.add(arr[j]);
//                         arr2.add(arr[k]);
//                         arr2.add(remains);
//                         Collections.sort(arr2);
//                         list.add(arr2);
//                     }
//                     available.add(arr[k]);
//                 }
//             }
//         }
//         System.out.println("the total combination of four element in array are: ");
//         System.out.println(list);



//         sc.close();
//     }
// }



















// optimal solution

import java.util.Arrays;
import java.util.ArrayList;
public class sum_4_isequalto_k {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the total number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the target to match :");
        int target=sc.nextInt();

        Arrays.sort(arr);
        ArrayList<ArrayList> list=new ArrayList<>();
                                                            // time complexity==O(n^3)
                                                            // space complexity==O(number of quadratic )
        for(int i=0;i<n;i++){
            if(i!=0&&arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int k=j+1,l=n-1;
                while(k<l){
                    int sum=arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum>target){
                        l--;
                    }else if(sum<target){
                        k++;
                    }else if(sum==target){
                        ArrayList<Integer> arr2=new ArrayList<>();
                        arr2.add(arr[i]);
                        arr2.add(arr[j]);
                        arr2.add(arr[k]);
                        arr2.add(arr[l]);
                        list.add(arr2);
                        k++;
                        l--;
                        while(k<l&&arr[k]==arr[k-1]) k++;
                        while(k<l&&arr[l]==arr[l+1]) l--;
                    }
                }
            }
        }
        System.out.println("the total combination of four element in array are: ");
        System.out.println(list);
        sc.close();
    }
}



