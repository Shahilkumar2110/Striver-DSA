import java.util.Scanner;

// giver a array where you have to find minimum number where 
// we divide all number of array and add it, 
// the sumation is smaler than threshold value 

public class smaller_number_than_threshold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number of element in array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("enter the value");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the threshold value: ");
        int threshold = sc.nextInt();

        int[] mm = minmax(arr);

        int low = mm[0];
        int high = mm[1];
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            for (int e : arr) {
                sum += (int) Math.ceil((double) e / mid);
                if (sum > threshold) {
                    low = mid + 1;
                    continue;
                }
            }
            if (sum > threshold) {
                low = mid + 1;
            } else {
                high = mid - 1;
                index = mid;
            }
        }
        if (index != -1)
            System.out.println("the minimum number is " + index);
        else
            System.out.println("not possible");

        sc.close();
    }

    public static int[] minmax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (min > i)
                min = i;
            if (max < i)
                max = i;
        }
        return new int[] { min, max };

    }
}
