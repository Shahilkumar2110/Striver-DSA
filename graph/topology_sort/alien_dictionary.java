// kalien planet hai jahan language alag hai.
// Words diye gaye hain sorted order me according to alien dictionary.

// Tumhe find karna hai:  --> characters ka correct order











import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class alien_dictionary {
    public static void main(String[] args) {
        int n = 10; // number of words
        int k = 6; // total unique alien characters: a,b,c,d,e,f

        String[] dict = {
                "baa",
                "abcd",
                "abca",
                "cab",
                "cad",
                "dae",
                "daf",
                "ebf",
                "fca",
                "fcd"
        };

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[k];
                                                              // time complexity==O(n.l+k+e)-- l= avg length of word , 
                                                                                          //   n= number of word
                                                                                          //   k= number of unique character 
                                                                                        //     e= number of edge
                                                            //  space complexity===O(k+e)+O(k)+O(k)
                                                                   //    graph store ,   indegree array ,   queue+result
        for (int i = 0; i < n - 1; i++) {

            String s1 = dict[i];
            String s2 = dict[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                System.out.println("not possible");
                return;
            }

            int size = Math.min(s1.length(), s2.length());

            for (int j = 0; j < size; j++) {

                if (s1.charAt(j) != s2.charAt(j)) {

                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';

                    graph.get(u).add(v);
                    indegree[v]++;
                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int i : graph.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        if (result.size() != k) {
            System.out.println("not possible ");
            return;
        }

        System.out.println("the sequence is ");
        for (int i : result) {
            System.out.print((char) (i + 'a') + "   ");
        }

    }
}
