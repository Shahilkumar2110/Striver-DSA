import java.util.Scanner ;

public class mergesort {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the number of element in array: ");
        int n=sc.nextInt();
        int[] arr =new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("array before sorting: ");
        for(int element :arr){
            System.out.print(element + " ");
        }
        
        mergesort(arr,0,arr.length-1);
        System.out.println("array after sorting: ");
        for(int element :arr){
            System.out.print(element + " ");
        }

    }

    static void mergesort(int[] arr ,int start,int end){

        if(start<end){
            int mid=start+(end-start)/2;
            mergesort(arr,start,mid);
            mergesort(arr,mid+1,end);
            sort(arr,start,mid,end);
        }
        
    }
    static void sort(int[] arr,int start,int mid,int end){
        int n1=mid-start+1;
        int n2=end-mid;
        int arr1[]=new int[n1];          // on sorting the array without space,
        int arr2[]=new int[n2];          // we have to shift all the element in array like insertion element between the array.
                                    

        for(int i=0;i<n1;i++){
            arr1[i]=arr[start+i];
        }

        for(int i=0;i<n2;i++){
            arr2[i]=arr[mid+1+i];
        }

        int i=0,j=0,k=start;
        while(i<n1&&j<n2){
            if(arr1[i]<arr2[j]){
                arr[k++]=arr1[i++];
            }else{
                arr[k++]=arr2[j++];
            }
        }

        while(i<n1){
            arr[k++]=arr1[i++];
        }
        while(j<n2){
            arr[k++]=arr2[j++];
        }


    }
}
