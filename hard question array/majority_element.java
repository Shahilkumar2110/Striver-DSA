import java.util.Scanner;

// find the majority element in given array atleast more than  (size of array /3)
// greater than (n/3)

// brute solution

// import java.util.ArrayList;
// public class majority_element {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);

//         System.out.println("enter the total number of element present in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         ArrayList<Integer> majority_element=new ArrayList<>();              
//                                                                  // time complexity==O(n^2)
//                                                                  // space complexity==O(1)
//         for(int i=0;i<n;i++){
//             if(!majority_element.contains(arr[i])){
//                 int count=0;
//                 for(int j=0;j<n;j++){
//                     if(arr[i]==arr[j]){
//                         count++;
//                     }
//                     if(count>n/3){
//                         majority_element.add(arr[i]);
//                         break;
//                     }
//                 }
//                 if(majority_element.size()>=n/3){
//                     break;
//                 }
//             }
//         }

//         System.out.print("the majority element in array (greater than n/3 time) are: ");
//         System.out.print(majority_element);
//         sc.close();
//     }
// }

















// import java.util.HashMap;
// import java.util.Map;
// public class majority_element {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);

//         System.out.println("enter the total number of element present in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();                       // time complexity==O(n^2)
                                                          // space complexity==O(n)
//         }
//         HashMap<Integer,Integer> map= new HashMap<>();

//         for(int i=0;i<n;i++){
//             map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
//         }
//         System.out.print("the element which come in array more than n/3 time are: ");
//         for(Map.Entry<Integer,Integer> keyvalue:map.entrySet()){
//             if(keyvalue.getValue()>n/3){
//                 System.out.print(keyvalue.getKey()+"  ");
//             }
//         }

//         sc.close();
//     }
// }
















// import java.util.HashMap;
// import java.util.ArrayList;
// public class majority_element {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner (System.in);

//         System.out.println("enter the total number of element present in array: ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         HashMap<Integer,Integer> map= new HashMap<>();             
                                                                // time complexity==O(n)
                                                                // space complexity==O(n)

//         System.out.print("the element which come in array more than n/3 time are: ");
        
//         ArrayList<Integer> list=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
//             if(map.get(arr[i])>n/3){
//                 list.add(arr[i]);
//             }
//         }
//         System.out.println(list);            

//         sc.close();
//     }
// }

















public class majority_element {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        System.out.println("enter the total number of element present in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int element1=Integer.MIN_VALUE;
        int count1=0;
        int element2=Integer.MIN_VALUE;
        int count2=0;                               // time complexity==O(2n)
                                                    // space complexity==O(1)    
        for(int i=0;i<n;i++){
            if(count1==0&&arr[i]!=element2){
                count1++;
                element1=arr[i];
            }else if(count2==0&&arr[i]!=element1){
                count2++;
                element2=arr[i];
            }else if(element1==arr[i]){
                count1++;
            }else if(element2==arr[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int element:arr){
            if(element==element1) count1++;
            else if(element==element2) count2++;
        }
        System.out.print("the element which come more than n/3 times :");
        if(count1>n/3){
            System.out.print(element1+"  ");
        }
        if(count2>n/3){
            System.out.println(element2+" :");
        }





        sc.close();
    }
}