import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;






// 🔷 Problem kya bolta hai?
// Tumhe ek 2D board diya hota hai jisme:
// 'X' = blocked
// 'O' = open
// 👉 Tumhe aise 'O' ko 'X' me convert karna hai jo:
// completely surrounded ho 'X' se

// 🔷 “Surrounded” ka matlab?
// Agar koi 'O':
// boundary (edge) se connected nahi hai
// aur uske around sirf 'X' hai
// 👉 Tab usko 'X' me change kar dena hai







public class surrounding_region_with_x_and_o {
    public static void main(String[] args) {
        char[][] grid = {
                { 'X', 'X', 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X', 'O', 'X' },
                { 'X', 'X', 'O', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X', 'X', 'X' }
        };

        int n=grid.length;
        int m=grid[0].length;

        char[][] visited=new char[n][m];


        for(int i=0;i<n;i++){
            if(grid[0][i]=='O'){
                dfs(0,i,grid, visited);
            }

            if(grid[n-1][i]=='O'){
                dfs(n-1,i,grid,visited);
            }

        }
        
        for(int i=0;i<m;i++){
            if(grid[i][0]=='O'){
                dfs(i,0,grid,visited);
            }
            if(grid[i][m-1]=='O'){
                dfs(i,m-1,grid,visited);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]!='O'){
                    visited[i][j]='X';
                }
            }
        }

        System.out.println("final matrix is ");

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(visited[i][j]+"    ");
            }
            System.out.println();
        }


    }
    static void dfs(int row, int col, char[][] grid, char[][] visited){              // time complexity==O(n*m)
                                                                                     // space complexity==O(n*m)

        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col]=='O' || grid[row][col]=='X'){
            return;
        }

        visited[row][col]='O';

        dfs(row+1,col,grid,visited);
        dfs(row-1,col,grid,visited);
        dfs(row,col-1,grid,visited);
        dfs(row,col+1,grid,visited);


    }
}
