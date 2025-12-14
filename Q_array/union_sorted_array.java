import java.util.Scanner;

// import java.util.Set;
// import java.util.HashSet;
// public class union_sorted_array {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the number of element in array1 and array2: ");
//         int n=sc.nextInt();
//         int m=sc.nextInt();
//         int[] arr1=new int[n];
//         int[] arr2=new int[m];

//         System.out.println("enter the value of array1 in sorted form: ");
//         for(int i=0;i<n;i++){
//             arr1[i]=sc.nextInt();
//         }
//         System.out.println("enter the value of array2 in sorted form: ");
//         for(int i=0;i<m;i++){
//             arr2[i]=sc.nextInt();
//         }
//         Set<Integer> unique=new HashSet<>();
//         for(int element:arr1){                  // here we use set data structure to take the union of two array
                                                   // time complexity == O(n)+O(m)+O(n+m)
                                                   //space complexity== O(2n+2m)
//             unique.add(element);   //---> add the element in set is take O(n) time complexity            
//         }
//         for(int element:arr2){
//             unique.add(element);
//         }
//         System.out.println("the array1 is: ");
//         show(arr1);
//         System.out.println("the array2 is: ");
//         show(arr2);
//         System.out.println("the union of array1 and array2 is: ");
//         System.out.println(unique);
//     }
//     public static void show(int[] arr){
//         for(int element:arr){
//             System.out.print(element+" ");
//         }
//         System.out.println();
//     }
// }





import java.util.ArrayList;
public class union_sorted_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of element in array1 and array2: ");
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];

        System.out.println("enter the value of array1 in sorted form: ");
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println("enter the value of array2 in sorted form: ");
        for(int i=0;i<m;i++){
            arr2[i]=sc.nextInt();
        }
        ArrayList<Integer> union=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<n&&j<m){                    // here we use while loop to take the union of two sorted array
            if(i>0&&arr1[i]==arr1[i-1]){    // time complexity ==O(n+m)
                                           // space complexity==O(n+m)
                i++;
                continue;
            }

            if(j>0&&arr2[j]==arr2[j-1]){
                j++;
                continue;
            }

            
            if(arr1[i]>arr2[j]){
                union.add(arr2[j]);
                j++;
            }else if(arr1[i]<arr2[j]){
                union.add(arr1[i]);
                i++;
            }else{
                union.add(arr1[i]);
                j++;
                i++;
            }
        }
        while(i<n){
            if(i==0||arr1[i]!=arr1[i-1]){
                union.add(arr1[i]);
                
            }
            i++;
        }
        while(j<m){
            if(j==0||arr2[j]!=arr2[j-1]){
                union.add(arr2[j]);
                
            }
            j++;
        }
        System.out.println("array1 is: ");
        show(arr1);
        System.out.println("array2 is: ");
        show(arr2);
        System.out.println("the union of array1 and aray2 is: ");
        for(int element:union){
            System.out.print(element+" ");
        }


    }
    public static void show(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }
}

