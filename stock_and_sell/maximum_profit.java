import java.util.Scanner;

public class maximum_profit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total number of element present in array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        int profit = 0;
        int buyDay = 0, sellDay = 0;                  // time complexity ==O(n)
                                                      // space complexity==O(1)
        for (int i = 1; i < n; i++) {
            if (arr[i] - min > profit) {
                profit = arr[i] - min;
                sellDay = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                buyDay = i;
            }
        }

        System.out.println("Maximum profit: " + profit);
        System.out.println("Buy on day " + (buyDay + 1) + " at price " + arr[buyDay]);
        System.out.println("Sell on day " + (sellDay + 1) + " at price " + arr[sellDay]);
        sc.close();
    }
}
