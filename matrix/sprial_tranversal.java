import java.util.Scanner;


// optimal solution 
//   make it :-
//     1    2    3     4
//     14   15   16    5
//     13   20   17    6
//     12   19   18    7
//     11   10   9     8


public class sprial_tranversal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of rows and columns: ");
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[n][m];

        int top=0,right=m-1,bottom=n-1,left=0;
        int count=1;                               // time complexity==O(n*m)

        while (count <= n*m){
            for(int j=left;j<=right;j++){
                arr[top][j]=count++;                      
            }
            top++;

            for(int j=top;j<=bottom;j++){
                arr[j][right]=count++;
            }
            right--;

            if(top<=bottom){
            for(int j=right;j>=left;j--){
                arr[bottom][j]=count++;
            }
            bottom--;
            }

            if(left<=right){
            for(int j=bottom;j>=top;j--){
                arr[j][left]=count++;
            }
            left++;
            }
            
        }

        System.out.println("the matrix is ready : ");
        for(int[] row:arr){
            for(int element:row){
                System.out.print(element +"   ");
            }
            System.out.println();
        }

        sc.close();
    }
}
