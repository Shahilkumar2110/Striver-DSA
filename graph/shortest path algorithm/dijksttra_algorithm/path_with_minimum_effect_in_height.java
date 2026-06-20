
// given 
//  a rows × cols grid heights, where heights[i][j] is the height of that cell.
// You start at the top-left cell (0, 0).
// You want to reach the bottom-right cell (rows - 1, cols - 1).
// From any cell, you can move up, down, left, or right.


// The effort of moving from one cell to an adjacent cell is:
//                            ∣heights[current]−heights[next]∣   <--   absolute difference between two adjacent cell


// What is the "effort" of a path?
// it is the maximum single-step difference encountered along that path.
// You need to find a path whose maximum step difference is as small as possible.





import java.util.*;


public class path_with_minimum_effect_in_height {
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] height = {
            {1, 10, 6, 7},
            {2,  3, 8, 9},
            {4,  5, 2, 1},
            {7,  6, 3, 4}
        };

        int n=height.length;
        int m=height[0].length;

        int[][] abs_diff=new int[n][m];
        for(int i=0;i<n;i++){

            Arrays.fill(abs_diff[i],Integer.MAX_VALUE);

        }
        abs_diff[0][0]=0;

        PriorityQueue<int[]> q=new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        q.add(new int[]{0,0,0});

        int[] row={0,0,-1,1};
        int[] col={-1,1,0,0};

        while(!q.isEmpty()){            // time complexity==O(elog v)--->(n * m * log( n * m ))
                                        //  where e=total edge and v=total node
 
            int[] node=q.poll();

            int noderow=node[1];
            int nodecol=node[2];
            int dist=node[0];

            if (noderow == n - 1 && nodecol == m - 1) {
                System.out.println("The minimum effort is " + dist);
                return;
            }

            if(dist>abs_diff[noderow][nodecol]){
                continue;
            }

            for(int i=0;i<4;i++){
                int newrow=noderow+row[i];
                int newcol=nodecol+col[i];

                if(newrow>=0 &&newcol>=0  && newrow<n && newcol<m){

                    int max_abs=Math.max(dist,Math.abs(height[noderow][nodecol]-height[newrow][newcol]));

                    if(max_abs < abs_diff[newrow][newcol]){
                        q.add(new int[]{max_abs,newrow,newcol});
                        abs_diff[newrow][newcol]=max_abs;
                    }

                }

            }
        }
        System.out.println("path not exist between src to dst node ");



    }
}
