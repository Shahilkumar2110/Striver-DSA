import java.util.Scanner;


// given the 2D-matrix where each row is sorted 
// return the median of matrix  


public class median_in_row_wise_sorted_matrix {
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
                                                          //time complexity=O(n log m log(max - min))
        show(mat,n,m);

        
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(mat[i][0]<low){
                low=mat[i][0];
            }
            if(mat[i][m-1]>high){
                high=mat[i][m-1];
            }
        }

        int req=(n*m)/2;

        while(low<=high){
            int mid=low+(high-low)/2;

            int smallequal=countsmallequal(mat,n,m,mid);
            if(smallequal<=req){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        System.out.println("the median of 2D matrix is "+low);


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
    public static int countsmallequal(int[][] arr,int n,int m,int x){
        int count=0;
        for(int i=0;i<n;i++){
            count+=upperbound(arr[i],x,m);

        }
        return count;
    }
    public static int upperbound(int[] arr,int x,int m){
        int low=0;
        int high=m-1;
        int ans=m;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    
}
