
// You are given:
// beginWord
// endWord
// wordList

// You can change only one character at a time, and every intermediate word must exist in wordList.
// Your task is to return all the shortest transformation sequences from beginWord to endWord.

// Example
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// Output:
// [
//   ["hit","hot","dot","dog","cog"],
//   ["hit","hot","lot","log","cog"]
// ]
// There are two shortest paths, both of length 5.






import java.util.*;



public class word_ladder_2 {
    public static void main(String[] args) {

        String beginword = "aaaa";
        String endword = "bbbb";

        List<String> wordList = new ArrayList<>(Arrays.asList(
            "aaaa", "aaab", "aaba", "abaa", "baaa",
            "aabb", "abab", "abba", "baab", "baba", "bbaa",
            "abbb", "babb", "bbab", "bbba",
            "bbbb"
        ));

        HashSet<String> dict = new HashSet<>(wordList);
        dict.remove(beginword);

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        q.add(new ArrayList<>(Arrays.asList(beginword)));

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();
            HashSet<String> usedThisLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {

                ArrayList<String> path = q.poll();
                String word = path.get(path.size() - 1);

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) continue;

                        arr[j] = c;
                        String nextWord = new String(arr);

                        if (dict.contains(nextWord)) {

                            ArrayList<String> newPath = new ArrayList<>(path);
                            newPath.add(nextWord);

                            if (nextWord.equals(endword)) {
                                found = true;
                                result.add(newPath);
                            } else {
                                q.add(newPath);
                            }

                            usedThisLevel.add(nextWord);
                        }
                    }

                    arr[j] = original;
                }
            }

            // remove all words used in this level
            dict.removeAll(usedThisLevel);
        }

        // print result
        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}
