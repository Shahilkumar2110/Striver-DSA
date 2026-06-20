


import java.util.*;

class disjoint{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();


    public disjoint(int limit){                // its is 1 based index      // rank and parent is intialize
        for(int i=0;i<=limit;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findpar(int node){

        if(node==parent.get(node)) return node;

        int index=findpar(parent.get(node));
        parent.set(node,index);
        return parent.get(node);

    }

    public void unionbyrank(int u , int v){
        int ult_u=findpar(u);
        int ult_v=findpar(v);

        if(ult_u==ult_v) return;

        if(rank.get(ult_u) < rank.get(ult_v)){

            parent.set(ult_u,ult_v);    

        }else if(rank.get(ult_u) > rank.get(ult_v)){

            parent.set(ult_v,ult_u);    

        }else{

            parent.set(ult_v,ult_u);
            int ranku=rank.get(ult_u);
            rank.set(ult_u,ranku+1);

        }
    }

    public void unionbysize(int u , int v){
        int ult_u=findpar(u);
        int ult_v=findpar(v);

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

public class disjoint_set {
    public static void main(String[] args) {

        disjoint ds=new disjoint(7);

        ds.unionbyrank(1,2);
        ds.unionbyrank(2,3);
        ds.unionbyrank(4,5);
        ds.unionbyrank(6,7);
        ds.unionbyrank(5,6);

        if(ds.findpar(3)==ds.findpar(7)){
            System.out.println("the same");
        }else {
            System.out.println("not same ");
        }

        ds.unionbyrank(3,7);

        if(ds.findpar(3)==ds.findpar(7)){
            System.out.println("the same");
        }else {
            System.out.println("not same ");
        }

    }
}
