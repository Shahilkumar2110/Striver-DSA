import java.util.Scanner;

// giver -->  (1,3),(2,6),(8,9),(9,11),(8,10),(2,4),(15,18),(16,17).
// make it simple and one interval donot overlap to other interval and change into minimum interval
// output--->  (1,6),(8,11),(15,18)


// optimal solution

// import java.util.ArrayList;
// import java.util.Collections;

// public class merge_overlapping_subinterval {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter total number of intervals:");
//         int n = sc.nextInt();

//         ArrayList<int[]> arr = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             int[] interval = new int[2];
//             interval[0] = sc.nextInt();
//             interval[1] = sc.nextInt();
//             arr.add(interval);
//         }

//         // sort intervals by start (and then by end)
//         Collections.sort(arr, (a, b) -> {                // time complexity of sorted the array is O(nlog n)
//             if (a[0] == b[0]) {
//                 return Integer.compare(a[1], b[1]);
//             }
//             return Integer.compare(a[0], b[0]);
//         });               
//                                                          // time complexity==O(nlogn) + O(n)
//                                                          // space complexity==O(n)

//         ArrayList<int[]> answer = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             int start = arr.get(i)[0];
//             int end = arr.get(i)[1];

//             if (!answer.isEmpty() && start <= answer.get(answer.size() - 1)[1]) {
//                 answer.get(answer.size() - 1)[1] = Math.max(end, answer.get(answer.size() - 1)[1]);
//             } else {
//                 answer.add(new int[]{start, end});
//             }
//         }

//         System.out.println("Final intervals are:");
//         for (int[] interval : answer) {
//             System.out.println("(" + interval[0] + ", " + interval[1] + ")");
//         }

//         sc.close();
//     }
// }



