import java.util.Scanner ;


// given a 2D array where each row are in sorted order where only 0 and 1 element is present 
// return the row number which have maximum number of 1 element.
// if 2 or more row have same number of 1 element and its highest then return minimum number of row 




public class maximum_1_in_which_row {
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
        
        show(mat,n,m);
        
        int count_max=0;
        int index=-1;
        for(int i=0;i<n;i++){
            int count=0;
            int low=0;
            int high=m-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(mat[i][mid]==1){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            count=m-low+1;
            if(count>count_max){
                count_max=count;
                index=i;
            }
        }

        System.out.println("the maximum number of 1 in "+(index+1)+"th row. ");


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
