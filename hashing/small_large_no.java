import java.util.Scanner;
import java.util.HashMap;

public class small_large_no {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.print("the array is: ");
        for(int e:arr){
            System.out.print(e+" ");
        }

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int e:arr){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        System.out.println("frequency : ");
        for(int e:map.keySet()){
            System.out.println(e+" frequency is "+map.get(e));
        }

        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int minimum_value=0;
        int maximun_value=0;
        for(int e:map.keySet()){
            if(min<map.get(e)){
                min=map.get(e);
                minimum_value=e;
            }
            if(max>map.get(e)){
                max=map.get(e);
                maximun_value=e;
            }
        }
        System.out.println("maximun frequency is: "+ min +" of number is "+ minimum_value);
        System.out.println("minimum frequency is: "+ max +" of number is "+ maximun_value);

    

    }
}
