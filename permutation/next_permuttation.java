import java.util.Scanner;

public class next_permuttation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the total number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("the present array is : ");
        show(arr);
                                          // time complexity==O(3n)
                                          // space complexity==O(1)
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index=i;
                break;
            }
        }
        if(index!=-1){
        for(int i=n-1;i>=0;i--){
            if(arr[index]<arr[i]){
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
                break;
            }
        }}
        int limit=(n-index-1)/2;

        for(int i=1;i<=limit;i++){
            int temp=arr[index+i];
            arr[index+i]=arr[n-i];
            arr[n-i]=temp;
        }

        System.out.println("the next permutation array is : ");
        show(arr);

        sc.close();
    }
    public static void show(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    } 
}
