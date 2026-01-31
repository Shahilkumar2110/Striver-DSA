import java.util.Scanner;

// given two sorted array of different length, find the kth element of two sorted array
// time limit in O(min(log(n),log(m))), where n is length of arr1 and m is length of arr2
  



public class kth_element_of_two_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of array1: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the value of array1 in sorted order: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter length of array2: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.println("enter the value of array2 in sorted order: ");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("enter the position of search element in sorted array: ");
        int k=sc.nextInt();

        double result = median(arr, arr2,k);

        System.out.println("the kth element of array is " + result);

        sc.close();
    }

    public static double median(int[] arr1, int[] arr2,int k) {
        int n = arr1.length;
        int m = arr2.length;

        if (n > m)
            return median(arr2, arr1,k);

        int low = Math.max(k-m,0), high = Math.min(n,k);
        int totalLeft = k;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = totalLeft - cut1;

            int l1 = (cut1 < 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 < 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int r1 = (cut1 >= n) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 >= m) ? Integer.MAX_VALUE : arr2[cut2];

            if (Math.max(l1, l2) <= Math.min(r1, r2)) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}
