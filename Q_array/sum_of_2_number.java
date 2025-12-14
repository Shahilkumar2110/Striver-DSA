import java.util.Scanner ;

// public class sum_of_2_number {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         System.out.println("enter the sum of two number in array: ");
//         int k=sc.nextInt();
//         boolean done =false;
//         for(int i=0;i<n;i++){                                      // we use nexted for loop 
//                                                                    // time complexity==O(n^2)
//                                                                    //space complexity==O(1)
//             for(int j=i+1;j<n;j++){
//                 if(arr[i]+arr[j]==k) {
//                     System.out.println("the sum of index "+i+" and "+j+" is = "+k+" and the value is "+arr[i]+" and "+arr[j]+" .");
//                     done =true;
//                     break;
//                 }
//             }
//             if(done) break;
//         }
//         sc.close();
//     }
// }







// import java.util.ArrayList;
// public class sum_of_2_number {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("enter the element in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         System.out.println("enter the sum of two number in array: ");
//         int k=sc.nextInt();
//         ArrayList<Integer> arr2=new ArrayList<>();           // here we use araylist to add two number from array
//                                                             // time complexity==O(n^2)
//                                                             // first we use copy O(n)
//                                                             // then we use arraylist contains and indexof method O(n)
//                                                             // therefore time complexity==O(n^2)
//                                                             //space complexity==O(n) 
//         for(int element:arr){
//             arr2.add(element);
//         }
//         for(int i=0;i<n;i++){
//             int remaining=k-arr[i];
//             if(arr2.contains((Integer) remaining)){
//                 int index=arr2.indexOf(remaining);
//                 if(arr[i]!=arr[index]){
//                     System.out.println("the sum of index "+i+" and "+index+" is = "+k+" and the value is "+arr[i]+" and "+arr[index]+" .");
//                     break;
//                 }
//             }   
//         }
//         sc.close();
//     }
// }










public class sum_of_2_number {
    public static int index(int[] arr,int low ,int high){

        int i=low-1,j=low;
        int pivot =high;
        for(j=low;j<high;j++){
            if(arr[j]<arr[pivot]){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[pivot];
        arr[pivot]=temp;
        return i;
    }

    public static void quicksort (int[] arr,int low,int high){
        if(low<high){
            int ind=index(arr,low,high);
            quicksort(arr,low,ind-1);
            quicksort(arr,ind+1,high);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("enter the sum of two number in array: ");
        int k=sc.nextInt();

        quicksort(arr,0,n-1);   //time complexity of sort the array by quicksort method ==O(nlog(n))

        int i=0;
        int j=n-1;
        int sum=0;
        while(i<j){                               // therefore ,the whole time complexity==O(nlog(n))+O(n)
                                                  // space complexity==O(1)
            sum=arr[i]+arr[j];
            if(sum==k){
                System.out.println("the sum of "+arr[i]+" and "+arr[j]+" of array value is : "+sum);
                System.out.println("this method anable to display index of that number:");
                break;
            }
            if(sum<k){
                i++;
            }else if(sum>k){
                j--;
            } 
        }
        if(sum!=k){
            System.out.println("sorry we donot able to find such number which sum is "+k);
        }
        sc.close();
    }
}
