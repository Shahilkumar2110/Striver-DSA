import java.util.Scanner;

public class simple_hashing {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);

        String str=sc.next();
        int[] arr=new int[52];                 // String hashing 
        for(int i=0;i<str.length();i++){
            if(Character.isLowerCase(str.charAt(i))){
                arr[str.charAt(i)-'a']++;
            }else{
                arr[26+str.charAt(i)-'A']++;
            }
        }

        for(int i=0;i<52;i++){
            if(arr[i]>0){
                if(i<26){
                    char ch= (char) ('a'+i);
                    System.out.println(ch+" come in "+arr[i]+" times. ");
                }else {
                    char ch=(char)('A'+i-26);
                    System.out.println(ch+" come in "+arr[i]+" times. ");
                }
            }
        }


    }
}
