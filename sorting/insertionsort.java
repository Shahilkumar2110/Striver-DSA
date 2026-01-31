import java.util.Scanner;

public class insertionsort {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("enter the total element in array you want: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("enter the value of array: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        showarray(arr);

        sort(arr,n);

        showarray(arr);

    }

    public static void showarray(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    // public static void sort(int[] arr,int n){
    //     for(int i=1;i<n;i++){               // insertion sort by simple methed
    //         for(int j=i;j>0;j--){
    //             if(arr[j]<arr[j-1]){
    //                 int temp=arr[j];
    //                 arr[j]=arr[j-1];
    //                 arr[j-1]=temp;
    //             }else{
    //                 break;
    //             }
    //         }
    //     }
    // }
    

    public static void sort(int[] arr,int n){
        if(n<=1) return ;
        for(int i=arr.length-n+1;i>0;i--){    // insertion sort by using recursion
            if(arr[i-1]>arr[i]){
                int temp=arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;
            }else{
                break;
            }
        }
        
        sort(arr,n-1);
        
    }

}
