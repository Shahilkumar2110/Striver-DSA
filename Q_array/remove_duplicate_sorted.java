import java.util.Scanner;


// import java.util.HashSet;
// public class remove_duplicate_sorted {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total number of element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("before removing duplicate number: ");
//         show(arr,n);

//         HashSet<Integer> arr1=new HashSet<>();       // here we use hashset data structure to remove duplicate number
                                                        // time complexity== O(nlog(n)+n)
                                                        // O(nlon(n))--for add element in set 
                                                        // space complexity==O(n) 
//         for(int element:arr){
//             arr1.add(element);
//         }
//         int i=0;
//         for(int element:arr1){
//             arr[i++]=element;
//         }
//         System.out.println("after removing ");
//         show(arr,i);
        

//     }
//     public static void show(int[] arr,int n){
//         for(int i=0;i<n;i++){
//             System.out.print(arr[i]+" ");
//         }
//     }
// }




public class remove_duplicate_sorted {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the total number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }                                              
        System.out.println("before removing: ");            
        show(arr,n);
        int k=0;
        for(int i=1;i<n;i++){                                 // here we use simple for-loop and always compare with its previous element
                                                              // time complexity== O(n)
                                                              // space complexity== O(1)
            if(arr[i]!=arr[i-1]){
                arr[++k]=arr[i];
            }
        }
        System.out.println();
        System.out.println("after removing: ");
        show(arr,k+1);

    }
    public static void show(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
