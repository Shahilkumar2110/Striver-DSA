import java.util.Scanner;
public class simple{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of column: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=n;i>0;i--){

            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            
            for(int j=0;j<2*i-1;j++){
                System.out.print("*");
            }
             
            System.out.println("");
        }
    }
}