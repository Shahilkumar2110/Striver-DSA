import java.util.Scanner;

// find the nth position of pascel triangle where given is rows and columns number.

public class pascel_nth_position {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        System.out.println("enter the rows and column number of pascel triangle: ");
        int row=sc.nextInt();
        int column=sc.nextInt();

        System.out.println("the value of "+row+"th row position and "+column+"th column position is "+value(row-1,column-1));

        sc.close();
    }
    public static int value(int row,int col){
                                                               // time complexity==O(col)
                                                               // space complexity==O(1)
        int ans=1;             
        for(int i=0;i<col;i++){
            ans*=(row-i);
            ans/=(i+1);
        }

        return ans;
    }
}
