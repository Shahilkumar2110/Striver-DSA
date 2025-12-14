import java.util.Scanner;


// first and last occurrence in sorted array of target
// arr=[ 2 , 4 , 6 , 8 , 8 , 8 , 11 , 13 ]
//       0   1   2   3   4   5   6    7
// target=8  ---> {3,5} 
// target=10  ---> {-1,-1}
// target=11 ---> {6,6}




public class first_last_occurrence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("enter the target to be searched the lower bound:- ");
        int target=sc.nextInt();
        int fir=first(arr,0,n-1,target);                      // time complexity==O(2*log n base 2)
        int las=-1;
        if(fir==-1){
            System.out.println("the first and last occurrencing index of array is "+fir+" and "+las+".");
            return ;
        }
        

        las=last(arr,0,n-1,target);
        System.out.println("the first and last occurrencing index of array is "+fir+" and "+las+".");
        sc.close();
    }
    public static int first(int[] arr,int low,int high,int target){
        int fir=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                fir=mid;
                high=mid-1;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return fir;
    }
    public static int last(int[] arr,int low,int high,int target){
        int las=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                las=mid;
                low=mid+1;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return las;
    }
}
