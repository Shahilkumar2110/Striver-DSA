import java.util.Scanner;

// the matrix only contain 0 and 1 element 
// the position which is zero are completely convert into zero row and column 
//   1   1   1           1  0  1
//   1   0   1   ---->   0  0  0
//   1   1   1           1  0  1 


//brute solution
// public class set_matrix_zero {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of rows and columns in square matrix ");
//         int n=sc.nextInt();
//         int[][] matrix=new int[n][n];
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 matrix[i][j]=sc.nextInt();
//             }
//         }
//         System.out.println("before matrix is :");
//         show(matrix);
//                                                   //time complexity==O(n^3)
//                                                   // space complexity==O(1)
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]==0){
//                     for(int k=0;k<n;k++){
//                         if(matrix[k][j]==1){
//                             matrix[k][j]=-1;
//                         }
//                         if(matrix[i][k]==1){
//                             matrix[i][k]=-1;
//                         }
//                     }
//                 }
//             }
//         }

//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]==-1){
//                     matrix[i][j]=0;
//                 }
//             }
//         }

//         System.out.println("after applying algorithm , the array is:");
//         show(matrix);

//         sc.close();
//     }
//     public static void show (int[][] mat){
//         for(int[] row:mat){
//             for(int j:row){
//                 System.out.print(j+" ");
//             }
//             System.out.println();
//         }
//     }
// }














// better solution

// public class set_matrix_zero {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of rows and columns in square matrix ");
//         int n=sc.nextInt();
//         int[][] matrix=new int[n][n];
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 matrix[i][j]=sc.nextInt();
//             }
//         }
//         System.out.println("before matrix is :");
//         show(matrix);
//         int[] rows=new int[n];
//         int[] col=new int[n];                //time complexity==O(2*n*n)
//                                              //space complexity==O(2n) 

//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]==0){
//                     rows[i]=1;
//                     col[j]=1;
//                 }
//             }
//         }

//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(rows[i]==1||col[j]==1){
//                     matrix[i][j]=0;
//                 }
//             }
//         }
//         System.out.println("after applying algorithm , the array is:");
//         show(matrix);

//         sc.close();
//     }
//     public static void show (int[][] mat){
//         for(int[] row:mat){
//             for(int j:row){
//                 System.out.print(j+" ");
//             }
//             System.out.println();
//         }
//     }
// }













// optimal solution

// public class set_matrix_zero {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number of rows and columns in square matrix ");
//         int n=sc.nextInt();
//         int[][] matrix=new int[n][n];
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 matrix[i][j]=sc.nextInt();
//             }
//         }
//         System.out.println("before matrix is :");
//         show(matrix);                         // time complexity ==O(2*n*n)
//                                              // space complexity==O(1)

//         int row1=1;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i==0){
//                     if(matrix[i][j]==0){
//                         matrix[0][j]=0;
//                         row1=0;
//                     }
//                 }else if(matrix[i][j]==0){
//                     matrix[0][j]=0;
//                     matrix[i][0]=0;
//                 }
//             }
//         }

//         for(int i=n-1;i>0;i--){
//             for(int j=n-1;j>=0;j--){
//                 if(matrix[0][j]==0||matrix[i][0]==0){
//                     matrix[i][j]=0;
//                 }
//             }
//         }
//         if(row1==0){
//             for(int i=0;i<n;i++){
//                 matrix[0][i]=0;
//             }

//         }


//         System.out.println("after applying algorithm , the array is:");
//         show(matrix);

//         sc.close();
//     }
//     public static void show (int[][] mat){
//         for(int[] row:mat){
//             for(int j:row){
//                 System.out.print(j+" ");
//             }
//             System.out.println();
//         }
//     }
// }
