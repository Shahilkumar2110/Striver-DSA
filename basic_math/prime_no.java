
import java.util.Scanner;

public class prime_no {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        
        int n=sc.nextInt();
        int count=0;
        for(int i=2;i<Math.sqrt(n)+1;i++){
            if(n%i==0){
                count++;
                break;
            }
        }
        if(count==0) System.out.println(n+" is the prime number.");
        else System.out.println(n+" is not the prime number.");
    }
}
