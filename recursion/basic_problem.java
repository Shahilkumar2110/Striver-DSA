
import java.util.Scanner;

public class basic_problem {
    public static void main(String[] args) {   
        Scanner sc=new Scanner (System.in);
        // int n=sc.nextInt();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        // }
        
        // for(int element:arr){
        //     System.out.print(element +" ");
        // }
        // function6(arr,0,arr.length-1);
        // System.out.println(" ");
        // for(int element:arr){
        //     System.out.print(element +" ");
        // }


        // String str=sc.next();
        // System.out.println(function7(str,0));

        int n=sc.nextInt();
        System.out.println(function8(n));

    }
    public static void function(int n){      // T.C and S.C== O(n)
        System.out.println(n+". shahil kumar");
        n--;
        if(n>0){
            function(n);
        }
    }

    public static void function2(int n){      // T.C and S.C== O(n)
                                             // backtracking 
        n--;
        if(n>0){
            function2(n);
        }
        System.out.println(n+". shahil kumar"); 
    }

    public static void function3(int n,int sum){
        if(n<=0){
            System.out.println(sum);
            return;
        }
        sum+=n;
        n--;
        function3(n,sum);
        

    }

    public static int function4(int n){
        if(n<=0) return 0;
        
        return n+function4(n-1);

    }

    public static int function5(int n){   // T.C and S.C== O(n)
        if(n==0||n==1) return 1;
        
        return n*function5(n-1);

    }

    public static void function6(int[] arr,int start,int end){   // T.C and S.C== O(n)
        if(start>=end){
            return ;
        }
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        function6(arr,start+1,end-1);

    }

    public static boolean function7(String str,int start){   // T.C and S.C== O(n)

        if(start>=str.length()/2) return true;
        if(str.charAt(start)!=str.charAt(str.length()-start-1)){
            return false;
        }
        return function7(str,start+1);

    }

    public static int function8(int n){   // T.C == O(2^n)

        
        if(n==0||n==1) return n;
        return function8(n-1)+function8(n-2);

    }
    

}
