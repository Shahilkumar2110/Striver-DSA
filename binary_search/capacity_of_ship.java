import java.util.Scanner;

// given a array of n product weight where we have to deliver the product within d days 
// we have to find minimum capacity of everyday total product weight that deliver
// for which we deliver the product within d days
// point :-> product weight not be divided means product weight is 10 then complete weight is deliver in 1 days 


public class capacity_of_ship {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of product: ");
        int n=sc.nextInt();
        
        int[] arr=new int[n];

        System.out.println("enter the value");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter the days: ");
        int days=sc.nextInt();

        int min=Integer.MAX_VALUE;
        int max=0;
        for(int e:arr){
            max+=e;
            if(min>e) min=e;
        }
        int capacity=-1;
        while(min<=max){
            int mid=min+(max-min)/2;
            int day=1;
            int load=0;
            for(int e:arr){
             if(load+e<=mid){
                load+=e;
             }else{
                day++;
                load=e;
             }
             if(day>days) break;
             
            }

            if(day>days){
                min=mid+1;
            }else{
                max=mid-1;
                capacity=mid;
            }

        }
        if(capacity!=-1){
            System.out.println("the minimum capacity is "+capacity);
        }else{
            System.out.println("not possible");
        }



        sc.close();
        
    }
}
