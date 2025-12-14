import java.util.Scanner;

// here array is [5,3,2,4,1]
//i<j  and arr[i]>arr[j]   where i and j is index.

// the inverse is (5,3),(5,2),(5,4),(5,1),(3,2),(3,1),(2,1),(4,1)
// total is 8 



//brute solution

// public class count_inversion_array {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];                 
//                                                  // time complexity==O(n^2)
//                                                  // space complexity==O(1)
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(arr[i]>arr[j]) count++;
//             }
//         }
//         System.out.println("the total number of inverse which follow the condition is "+count);

//         sc.close();
//     }
// }

















// optimal solution
// by use of merge sort theorem in this question

public class count_inversion_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int count=mergesort(arr,0,n-1);

        System.out.println("the total number of inverse which follow the condition is "+count);

        sc.close();
    }

    public static int mergesort(int[] arr,int low,int high){
        int count=0;
        if(low<high){
            int mid=low+((high-low)/2);
            count+=mergesort(arr,low,mid);
            count+=mergesort(arr,mid+1,high);
            count+=sort(arr,low,high,mid);

        }
        return count;
    }

    public static int sort(int[] arr,int low,int high,int mid){
        int n1=mid-low+1;
        int n2=high-mid;
        int[] arr1=new int[n1];
        int[] arr2=new int[n2];

        for(int i=0;i<n1;i++){
            arr1[i]=arr[low+i];
        }
        for(int i=0;i<n2;i++){
            arr2[i]=arr[mid+1+i];
        }

        int i=0,j=0;
        int count=0;
        // while(i<n1&&j<n2){
            
        //     if(arr1[i]>arr2[j]){
        //         count+=(n1-i);
        //         j++;
        //     }else{
        //         i++;
        //     }
        // }                               // time complexity==O(nlog n)
                                        // space complexity==O(n)

        i=0;
        j=0;
        int k=0;
        while(i<n1&&j<n2){
            if(arr1[i]>arr2[j]){
                arr[k+low]=arr2[j];
                count+=(n1-i);
                k++;j++;
            }else{
                arr[k+low]=arr1[i];
                k++;i++;
            }
        }

        while(i<n1){
            arr[k+low]=arr1[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k+low]=arr2[j];
            k++;j++;
        }

        return count;
    }


}