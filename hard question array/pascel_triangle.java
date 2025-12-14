import java.util.Scanner;

// print complete pascel triangle: 


// import java.util.ArrayList;
// public class pascel_triangle {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);
//         System.out.println("enter the total row to be print: ");
//         int n=sc.nextInt();
//         ArrayList<ArrayList> list=new ArrayList<>();
//                                                                   // time complexity==O(n*n*n)
//                                                                   // space complexity ==O(n*n)
//         for(int i=0;i<n;i++){
//             ArrayList<Integer> arr=new ArrayList<>();
//             for(int j=0;j<=i;j++){
//                 arr.add(value(i,j));
//             }
//             list.add(arr);
//         }
//         for(ArrayList row:list){
//             System.out.println(row);
//         }

//         sc.close();
//     }
//     public static int value(int row,int col){
//         int ans=1;
//         for(int i=0;i<col;i++){
//             ans*=(row-i);
//             ans/=(i+1);
//         }
//         return ans;
//     }
// }
















import java.util.ArrayList;
public class pascel_triangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the total row to be print: ");
        int n=sc.nextInt();
        ArrayList<ArrayList> list=new ArrayList<>();
                                                               // time complexity==O(n*n)
                                                               // space complexity==O(n*n)
        for(int i=0;i<n;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            arr.add(1);
            int ans=1;
            for(int j=0;j<i;j++){
                ans*=(i-j);
                ans/=(j+1);
                arr.add(ans);
            }
            list.add(arr);
        }
        for(ArrayList row:list){
            System.out.println(row);
        }

        sc.close();
    }
}