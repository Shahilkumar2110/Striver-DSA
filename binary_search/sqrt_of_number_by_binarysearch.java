import java.util.Scanner;

// return the square root of number of by binary root method 



public class sqrt_of_number_by_binarysearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number: ");
        int n=sc.nextInt();
        int low=1;
        int right=n;
        int sqrt=-1;

        while(low<=right){
            int mid=low+(right-low)/2;
            if(mid*mid<=n){
                sqrt=mid;
                low=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println("the square root of number is "+sqrt);
        sc.close();
    }
}
