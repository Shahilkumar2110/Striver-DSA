import java.util.Scanner;

public class bubblesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the total number of element in array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the value of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("before sorting: ");
        showarray(arr);

        sort(arr, n);
        System.out.println("after sorting: ");
        showarray(arr);

    }

    public static void showarray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }

    // public static void sort(int[] arr, int n) {
    //     for (int i = 0; i < n - 1; i++) { // simple sorting by bubble sorting algorithm
    //         int move = 0;
    //         for (int j = 0; j < n - i - 1; j++) {
    //             if (arr[j] > arr[j + 1]) {
    //                 int temp = arr[j];
    //                 arr[j] = arr[j + 1];
    //                 arr[j + 1] = temp;
    //                 move++;
    //             }
    //         }
    //         if (move == 0)
    //             break;
    //     }

    // }

    public static void sort(int[] arr, int n) {
        if (n == 1)
            return;
        int move = 0; // bubble sorting by using recursion

        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                move++;
            }
        }
        if (move == 0)
            return;
        sort(arr, n - 1);

    }

}
