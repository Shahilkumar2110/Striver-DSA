import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;




// Tumhe ek 2D grid diya hota hai jisme:
// 0 = empty cell
// 1 = fresh orange
// 2 = rotten orange

// 🎯 Goal
// Find karo ki sab fresh oranges ko rotten hone me kitna time lagega.
// 👉 Rule:
// Har 1 minute me, har rotten orange apne 4 directions (up, down, left, right) me fresh oranges ko rotten bana deta hai.





class pair{
    int first;
    int second;
    pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}


public class rotten_orange {
    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 0, 1, 1, 1, 0, 2 },
                { 1, 1, 0, 1, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 0, 0, 1, 0 },
                { 1, 0, 0, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 2, 0, 1, 0, 0, 1 }
        };

        int count=timeTraversal(grid);
        if(count==-1) System.out.println("all orange not be rot ");
        else System.out.println("time taken to rot all the orange in "+ count +"unit of time ");


    }
    static int timeTraversal(int[][] grid){         //time complexity == O(n*m)+O(n*m*4)
                                                    //space complexity==O(n*m) +O(n*m)

        int n=grid.length;
        int m=grid[0].length;

        int countfresh=0;

        Queue<pair> q=new LinkedList<>();
        int[][] visited=new int[n][m];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j));
                    visited[i][j]=2;
                }
                if(grid[i][j]==1) countfresh++;
            }
        }

        int[] delrow={0,0,1,-1};
        int[] delcol={-1,1,0,0};
        int time=0;

        while(!q.isEmpty()){
            int size=q.size();
            boolean spread = false;

            for(int i=0;i<size;i++){
                pair node=q.poll();

                for(int j=0;j<4;j++){
                    int row2=node.first+delrow[j];
                    int col2=node.second+delcol[j];

                    if(row2>=0 && col2>=0 &&
                        row2<n && col2<m && 
                        grid[row2][col2]==1 && 
                        visited[row2][col2]!=2
                    ){
                        visited[row2][col2]=2;
                        countfresh--;
                        q.add(new pair(row2,col2));
                        spread=true;
                    }


                }
            }
            if (spread) time++; 
        }

        return (countfresh == 0) ? time : -1;

    }
}