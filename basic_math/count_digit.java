
import java.util.Scanner;

public class count_digit{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        // while(n>0){
        //     count++;
        //     System.out.print(n%10+" ");
        //     n/=10;
        // }
        // System.out.println("");     // time-complexity= O(log10(n))


        count = (int)(Math.log10(n)+1); // time-complexity= O(log10(n))
        System.out.println(count);
    }
}