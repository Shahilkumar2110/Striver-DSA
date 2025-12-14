
public class find_peak_element_sorted_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
    
        int low=1;
        int high=n-2;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){
                index=mid;
                break;
            }
            if(arr[mid]>arr[mid+1]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        if(index==-1){
            System.out.println("no peak element is present in array ");
        }else{
            System.out.println("the "+index+"th index element  is the peak element in sorted array of value is "+arr[index]);
        }


        sc.close();
    }
}



