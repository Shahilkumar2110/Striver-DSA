import java.util.Scanner;

public class diamond {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of column: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n/2;i++){
            for(int j=i+1;j<n/2;j++){
                System.out.print(" ");
            }

            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        int m=n/2;

        for(int i=0;i<n/2;i++){

            for(int j=0;j<i;j++){
                System.out.print(" ");
            }

            for(int j=0;j<2*((m-i))-1;j++){
                System.out.print("*");
            }

            System.out.println("");
        }
    }
}
