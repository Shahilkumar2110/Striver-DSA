


import java.util.*;

class disjoint{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    disjoint(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    int parindex(int node){
        if(node==parent.get(node)){
            return node;
        }

        int index=parindex(parent.get(node));
        parent.set(node,index);
        return index;
    }

    public void unionbysize(int u , int v){
        int ult_u=parindex(u);
        int ult_v=parindex(v);

        if(ult_u==ult_v) return;

        if(size.get(ult_u) < size.get(ult_v)){

            parent.set(ult_u,ult_v);
            size.set(ult_v,size.get(ult_v)+size.get(ult_u));

        }else{

            parent.set(ult_v,ult_u);
            size.set(ult_u,size.get(ult_v)+size.get(ult_u));

        }
    }

}


public class implementation_of_kruskals_algorithm {
    public static void main(String[] args) {
        int n = 7;


        int[][] edges = {

        // { u, v , wt }
            {0, 1, 7},
            {1, 2, 8},
            {1, 3, 9},
            {1, 4, 7},
            {2, 4, 5},
            {3, 4, 15},
            {5, 6, 11},
            {0, 3, 5},
            {3, 5, 6},
            {4, 5, 8},
            {4, 6, 9}
        };                                // time complexity==O(nlog n)+ O(n*4*alpha )

        Arrays.sort(edges,(a,b)->{
            return a[2]  -  b[2] ;
        });

        disjoint  dis=new disjoint(n);
        int total_weight=0;

        for(int[] ele:edges){

            int u=ele[0];
            int v=ele[1];
            int wt=ele[2];

            if(dis.parindex(u)!=dis.parindex(v)){
                dis.unionbysize(u, v);
                total_weight+=wt;
            }
        }
        System.out.println("total weight of minimum spanning tree is "+total_weight);






    }
}
