import java.util.Scanner;

public class max_min_by_divide_and_conquer {
    public static minmax finder(int[] arr, int low, int high) {
        minmax find = new minmax();
        if (low == high) {
            find.min = find.max = arr[low];
            return find;
        }
        if (low + 1 == high) {
            if (arr[low] > arr[high]) {
                find.min = arr[high];
                find.max = arr[low];
            } else {
                find.min = arr[low];
                find.max = arr[high];
            }
            return find;
        }

        int mid = low + (high - low) / 2;
        minmax left = finder(arr, low, mid);
        minmax right = finder(arr, mid + 1, high);

        find.min = Math.min(left.min, right.min);
        find.max = Math.max(left.max, right.max);

        return find;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total element in array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        minmax result = finder(arr, 0, n - 1);
        System.out.println("the array is: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("the minimum number of given array is: " + result.min);
        System.out.println("the maximum number of given array is: " + result.max);
        sc.close();
    }
}

class minmax {
    int min;
    int max;
}
