import java.util.Scanner;


// print all permutaion of given array by recursion.
public class permutation_by_recursion {                        // time complexity == O(n*n!)
                                                               // space complexity == O(n)
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the total number of element in array: ");
        int  n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("the array is : ");
        for(int element:arr){
            System.out.print(element +" ");
        }
        System.out.println();
        System.out.println("the all permutation of array is :");

        permutation(arr,0);

        sc.close();
    }
    public static void permutation(int[] arr,int index){
        if(index==arr.length){
            for(int element :arr){
                System.out.print(element+ " ");
            }
            System.out.println();
            return;
        }
        for(int i=index;i<arr.length;i++){
            int temp=arr[i];
            arr[i]=arr[index];
            arr[index]=temp;
            permutation(arr,index+1);
            temp=arr[i];
            arr[i]=arr[index];
            arr[index]=temp;

        }
        if(index==arr.length){
            for(int element :arr){
                System.out.print(element+ " ");
            }
            System.out.println();
            return;
        }
    }
     
}
