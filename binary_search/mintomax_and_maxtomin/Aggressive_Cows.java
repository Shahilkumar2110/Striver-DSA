import java.util.Scanner;
import java.util.Arrays;

// given the position of cow in x axis and given number of cows that take position in that axis
// we want to find (min dist of cow) is maximum among all minimum distance of cows position
// means -> take all combination of cow that take position and conclude all minimum distance of all combination and 
// find which minimum distance of cow is maximum




public class Aggressive_Cows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stalls: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter stall positions:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of cows: ");
        int cows = sc.nextInt();

        Arrays.sort(arr);

        int low = 1;                                      // we cannot apply binary search on index here 
                                                          // Jis cheez ko maximize / minimize karna hai,
                                                          // usi par binary search lagti hai
        int high = arr[n - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(arr, cows, mid)) {
                ans = mid;        
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Maximum minimum distance is: " + ans);
        sc.close();
    }

    public static boolean canPlace(int[] arr, int cows, int dist) {
        int count = 1;   
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                count++;
                last = arr[i];
            }
            if (count >= cows) {
                return true;
            }
        }
        return false;
    }
}
