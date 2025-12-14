import java.util.Scanner;

// here we print a specific row in pascel triangle 

// brute solution
// public class pascel_any_given_row {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the row number: ");
//         int row=sc.nextInt();                                     //time complexity==O(row*col)
//                                                                   //space complexity==O(1)

//         System.out.print("the "+row+"th row of pascel triange is : ");
//         for(int i=0;i<row;i++){
//             System.out.print(value(row-1,i)+"  ");
//         }

//         sc.close();
//     }
//     public static int value(int row,int col){
//         int ans=1;
//         for(int i=0;i<col;i++){
//             ans*=(row-i);
//             ans/=(i+1);
//         }
//         return ans;
//     }
// }












// optimal solution

public class pascel_any_given_row {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the row number: ");
        int row=sc.nextInt();                                     //time complexity==O(row)
                                                                  //space complexity==O(1)

        System.out.print("the "+row+"th row of pascel triange is : ");
        
        int ans=1;
        System.out.print(1+"  ");
        for(int i=0;i<row-1;i++){
            ans *=(row-i-1);
            ans/=(i+1);
            System.out.print(ans+"  ");
        }

        sc.close();
    }
    
}



