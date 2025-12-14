import java.util.Scanner;

// import java.util.ArrayList;
// public class move_all_zero_toend {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the number the element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         System.out.println("before moving of all zeroes: ");
//         show(arr);


//         ArrayList<Integer> temp=new ArrayList<>();                // here to move all zeroes element to end of array
//                                                                   // we can assign all element which is not equal to zero in temp arrayList
//                                                                   // and then copy it in original array
//                                                                   // time complexity== O(2n)
//                                                                   //space complexity == o(n)
//         for(int element:arr){
//             if(element!=0){
//                 temp.add(element);
//             }
//         }
//         for(int i=0;i<temp.size();i++){
//             arr[i]=temp.get(i);
//         }

//         for(int i=temp.size();i<n;i++){
//             arr[i]=0;
//         }

//         System.out.println("after moving of all zeroes to end of array: ");
//         show(arr);
//     }

//     public static void show(int[] arr){
//         for(int element:arr){
//             System.out.print(element+" ");
//         }
//         System.out.println();
//     }
// }





public class move_all_zero_toend {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the number the element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=0;
        System.out.println("before moving all zero to end: ");
        show(arr);

        for(int i=0;i<n;i++){             // time complexity == O(n)
                                         // space complexity== O(1)
            if(arr[i]==0){
                k=i;
                break;
            }
        }
        for(int i=k+1;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                k++;
            }
        }

        System.out.println("after moving all zero to end: ");
        show(arr);

    }

    public static void show(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

}

