import java.util.Scanner;
import java.util.Arrays;

// given a array of which total page are in specifc book, and total student m
// like arr[0]pages of 0th book
// allocate the book to m student in such that :-
// each student get atleast one book
// each book should be allocated to only one sudent
// book allocate to student in contiguous manner 
// find maximum number of pages assigned to a student is minimum. 




public class allocatebooks_or_bookallocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of book: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the books pages:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of student(number of student must be smaller or equal to number of book): ");
        int students = sc.nextInt();
        if(n<students){
            System.out.println("not possible");
            return ;
        }

        int[] arr2=Arrays.copyOf(arr,n);

        Arrays.sort(arr2);

        int low=arr2[n-1];
        int high=0;
        for(int i=students-1;i<n;i++){
            high+=arr2[i];
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            int total=arr[0];
            int student=1;
            for(int i=1;i<n;i++){
                if(total+arr[i]<=mid){
                    total+=arr[i];
                }else{
                    student++;
                    total=arr[i];
                }
            }
            if(student<=students){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        System.out.println("the minimum page allocated amoung all the maximum pages allocate is "+low);

        sc.close();
    }
}
