
import java.util.Scanner;

public class armstrong_no {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int temp=n;
        int digit=(int)(Math.log10(n)+1);
        double sum=0d;
        while(n>0){
            sum=sum+Math.pow((n%10),digit);
            n/=10;
        }
        if(sum==temp) System.out.println(temp+" is a armstrong number");
        else System.out.println(temp+" is not a armstrong number");
    }
}
