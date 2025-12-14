import java.util.Scanner;

// there are two array where we can sort it without extra space 
// arr1 and arr2 are in sorted array 
// arr1={3,4,6,8}  and arr2={1,2,5,7,9}
// after applying algorithm 
// arr1={1,2,3,4} and arr2={5,6,7,8,9}



//brute solution
// by using extra space 

// public class merge_sort_without_space {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the size of array1 and array2: ");
//         int n=sc.nextInt();
//         int m=sc.nextInt();
//         int[] arr1=new int[n];
//         int[] arr2=new int[m];
//         System.out.println("enter the value of array 1: ");
//         for(int i=0;i<n;i++){
//             arr1[i]=sc.nextInt();
//         }
//         System.out.println("enter the value of array 2: ");
//         for(int i=0;i<m;i++){
//             arr2[i]=sc.nextInt();
//         }

//         System.out.println("before applying algorithm: ");
//         System.out.println("array1 are:- ");
//         show(arr1);
//         System.out.println("array2 are:- ");
//         show(arr2);                                                     // time complexity==O(n+m)+O(n+m)
//                                                                         // space complexity==O(n+m)
//         int[] array=new int[n+m];
//         int i=0,j=0,k=0;

//         while(i<n&&j<m){
//             if(arr1[i]>arr2[j]){
//                 array[k++]=arr2[j++];
//             }else{
//                 array[k++]=arr1[i++];
//             }
//         }
//         while(i<n){
//             array[k++]=arr1[i++];
//         }
//         while(j<m){
//             array[k++]=arr2[j++];
//         }
//         for(k=0;k<n+m;k++){
//             if(k<n){
//                 arr1[k]=array[k];
//             }else{
//                 arr2[k-n]=array[k];
//             }
//         }

//         System.out.println("after applying algorithm: ");
//         System.out.println("array1 are:- ");
//         show(arr1);
//         System.out.println("array2 are:- ");
//         show(arr2);

//         sc.close();
//     }
//     static public void show(int[] arr){
//         for(int element:arr){
//             System.out.print(element+"  ");
//         }
//         System.out.println();
//     }
// }












// optimal solution-1

// import java.util.Arrays;
// public class merge_sort_without_space {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the size of array1 and array2: ");
//         int n=sc.nextInt();
//         int m=sc.nextInt();
//         int[] arr1=new int[n];
//         int[] arr2=new int[m];
//         System.out.println("enter the value of array 1: ");
//         for(int i=0;i<n;i++){
//             arr1[i]=sc.nextInt();
//         }
//         System.out.println("enter the value of array 2: ");
//         for(int i=0;i<m;i++){
//             arr2[i]=sc.nextInt();
//         }

//         System.out.println("before applying algorithm: ");
//         System.out.println("array1 are:- ");
//         show(arr1);
//         System.out.println("array2 are:- ");
//         show(arr2); 
//                                                         //time complexity==O(min(m,n))+O(nlog n)+O(mlog m)
//                                                         //space complexity==O(1)
//         int i=n-1,j=0;
//         while(i>=0&&j<m){
//             if(arr1[i]>arr2[j]){
//                 int temp=arr1[i];
//                 arr1[i]=arr2[j];
//                 arr2[j]=temp;
//                 i--;
//                 j++;
//             }else{
//                 break;
//             }

//         }
//         Arrays.sort(arr1);
//         Arrays.sort(arr2);

//         System.out.println("after applying algorithm: ");
//         System.out.println("array1 are:- ");
//         show(arr1);
//         System.out.println("array2 are:- ");
//         show(arr2);

//         sc.close();
//     }
//     static public void show(int[] arr){
//         for(int element:arr){
//             System.out.print(element+"  ");
//         }
//         System.out.println();
//     }
// }











// optimal solution 2
// gap technique/method which is work in shell sort algorithm

public class merge_sort_without_space {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the size of array1 and array2: ");
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];
        System.out.println("enter the value of array 1: ");
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println("enter the value of array 2: ");
        for(int i=0;i<m;i++){
            arr2[i]=sc.nextInt();
        }

        System.out.println("before applying algorithm: ");
        System.out.println("array1 are:- ");
        show(arr1);
        System.out.println("array2 are:- ");
        show(arr2); 
                                                                    // time complexity==O(log(n+m) ofbase 2)+O(n+m)
                                                                    // space complexity==O(1)
        int len=m+n;
        int gap=(len/2)+len%2;
        while(gap>0){
            int left=0,right=left+gap;
            while(right<len){
                if(left<n&&right>=n){
                    swap(arr1,arr2,left,right-n);
                }else if(left>=n){
                    swap(arr2,arr2,left-n,right-n);
                }else{
                    swap(arr1,arr1,left,right);
                }
                left++;
                right++;
            }
            if(gap==1) break;
            gap=(gap/2)+(gap%2);
        }

        System.out.println("after applying algorithm: ");
        System.out.println("array1 are:- ");
        show(arr1);
        System.out.println("array2 are:- ");
        show(arr2);

        sc.close();
    }
    static public void show(int[] arr){
        for(int element:arr){
            System.out.print(element+"  ");
        }
        System.out.println();
    }

    static public void swap(int[] arr1,int[] arr2,int index1,int index2){
        if(arr1[index1]>arr2[index2]){
            int temp=arr1[index1];
            arr1[index1]=arr2[index2];
            arr2[index2]=temp;
        }
    }
}
