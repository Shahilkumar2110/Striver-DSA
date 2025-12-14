
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int temp=n;
        int reverse=0;
        
        while(n>0){
            
            reverse=reverse*10+n%10;
            
            n/=10;
        }
        n=temp;
        
        if(n==reverse) System.out.println(n+" is the palindrome number");
        else System.out.println(n+" is not the palindrome number");
    }
}
