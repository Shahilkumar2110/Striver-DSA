import java.util.Scanner ;

// code for alternate rearrange of array element in positive and negative:
// number of positive == number of negative :

// brute solution


// public class alternate_rearrange_array {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total number of array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("before rearranging array: ");
//         show(arr);
//         int pos=0;
//         int neg=0;                                 // time complexity ==O(3n)
//                                                    // space complexity==O(n)
//                                                    // here first we use count the positive number and negative number
//                                                    // then copy it and last copy it in original array by alternate order 
//         for(int i=0;i<n;i++){
//             if(arr[i]>=0) pos++;
//             else neg++;
//         }
//         int[] arr1=new int[pos];
//         int[] arr2=new int[neg];
//         int k=0,j=0;
//         for(int i=0;i<n;i++){
//             if(arr[i]>=0) arr1[k++]=arr[i];
//             else arr2[j++]=arr[i];
//         }
//         int half=n/2;
//         for(int i=0;i<half;i++){
//             arr[2*i]=arr1[i];
//             arr[2*i+1]=arr2[i];
//         }
//         if(half+half!=n){
//             arr[n-1]=arr1[k-1];
//         }
//         System.out.println("after the rearranging array: ");
//         show(arr);
//         sc.close();
//     }
//     public static void show(int[] arr){
//         for(int element:arr){
//             System.out.print(element+" ");
//         }
//         System.out.println();
//     }
// }











// code for alternate rearrange of array element in positive and negative :
//number of positive == number of negative 
// optical solution

// //optimal solution 
// public class alternate_rearrange_array {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the total number of array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.println("before rearranging array: ");
//         show(arr);
//         int[] arr1=new int[n];
//         int pos=0,neg=1;
//         for(int i=0;i<n;i++){
//             if(arr[i]<0){
//                 arr1[neg]=arr[i];
//                 neg+=2;
//             }else{
//                 arr1[pos]=arr[i];
//                 pos+=2;
//             }
//         }

//         System.out.println("after the rearranging array: ");
//         show(arr1);
//         sc.close();
//     }
//     public static void show(int[] arr){
//         for(int element:arr){
//             System.out.print(element+" ");
//         }
//         System.out.println();
//     }
// }











// code for alternate rearrange of array element in positive and negative where unequal number of positive andd negative element:
//number of positive != number of negative 
//brute solution


public class alternate_rearrange_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the total number of array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("before rearranging array: ");
        show(arr);
                                                               // time complexity ==O(3n)
                                                               // space compexity==O(n)
        int pos=0;                   
        int neg=0;                                 
        for(int i=0;i<n;i++){
            if(arr[i]>=0) pos++;
            else neg++;
        }
        int[] arr1=new int[pos];
        int[] arr2=new int[neg];
        int m=0,p=0;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                arr2[m++]=arr[i];
            }else{
                arr1[p++]=arr[i];
            }
        }

        int k=0;
        int last=Math.min(pos,neg);
        for(int i=0;i<last;i++){
            arr[2*i]=arr1[i];
            arr[2*i+1]=arr2[i];
            k=2*i+1;
        }
        
        
        if(pos>neg){
            for(int i=last;i<pos;i++){
                arr[++k]=arr1[i];
            }

        }else if(pos<neg){
            for(int i=last;i<neg;i++){
                arr[++k]=arr2[i];
            }

        }
        
        System.out.println("after the rearranging array: ");
        show(arr);
        sc.close();
    }
    public static void show(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }
}



