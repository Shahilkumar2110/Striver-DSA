import java.util.Scanner;

// Given-> Array contain n flower who is bloom day at arr[i]days
// m=number of bouquets
// k=adjacent flowers required to make bouquets
// find minimum number of days you make m bouquets




public class minimum_days_tomake_m_bouquets {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("enter total number of flower: ");
        
        int n=sc.nextInt();

        int[] arr=new int[n];

        System.out.println("enter the bloom day of each flower");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the number of bouquets required: ");
        int m=sc.nextInt();
        System.out.println("number of required adjacent flower in each bouquets ");
        int k=sc.nextInt();

        int[] arr1=minmax(arr);
        int low=arr1[0];
        int high=arr1[1];
        int d=-1;
         while(low<=high){
            int mid=low+(high-low)/2;
                                                        //time complexity=O(n*log(max-min+1))
            boolean done=bouquet(arr,mid,k,m);
            if(done){
                d=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
         }
        if(d==-1) System.out.println("not possible");
        else System.out.println("minimum number of days is "+d);
        
    }
    public static int[] minmax(int[] arr){
        int min=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        return new int[]{min,max};
    }

    public static boolean bouquet(int[] arr,int n,int k,int m){
        int total=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=n){
                count++;
            }else{
                total+=count/k;
                count=0;
            }
        }
        total+=count/k;
        return total>=m;
    }
}
