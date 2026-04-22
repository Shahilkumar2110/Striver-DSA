import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;









// 🔷 Problem kya bolta hai?
// Tumhe ek matrix (grid) diya hota hai jisme sirf 0 aur 1 hote hain.
// 👉 Har cell ke liye tumhe find karna hai:
// uska nearest distance kisi bhi 1 wale cell tak

// 🔷 Distance ka matlab?
// Distance = minimum steps (up, down, left, right)



class pair{
    int row;
    int col;
    int step;
    pair(int first, int second, int oneplus){
        row=first;
        col=second;
        step=oneplus;
    }
}




public class minimum_distance_from_any_cell_1 {
    public static void main(String[] args) {
        int[][] grid= {
                { 0, 0, 0, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0 }
        };

        int n=grid.length;
        int m=grid[0].length;


        int[][] result=new int[n][m];
        Queue<pair> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new pair(i,j,0));
                }
            }
        }

        traversal(grid, result, q);

        System.out.println("final matrix is : ");

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(result[i][j]+"    ");

            }
            System.out.println();
            System.out.println();
        }

    }


    static void traversal(int[][] grid , int[][] result, Queue<pair> q){

        int n=grid.length;
        int m=grid[0].length;

        int[] delrow={0,0,-1,1};
        int[] delcol={1,-1,0,0};

        while(!q.isEmpty()){

            pair node=q.poll();

            for(int i=0;i<4;i++){
                int row=node.row +delrow[i];
                int col=node.col +delcol[i];

                if(row>=0 && col>=0 && row<n && col<m && grid[row][col]!=1 && result[row][col]==0){
                    result[row][col]=node.step+1;
                    q.add(new pair(row,col,node.step+1));
                }

            }
        }

    }
}