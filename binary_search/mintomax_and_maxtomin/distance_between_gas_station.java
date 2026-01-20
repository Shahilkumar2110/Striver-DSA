import java.util.Scanner;

// given array in sorted order where arr[i] is the co-ordinate of i gas station
// we have to placed k new gas station 
// new gas station also placed in decimal co-ordenate
// find minimum of all maximum distance between of gas station 



// brute solution


// public class distance_between_gas_station {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter total number of gas station: ");
//         int n = sc.nextInt();

//         int[] arr = new int[n];
//         System.out.println("Enter the co-ordenate of gas station in sorted order :");
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         System.out.print("Enter number of new gas station is placed: ");
//         int k= sc.nextInt();

//         int[] arr2=new int[n-1];
//         for(int i=0;i<k;i++){
//                                                 //   time complexity==O(n+(k*n))
//             int maxgap=-1;
//             int indexofgap=-1;
//             for(int j=0;j<n-1;j++){
//                 int diff=arr[j+1]-arr[j];
//                 int gap=diff/(arr2[j]+1);
//                 if(maxgap<gap){
//                     indexofgap=j;
//                     maxgap=gap;
//                 }
//             }
//             arr2[indexofgap]++;

//         }

//         int min=-1;
//         for(int i=0;i<n-1;i++){
//             int diff=arr[i+1]-arr[i];
//             int gap=diff/(arr2[i]+1);
//             min=Math.max(min,gap);

//         }
//         System.out.println("the minimum gap amoung all maximum gas station is "+min);
        
//         sc.close();
//     }
// }










// optimal solution


public class distance_between_gas_station {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total number of gas station: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
System.out.println("enter the co-ordinate of gas station ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the value of new gas stationn: ");
        int k = sc.nextInt();

        double low = 0;
        double high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            int requiredStations = 0;

            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                requiredStations += (int) (diff / mid);
            }

            if (requiredStations > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.printf("Minimum possible maximum distance = %.2f", high);
        sc.close();
    }
}


