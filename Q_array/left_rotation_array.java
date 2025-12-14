import java.util.Scanner;

// public class left_rotation_array {
//     public static void main(String[] args) {
//         Scanner sc =new Scanner(System.in);
//         System.out.println("enter the number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];

//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("enter the position to puch the array: ");
//         int d=sc.nextInt();
//         d=d%n;
//         int[] arr2=new int[d];
//         System.out.println("before puch the array: ");
//         for(int element:arr){
//             System.out.print(element+" ");
//         }
//         System.out.println();                         // here we use simple way to move d element in left side   
//                                                       // time complexity == O(d)+O(n-d)+O(d)
//                                                       //                  ==> O(n+d)
//                                                       // space complexity ==O(d)
//         for(int i=0;i<d;i++){
//             arr2[i]=arr[i];
//         }

//         for(int i=d;i<n;i++){
//             arr[i-d]=arr[i];
//         }
//         for(int i=n-d;i<n;i++){
//             arr[i]=arr2[i-(n-d)];   
//         }
//         System.out.println("after push the "+d+" element left side the array: ");
//         for(int element:arr){
//             System.out.print(element+" ");
//         }

//     }
// }




public class left_rotation_array {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the number to push the left side of array: ");
        int d=sc.nextInt();
        d=d%n;
        System.out.println("before rearrangement of element: ");
        for(int element :arr){
            System.out.print(element +" ");
        }

        // reverse first d element of array
        for(int i=0;i<d/2;i++){                    // time complexityy == O(2n)
                                                   // space somplexity ==  o(1)
            int temp=arr[i];
            arr[i]=arr[d-i-1];
            arr[d-i-1]=temp;
        }
        // reverse last n-d element of array
        for(int i=0;i<(n-d)/2;i++){
            int temp=arr[n-1-i];
            arr[n-1-i]=arr[d+i];
            arr[d+i]=temp;
        }
        // reverse complete element in array
        for(int i=0;i<n/2;i++){
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
        System.out.println();

        System.out.println("after rearrangement of element: ");
        for(int element :arr){
            System.out.print(element +" ");
        }
        sc.close();

    }
}
