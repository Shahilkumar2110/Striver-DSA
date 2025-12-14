import java.util.Scanner;

// sum of 3 element in array = 0
// where arr[i]+arr[j]+arr[k]=0
// i  !=  j  !=  k


//brute solution
// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Collections;
// public class sum_3_isequalto_zero {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         HashSet<ArrayList> list=new HashSet<>();
        
//         for(int i=0;i<n;i++){                                   // time complexity==O(n^3*log(number of triplet))
//                                                                 // space complexity==O(2*number of triplet)
//             for(int j=i+1;j<n;j++){
//                 for(int k=j+1;k<n;k++){
//                     if(arr[i]+arr[j]+arr[k]==0){
//                         ArrayList<Integer> arr2=new ArrayList<>();
//                         arr2.add(arr[i]);
//                         arr2.add(arr[j]);
//                         arr2.add(arr[k]);
//                         Collections.sort(arr2);
//                         list.add(arr2);
//                     }
//                 }
//             }
//         }
//         System.out.println("the all element of array where add is zero are :");
//         System.out.println(list);

//         sc.close();
//     }
// }













// better solution
// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Collections;
// public class sum_3_isequalto_zero {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         HashSet<ArrayList> list=new HashSet<>();
//                                                                    // time complexity==O(n^2*log(number of m))   where m is size of available
//                                                                    // space complexity==O(n+ number of triplet)
//         for(int i=0;i<n;i++){
//             ArrayList<Integer> available=new ArrayList<>();
//             for(int j=i+1;j<n;j++){
//                 int k=-(arr[i]+arr[j]);
//                 if(available.contains(k)){
//                     ArrayList<Integer> triplet=new ArrayList<>();
//                     triplet.add(arr[i]);
//                     triplet.add(arr[j]);
//                     triplet.add(k);
//                     Collections.sort(triplet);

//                     list.add(triplet);
//                 }
//                 available.add(arr[j]);

//             }
//         }

//         System.out.println("the all list of triplet are: ");
//         System.out.println(list);

//         sc.close();
//     }
// }
















// optimal solution
import java.util.ArrayList;
import java.util.Arrays;
public class sum_3_isequalto_zero {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the total number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);                                    // time complexity==O(n^2)+O(nlogn)
                                                            // space complexity==O(number of triplet)
        ArrayList<ArrayList> list=new ArrayList<>();
         for(int i=0;i<n;i++){
            if(i>0&&arr[i]==arr[i-1]) continue;
            int j=i+1,k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    ArrayList<Integer> triplet=new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[j]);
                    triplet.add(arr[k]);
                    list.add(triplet);
                    j++;
                    k--;
                    while(j<k&&arr[j]==arr[j-1]){
                        j++;
                    }
                    while(j<k&&arr[k]==arr[k+1]){
                        k--;
                    }
                }
            }
         }
         System.out.println("the total triplet of sum is zero :");
         System.out.println(list);

        sc.close();
    }
}
