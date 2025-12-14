
// hcf and gcd (greatest common division of two number. )
import java.util.Scanner;
public class GCD {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();

        while(num1>0&&num2>0){
            if(num1>num2) num1=num1%num2;
            else num2=num2%num1;
            if(num1==0) {System.out.println(num2);
            break;}
            
            if(num2==0) {System.out.println(num1);
            break;}
        }



    }
}
