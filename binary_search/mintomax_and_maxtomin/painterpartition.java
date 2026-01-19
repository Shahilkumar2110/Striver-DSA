import java.util.Scanner;
import java.util.Arrays;



// Ek array diya hota hai
// k workers / painters / students / partitions diye hote hain
// Tumhe array ko k parts me todna hota hai
// Aisa divide karo ki sabse bada part (sum) me se minimum sum return kro
// simple rule:-
// subarray should be continuous manner
// Empty subarray are not allowed
// Har part me at least 1 element hona chahiye
// Order change nahi kar sakte




public class painterpartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of element in array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the values:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of subarray to be divided (subarray must be smaller or equal to number of element in array: ): ");
        int k = sc.nextInt();

        if(k>n){
            System.out.println("not possible");
            return ;
        }

        int[] arr2=Arrays.copyOf(arr, n);

        int low=arr2[n-1];
        int high=0;
        for(int i=k-1;i<n;i++){
            high+=arr2[i];
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int count=1;
            int total=0;
            for(int i=0;i<n;i++){
                if(total+arr[i]<=mid){
                    total+=arr[i];
                }else{
                    count++;
                    total=arr[i];
                }
            }
            if(count>k){
                low=mid+1;
            }else{
                high=mid-1;
            }


        }


        System.out.println("the result is "+low);

        sc.close();
    }
}
