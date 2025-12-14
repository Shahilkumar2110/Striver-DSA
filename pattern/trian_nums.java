import java.util.Scanner;

public class trian_nums {
    private static void pattern1(int n){
        int number=0;
        for (int i=0;i<n;i++){
            if(i%2==0)number=1;
            else number=0;
            for(int j=0;j<=i;j++){
                System.out.print(number);
                number=1-number;
            }
            System.out.println("");
        }
    }
    private static void pattern2(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=0;j<2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=i;j>0;j--){
                System.out.print(j);
            }
            System.out.println("");
        }
    }
    private static void pattern3(int n){
        int number =1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(number+ " ");
                number++;
            }
            System.out.println("");
        }
        
    }
    private static void pattern4(int n){
        for(int i=0;i<n;i++){
            for(char ch='A';ch<='A'+i;ch++){
                System.out.print(ch +" ");
            }System.out.println("");
        }
    }
    private static void pattern5(int n){
        for(int i=0;i<n;i++){
            for(char ch='A';ch<'A'+(n-i);ch++){
                System.out.print(ch +" ");
            }System.out.println("");
        }
    }
    private static void pattern6(int n){
        char ch='A';
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(ch);
            }
            ch++;
            System.out.println("");
        }
    }
    private static void pattern7(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            char ch='A';

            for(ch='A';ch<='A'+i;ch++){
                System.out.print(ch);
            }
            ch--;
            while(ch!='A'){
                ch--;
                System.out.print(ch);
            }
            
            System.out.println("");
        }
    }
    private static void pattern8(int n){
        for(int i=0;i<n;i++){
            char ch=(char)(65+n-i-1);
            for(int j=0;j<=i;j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println("");
        }
    }
    private static void pattern9(int n){
        for(int i=0;i<n;i++){
            
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }

            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }

            for(int j=0;j<n-i;j++){
                System.out.print("*");   
            }
            System.out.println("");
        }

        for(int i=0;i<n;i++){
            
            for(int j=1;j<=i+1;j++){
                System.out.print("*");
            }

            for(int j=0;j<2*(n-i-1);j++){
                System.out.print(" ");
            }
            
            for(int j=1;j<=i+1;j++){
                System.out.print("*");   
            }
            System.out.println("");
        }
    }
    private static void pattern10(int n){
        for(int i=0;i<n;i++){
            
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }

            for(int j=0;j<2*(n-i-1);j++){
                System.out.print(" ");
            }

            for(int j=0;j<=i;j++){
                System.out.print("*");   
            }
            System.out.println("");
        }

        for(int i=0;i<n-1;i++){
            
            for(int j=0;j<n-i-1;j++){
                System.out.print("*");
            }

            for(int j=0;j<2*(i+1);j++){
                System.out.print(" ");
            }

            for(int j=0;j<n-i-1;j++){
                System.out.print("*");   
            }
            System.out.println("");
        }
    }
    private static void pattern11(int n){
        int space=2*(n-1);
        for(int i=0;i<2*n-1;i++){
            int star=i+1;
            if(i>n-1) star=2*n-i-1;
            for(int j=0;j<star;j++){
                System.out.print("*");
            }

            for(int j=0;j<space;j++){
                System.out.print(" ");
            }

            for(int j=0;j<star;j++){
                System.out.print("*");   
            }

            if(i<n-1){
                space-=2;
            }else{
                space+=2;
            }
            System.out.println("");
        }
    }
    private static void pattern12(int n){
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int left=j;
                int top=i;
                int right=(2*n-2)-j;
                int bottom=(2*n-2)-i;
                System.out.print(n-Math.min(Math.min(top,bottom),Math.min(left,right)));
                
            }
            System.out.println("");
            
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("enter the value of line or rows: ");
        int n=sc.nextInt();
        pattern12(n);
        
        
    }
}
