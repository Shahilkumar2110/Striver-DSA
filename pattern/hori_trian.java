import java.util.Scanner;
public class hori_trian {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("enter the value of line or rows: ");
        int n=sc.nextInt();
        // sc.nextLine();
        for (int i=0;i<n/2;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        int m=0;
        if(n%2==0) m=n/2;
        else m=n/2-1;
        for (int i=m;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        
        
    }
}
