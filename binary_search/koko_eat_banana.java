import java.util.Scanner;


// here we return the minimum number of banana(k) such that koko can eat all banana within h hours 
// banana in piles in ascending order
// k = number of banana eat in per hour
// it finish the first bundle of banana then move to next bundle 
// and take time in integer to finish each bundle , not in decimal   
//given:-> the array where the number of banana is bundle in each piles and h hours to finish it 



public class koko_eat_banana {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of piles in array: ");
        int n=sc.nextInt();
        System.out.println("enter the number of banana in piles: ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("enter the minimum hours you have: ");
        int hour=sc.nextInt();

        int low=1;
        int high=arr[n-1];
        int k=-1;
                                                 //time complexity=O(n*log(max number of banana))
        while(low<=high){
            int mid=low+(high-low)/2;
            boolean done= eat(mid,hour,arr);

            if(done){
                k=mid;
                high=mid-1;
                continue;
            }else{
                low=mid+1;
            }

        }

        if(k==-1){
            System.out.println("its not possible to eat all bundle of banana in "+ hour +" hour.");
        }else{
            System.out.println("minimum integer of banana is "+ k);
        }

        sc.close();

    }
    public static boolean eat(int n, int h,int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=(int)(Math.ceil((double)arr[i]/n));
        }

        return sum<=h;

    }
}
