import java.util.Scanner;


// given a 2D array   
// return any peak element in all other peak element in matrix 
// peak element in matrix means greatest number on comparison than element around the peak element





public class peak_element_in_2D_matrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the row of matrix: ");
        int n=sc.nextInt();
        System.out.println("enter the coloum of matrix: ");
        int m=sc.nextInt();

        int[][] mat=new int[n][m];
        System.out.println("the value of matrix: ");
        for(int i=0;i<n;i++){
            System.out.println("value of "+i+"th row ");
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        
        show(mat,n,m);
        int ind1=-1,ind2=-1;

        int low=0,high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int index=max(mat,n,mid);
            int left=(mid-1)>=0?mat[index][mid-1]:-1;
            int right=(mid+1)<m?mat[index][mid+1]:-1;

            if(mat[index][mid]>left&&mat[index][mid]>right){
                ind1=index;
                ind2=mid;
                break;
            }else if(mat[index][mid]<left){
                high=mid-1;
            }else{
                low=mid+1;
            }

        }

        System.out.println("the index of one peak element in matrix is "+ind1+"th row and "+ind2+"th column. ");



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
    public static int max(int[][] arr,int n,int m){
        int max=-1;
        int ind=-1;
        for(int i=0;i<n;i++){
            if(arr[i][m]>max){
                max=arr[i][m];
                ind=i;
            }
        }

        return ind;
    }
}
