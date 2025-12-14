
import java.util.Scanner;

public class division_no {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<Math.sqrt(n)+1;i++){
            if(n%i==0){
                System.out.println(i+" ");
                if((n/i)!=i){
                    System.out.println(n/i+" ");      // time complexity=O(sqrt(n))
                }
            }
        }
    }
}
