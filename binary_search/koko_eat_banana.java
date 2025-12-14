import java.util.Scanner;


// here we return the minimum integer k such that koko can eat all banana within h hours 
//giver the array where the number of banana is bundle in each piles  


public class koko_eat_banana {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of piles in array: ");
        int n=sc.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("enter the minimum hours you have: ");
        int hour=sc.nextInt();

        





        sc.close();

    }
}
