import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;












// You are given a 2D grid of 0s (water) and 1s (land).
// An island is a group of connected 1s (connected 4-directionally: up, down, left, right).

// 👉 Two islands are considered distinct if their shapes are different
//  (translation allowed, but rotation/reflection typically not considered unless specified).







class pair{
    int row;
    int col;
    pair(int first, int second){
        row=first;
        col=second;
    }
}



public class number_of_distinct_island {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 1, 0, 0, 1 },
                { 0, 0, 0, 1, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 1, 0 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 0, 0, 0 }
        };

        int n=grid.length;
        int m=grid[0].length;

        boolean[][] visited=new boolean[n][m];
        Set<String> result=new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1 ){
                    traversal(i,j,visited, result,grid);
                }
            }
        }

        System.out.println("total number of distinct island is "+result.size());
    }


    static void traversal(int row, int col, boolean[][] visited, Set<String> result, int[][] grid){
        Queue<pair> q=new LinkedList<>();                                              //space complexity==O(n*m)
                                                                                       // time complexity===O(n*m*log(n*m))+O(n*m*4)
        StringBuilder str=new StringBuilder();

        int n=grid.length;
        int m=grid[0].length;

        int first=row;
        int second=col;

        q.add(new pair(row,col));
        visited[row][col]=true;

        int[] delrow={0,0,-1,1};
        int[] delcol={-1,1,0,0};

        while(!q.isEmpty()){
            pair node=q.poll();

            str.append((node.row - first) + "," + (node.col - second) + ";");

            for(int i=0;i<4;i++){
                int newrow=node.row+delrow[i];
                int newcol=node.col+delcol[i];

                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && !visited[newrow][newcol]  && grid[newrow][newcol]==1 ){
                    q.add(new pair(newrow, newcol));
                    visited[newrow][newcol]=true;
                }
            
            }
        }

        result.add(str.toString());
        
    }
}
