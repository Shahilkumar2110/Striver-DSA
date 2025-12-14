import java.util.Scanner;

public class selectionsort {
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

        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]) min=j;
            }
            if(i!=min){
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;

            }
        }

        showarray(arr);

    }

    public static void showarray(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
