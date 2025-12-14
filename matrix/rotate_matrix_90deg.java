import java.util.Scanner;


//brute solution
// its work on both number of row and column are eual aur may be not 
// public class rotate_matrix_90deg{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);

//         System.out.println("enter the number of rows and columns :");
//         int row=sc.nextInt();
//         int column=sc.nextInt();

//         int[][] matrix=new int[row][column];

//         for(int i=0;i<row;i++){
//             for(int j=0;j<column;j++){
//                 matrix[i][j]=sc.nextInt();
//             }
//         }

//         int[][] matrix2=new int[column][row];

//         System.out.println("matrix before applying algorithm: ");
//         show(matrix);
//                                                                  // time complexity==O(n^2)
//                                                                  // space complexity==O(n^2)
//         for(int i=0;i<row;i++){
//             for(int j=0;j<column;j++){
//                 matrix2[j][row-i-1]=matrix[i][j];
//             }
//         }

//         System.out.println("matrix after applying algorithm :");
//         show(matrix2);

//         sc.close();
//     }
//     public static void show(int[][] matrix){
//         for(int[] row: matrix){
//             for(int element:row){
//                 System.out.print(element+" ");
//             }
//             System.out.println();
//         }
//     }
// }










//optimal solution
// its only work on number of row and columnn are equal:

public class rotate_matrix_90deg{
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        System.out.println("enter the number of rows and columns :");
        int n=sc.nextInt();

        int[][] matrix=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        System.out.println("matrix before applying algorithm: ");
        show(matrix);

        for(int i=0;i<n;i++){                       // here we convert the row into column        
            for(int j=0;j<n;j++){
                if(i==j) break;
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }                                                  

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){                     // here we reverse all the row in matrix
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }                          // time complexity==O(n^2)
                                   // space complexity==O(1)

        System.out.println("matrix after applying algorithm :");
        show(matrix);

        sc.close();
    }
    public static void show(int[][] matrix){
        for(int[] row: matrix){
            for(int element:row){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
