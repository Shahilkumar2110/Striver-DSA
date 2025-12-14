    import java.util.Scanner;

    public class quicksort {
        
        // public static int partition(int[] arr,int low,int high){
        //     int i=low-1;                             // here pivot is assume the last element
        //     int j=low;                               // and i and j is compare by the low always 
        //     int pivot=high;
        //     for(j=low;j<high;j++){
        //         if(arr[j]<arr[high]){
        //             i++;
        //             int temp=arr[j];
        //             arr[j]=arr[i];
        //             arr[i]=temp;
        //         }
                
        //     }
        //     i++;
        //         int temp=arr[high];
        //         arr[high]=arr[i];
        //         arr[i]=temp;
        //     return i;
        // }

        public static int partition(int[] arr,int low,int high){
            int pivot=low;                                       //here pivot is assume the low element 
            int i=low+1;                                        // and i is compare by low +1 and j is compare by high  
            int j=high;
            while(i<=j){
                while(i<=high&&arr[i]<=arr[pivot]){
                    i++;
                }
                while(j>=low&&arr[j]>arr[pivot]){
                    j--;
                }
                if(j>i){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    
                }
            }
            int temp=arr[j];
            arr[j]=arr[pivot];
            arr[pivot]=temp;
            return j;
        }

        public static void quicksort(int[] arr,int low,int high){
            if(low<high){
                int index=partition(arr,low,high);
                quicksort(arr,low,index-1);
                quicksort(arr,index+1,high);
            }
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner (System.in);
            System.out.print("enter the total number of array: ");
            int n=sc.nextInt();
            int[] arr=new int[n];
            System.out.println("enter the value of array");
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            System.out.println("array before appling sorting,");
            for(int element: arr){
                System.out.print(element+ "  ");
            }

            quicksort(arr,0,n-1);

            System.out.println();
            System.out.println("array after appling sorting algorithm: ");
            for(int element: arr){
                System.out.print(element+ "  ");
            }
            sc.close();
        }
    }



