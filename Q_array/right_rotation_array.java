import java.util.Scanner;

public class right_rotation_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the total number of element in array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("enter the number to push the element in right side:");
        int d=sc.nextInt();
        d%=n;
        System.out.println("before rearrangement the array");
        show(arr);
        // firstly reverse last d element in array
        reverse(arr,n-d,n-1);                                     // time complexity ==O(2n)
                                                                  // space complexity==O(1) 
        // then reverse first n-d element in array
        reverse(arr,0,n-d-1);
        // finally reverse the complete array
        reverse(arr,0,n-1);


        System.out.println();
        System.out.println("after the rearrangement the array");
        show(arr);


    }
    public static void show(int[] arr){
        for(int element:arr){
            System.out.print(element +" ");
        }
    }
    public static void reverse(int[] arr,int start,int end){
        int i=start;
        int j=end;
        while(j>i){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;j--;
        }
    }
}
