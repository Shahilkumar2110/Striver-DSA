import java.util.Scanner;

public class intersection_sorted_array {
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
        int min=Math.min(n,m);
        int[] intersection=new int[min];
        int k=0;
        int i=0,j=0;
        while(i<n&&j<m){ 
            if(arr1[i]<arr2[j]){                // time complexity==o(n+m)
                                                // space somplexity ==O(min(m,n))
                i++;
            }else if(arr1[i]>arr2[j]){
                j++;
            }else {
                intersection[k++]=arr1[i];
                i++;
                j++;
            }
        }
        System.out.println("array1 is: ");
        show(arr1);
        System.out.println("array2 is: ");
        show(arr2);
        System.out.println("the intersection of array1 and aray2 is: ");
        for(int element:intersection){
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
