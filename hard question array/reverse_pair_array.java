import java.util.Scanner;


// here array is [5,3,2,4,1]
//i<j  and arr[i]>2*arr[j]   where i and j is index.


// optimal solution

public class reverse_pair_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int count=mergesort(arr,0,n-1);
                                                                                    // time complexity==O(2n logn n)
                                                                                    // space complexity==O(n)  
        System.out.println("the total number of reverse which follow the condition is "+count);

        sc.close();
    }
    public static int mergesort(int[] arr,int low,int high){
        int count=0;
        if(low<high){
            int mid=low+(high-low)/2;
            count+=mergesort(arr,low,mid);
            count+=mergesort(arr,mid+1,high);
            count+=merge(arr,low,high,mid);
        }
        return count;
    }
    public static int merge(int[] arr ,int low, int high,int mid){
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

        int count=0;
        int i=0,j=0;
        while(i<n1&&j<n2){
            if(arr1[i]>2*arr2[j]){
                count+=(n1-i);
                j++;
            }else{
                i++;
            }
        }
        i=0;j=0;
        int k=low;

        while(i<n1&&j<n2){
            if(arr1[i]>arr2[j]){
                arr[k++]=arr2[j++];
            }else{
                arr[k++]=arr1[i++];
            }
        }
        while(i<n1){
            arr[k++]=arr1[i++];
        }
        while(j<n2){
            arr[k++]=arr2[j++];
        }

        return count;



    }
}
