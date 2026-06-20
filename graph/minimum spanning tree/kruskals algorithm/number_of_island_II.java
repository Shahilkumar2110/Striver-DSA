

// Initially, the grid contains only water:
// 0 0 0
// 0 0 0
// 0 0 0

// Then land is added one by one.

// Example:
// m = 3, n = 3
// positions = {
//     {0,0},
//     {0,1},
//     {1,2},
//     {2,1},
//     {1,1}
// }

// For each operation, return the current number of islands .








import java.util.*;


class disjoint{
    int[] parent;
    int[] size;
    disjoint(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    int par_index(int node){

        if(node==parent[node]) return node;

        int index=par_index(parent[node]);
        parent[node]=index;
        return index;

    }

    void joint(int u, int v){
        int ult_u=par_index(u);
        int ult_v=par_index(v);

        if(ult_u==ult_v) return ;

        if(size[ult_u]>size[ult_v]){
            parent[ult_v]=ult_u;
            size[ult_u]=size[ult_u]+size[ult_v];
        }else{
            parent[ult_u]=ult_v;
            size[ult_v]=size[ult_u]+size[ult_v];
        }

    }
}



public class number_of_island_II {
    public static void main(String[] args) {

        int m = 5;
        int n = 5;

        int[][] positions = {
            {0,0},
            {0,0},
            {0,1},
            {1,2},
            {2,1},
            {1,1},  // merges 3 islands

            {3,3},
            {3,4},
            {4,3},

            {2,3},  // connects to island at (3,3)
            {2,2},  // bridges middle islands

            {4,4},
            {0,4},
            {1,4},
            {2,4},  // connects top-right chain

            {4,0},
            {4,1},
            {4,2},  // bottom-left chain

            {3,2},  // major merge
            {3,1},  // major merge
            {2,0}
        };


        int[][] area=new int[n][m];

        disjoint dsu=new disjoint(n*m);

        int total=0;
        
        int[] delrow={-1,0,0,1};
        int[] delcol={0,0,-1,1};

        for(int[] ele:positions){

            int row=ele[0];
            int col=ele[1];

            if(area[row][col]==1){
                System.out.println("total island is "+total);
                continue;
            }
            total++;
            area[row][col] = 1;

            int num=(m*row)+col;
            ArrayList<Integer> record=new ArrayList<>();

            for(int i=0;i<4;i++){
                int newrow=delrow[i]+row;
                int newcol=delcol[i]+col;

                if(newrow<0 || newrow>=n || newcol<0 || newcol>=m || area[newrow][newcol]==0){
                    continue;
                }

                int adjNode = newrow*m + newcol;

                if(dsu.par_index(num) != dsu.par_index(adjNode)){
                    dsu.joint(num, adjNode);
                    total--;
                }

            }

            System.out.println("total number of island is "+total);
        }




    }
}
