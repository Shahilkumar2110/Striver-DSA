import java.util.Scanner;


//  find all the leading element in array .
//leading means everynumber on the right should be smaller 



public class leader_in_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        System.out.println("enter the total number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }  
                                                    // time complexity==O(n)
                                                    //space complexity==O(1)

        System.out.println("the present array is : ");
        show(arr);

        int max=arr[n-1];
        System.out.println("the leading number of array is :");
        System.out.print(max+" ");
        for(int i=n-2;i>=0;i--){
            if(arr[i]>max){
                System.out.print(arr[i]+" ");
            }
            max=Math.max(arr[i],max);
        }

        sc.close();
    }
    public static void show(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
