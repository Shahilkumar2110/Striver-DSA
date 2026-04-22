import java.util.Queue;
import java.util.LinkedList;




// 1 denoted the land and 0 denotedd the water 
// return the number of island present 
// land connected by horizontal , vertical and diagonaly





class pair {
    int first;
    int second;

    pair(int row, int col) {
        this.first = row;
        this.second = col;
    }
}

public class number_of_islands {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0, 0, 1, 1 },
                { 1, 0, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 1, 1, 0, 0 },
                { 1, 1, 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1, 0, 1 }
        };

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    traversal(i, j, grid, visited);
                    count++;
                }
            }
        }

        System.out.println("total number of island is " + count);

    }

    static void traversal(int row, int col, int[][] grid, boolean[][] visited) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(row, col));                        // space complexity==O(n^2) + O(n^2)
                                                           // time complexity==O(n^2)*8
        visited[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            pair node = q.poll();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int row2 = node.first + i;
                    int col2 = node.second + j;

                    if (row2 >= 0 && row2 < n && col2 >= 0 && col2 < m && !visited[row2][col2]
                            && grid[row2][col2] == 1) {
                        visited[row2][col2] = true;
                        q.add(new pair(row2, col2));
                    }

                }
            }

        }

    }
}
