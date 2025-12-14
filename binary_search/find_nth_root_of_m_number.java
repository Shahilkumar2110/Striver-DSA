import java.util.Scanner;


// brute solution

// here on larger number of m is overflow occer in power method to conclude the power of mid 


// public class find_nth_root_of_m_number {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         System.out.println("enter the number: ");
//         int m=sc.nextInt();
//         System.out.println("enter the root to be concluded: ");
//         int n=sc.nextInt();

//         int low=1;
//         int right=m;
//         int rt=-1;

//         while(low<=right){
//             int mid=low+(right-low)/2;
//             int value=power(mid,n);

//             if(value==m){
//                 rt=mid;
//                 break;
//             }else if(value<m){
//                 low=mid+1;
//             }else{
//                 right=mid-1;
//             }
//         }

//         if(rt!=-1){
//         System.out.println("the root of number is "+ rt);
//         }else{
//             System.out.println("the "+n+"th root of "+m+" is not present. ");
//         }
//         sc.close();
//     }
//     public static int power(int number,int pow){
//         int result=1;
//         while(pow>0){
//             if(pow%2==1){
//                 result*=number;
//                 pow--;
//             }else{
//                 number*=number;
//                 pow/=2;
//             }
//         }
//         return result;
//     }
// }













// optimal solution 
// here we resolve the overflow problem in conclude the power of mid 

public class find_nth_root_of_m_number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number: ");
        int m=sc.nextInt();
        System.out.println("enter the root to be concluded: ");
        int n=sc.nextInt();

        int low=1;
        int right=m;
        int rt=-1;

        while(low<=right){
            int mid=low+(right-low)/2;
            long value=power(mid,n,m);
            
            if(value==0){
                right=mid-1;
                continue;
            }else if(value==m){
                rt=mid;
                break;
            }else if(value<m){
                low=mid+1;
            }else{
                right=mid-1;
            }
        }

        if(rt!=-1){
        System.out.println("the root of number is "+ rt);
        }else{
            System.out.println("the "+n+"th root of "+m+" is not present. ");
        }
        sc.close();
    }


// return 0 for number exceed the number 
// otherwise return the mid of power n
    public static long power(int mid,int pow,int number){
        long result=1;
        for(int i=0;i<pow;i++){
            result*=mid;
            if(result>number) return 0;
        }
        return result;
    }
}
