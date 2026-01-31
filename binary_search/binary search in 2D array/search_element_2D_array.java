import java.util.Scanner ;


// given a 2D array where element in matrix is in sorted order and k target  
// return the index of target element in matrix 
// 
// 
// formula for convert index into matrix index where 
// n=number of row
// m=numebr of column
// number  --- convert into index in matrix ---> (row,column)-(number/m,number%4)
//  number between 0 to n*m-1






public class search_element_2D_array {
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
        
        int low=0,high=m*n-1;
        int row=-1;
        int coloum=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int r1=mid/m,r2=mid%m;
            if(mat[r1][r2]>target){
                high=mid-1;
            }else if(mat[r1][r2]<target){
                low=mid+1;
            }else{
                row=r1;
                coloum=r2;
                break;
            }
        }
        System.out.println("the target element is in index of "+row +"th rows and "+coloum+"th coloum");

        sc.close();
    }
    public static void show(int[][] mat,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
