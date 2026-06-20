

//   You are given a list of accounts.


// Each account looks like this:
// ["Name", "email1", "email2", "email3", ...]



// 📌 Key Idea
// Each account belongs to a person.
// BUT the same person may have multiple accounts.
// If two accounts share at least one email, they belong to the same person and must be merged.




// 🔥 Example
// Input:
// [
// ["John", "a@mail.com", "b@mail.com"],
// ["John", "b@mail.com", "c@mail.com"],
// ["Mary", "m@mail.com"],
// ["John", "d@mail.com"]
// ]

//  after merge , final output 
// [
// ["John", "a@mail.com", "b@mail.com", "c@mail.com"],
// ["Mary", "m@mail.com"],
// ["John", "d@mail.com"]
// ]




import java.util.*;





class disjoint{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    disjoint(int n){
        for(int i=0; i<n ;i++){
            parent.add(i);
            size.add(1);
        }
    }

    int par_inddex(int node){
        if(node==parent.get(node)) return node;

        int index=par_inddex(parent.get(node));
        parent.set(node,index);
        return index;
    }

    void joint(int u , int v){
        int ult_u=par_inddex(v);
        int ult_v=par_inddex(u);

        if(ult_u==ult_v) return;

        if(size.get(ult_u)  >  size.get(ult_v)){

            parent.set(ult_v,ult_u);
            size.set(ult_u,size.get(ult_v)+size.get(ult_u));

        }else{

            parent.set(ult_u,ult_v);
            size.set(ult_v,size.get(ult_v)+size.get(ult_u));

        }

    }

}

public class account_merge {
    public static void main(String[] args) {
    

        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com", "john_smith@mail.com"));
        accounts.add(Arrays.asList("Alex", "alex@mail.com", "alex99@mail.com"));
        accounts.add(Arrays.asList("Alex", "alex99@mail.com", "alex_new@mail.com"));
        accounts.add(Arrays.asList("Bob", "bob@mail.com"));
        accounts.add(Arrays.asList("Bob", "bobby@mail.com", "bob@mail.com"));
        accounts.add(Arrays.asList("Eve", "eve@mail.com", "eve123@mail.com"));
        accounts.add(Arrays.asList("Eve", "eve123@mail.com", "eve_new@mail.com"));



        int n=accounts.size();

        disjoint obj=new disjoint(n);
        HashMap<String,Integer> map=new HashMap<>();


        for(int i=0;i<n;i++){

            for(int j=1;j<accounts.get(i).size();j++){

                String email = accounts.get(i).get(j);

                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    obj.joint(i, map.get(email));
                }

            }

        }

        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++)  mergedMail[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> it : map.entrySet()) {
f
            String mail = it.getKey();
            int node = obj.par_inddex(it.getValue());

            mergedMail[node].add(mail);
        }


        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedMail[i].size() == 0) continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }

            ans.add(temp);
        }

        System.out.println("the final answer is "+ans);


    }
}