import java.util.Scanner;


// given a 2D array where element in matrix is in sorted order and k target  
// return the index of target element in matrix 
// 
// **** ---> every individual row and column are in sorted order 
// 
//   1    4    7    11    15     every row and column are sorted individually
//   2    5    8    12    19
//   3    6    9    16    22
//   10   13   14   17    24
//   18   21   23   26    30





public class search_element_in2D_array_II {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the row of matrix: ");
        int n=sc.nextInt();
        System.out.println("enter the coloum of matrix: ");
        int m=sc.nextInt();

        int[][] mat=new int[n][m];
        System.out.println("the value of matrix: ");
        for(int i=0;i<n;i++){
            System.out.println("value of "+i +"th row ");
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter the number to be search in matrix: ");
        int target=sc.nextInt();
        
        show(mat,n,m);
        
        int low=0,high=m-1;
        int row=-1;
        int coloum=-1;

        while(low<n&&high>=0){
            if(mat[low][high]==target){
                row=low;
                coloum=high;
                break;
            }else if(mat[low][high]>target){
                high--;
            }else{
                low++;
            }
        }
        System.out.println("the target element is in index of "+row +"th rows and "+coloum+"th coloum");

        sc.close();
    }
    public static void show(int[][] mat,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
