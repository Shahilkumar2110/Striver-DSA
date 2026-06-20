// You are given stones on a 2D grid.
// Example:
// stones = [
//  [0,0],
//  [0,1],
//  [1,0],
//  [1,2],
//  [2,1],
//  [2,2]
// ]

// A stone can be removed if there is another stone in the same row or same column.
// Find the maximum number of stones that can be removed.







import java.util.*;

class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int node) {
        if (parent[node] == node) return node;

        return parent[node] = findParent(parent[node]);
    }

    void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

public class maximum_stone_canbe_removed {

    public static void main(String[] args) {

        int[][] stones = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 2},
            {2, 1},
            {2, 2}
        };

        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet dsu = new DisjointSet(maxRow + maxCol + 2);

        HashSet<Integer> usedNodes = new HashSet<>();

        for (int[] stone : stones) {

            int rowNode = stone[0];

            int colNode = stone[1] + maxRow + 1;

            dsu.unionBySize(rowNode, colNode);

            usedNodes.add(rowNode);
            usedNodes.add(colNode);
        }

        int components = 0;

        for (int node : usedNodes) {
            if (dsu.findParent(node) == node) {
                components++;
            }
        }

        int answer = stones.length - components;

        System.out.println("Maximum stones removed = " + answer);
    }
}