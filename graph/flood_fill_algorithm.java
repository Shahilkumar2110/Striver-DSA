import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;



// Given a 2D matrix (image) where each cell has a color (integer value):
//           Aapko ek starting position di jaati hai: (sr, sc)
//           Aur ek newColor

// 👉 Task:
// Starting cell (sr, sc) se connected saare cells (same color wale) ko newColor se replace karo.
// 📌 Conditions
// Sirf woh cells change honge jo:
//        Starting cell ke same color ke ho
//        Connected ho (up, down, left, right)
//        Diagonal usually consider nahi hota (jab tak question bole nahi)




class pair{
    int first;
    int second;
    pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}



public class flood_fill_algorithm {
    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1, 2, 2, 3, 3 },
                { 1, 0, 1, 2, 2, 3, 0 },
                { 1, 1, 1, 0, 0, 3, 3 },
                { 2, 2, 0, 1, 1, 1, 3 },
                { 2, 2, 0, 1, 0, 1, 3 },
                { 4, 4, 4, 1, 1, 1, 3 },
                { 4, 0, 4, 4, 4, 3, 3 }
        };

        int sr = 0, sc = 0, newColor = 9;

        int precolor=image[sr][sc];

        int n=image.length;
        int m=image[0].length;

        funct(image,sr,sc,precolor,newColor);

        System.out.println("the final image is + ");

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(image[i][j]+"    ");
            }
            System.out.println();
            System.out.println();
        }
    }

    static void funct(int[][] image, int row,int col, int precolor, int newcolor){              //time complexity ==O( n*m)
                                                                                                // sapce complexity==O(n*m)
        int n=image.length;
        int m=image[0].length;

        if (precolor == newcolor) return;

        Queue<pair> q=new LinkedList<>();

        q.add(new pair(row,col));
        image[row][col]=newcolor;

        int[] dr={0,0,-1,1};
        int[] dc={-1,1,0,0};

        while(!q.isEmpty()){
            pair node=q.poll();

            for(int i=0;i<4;i++){
                int row2=node.first+dr[i];
                int col2=node.second+dc[i];

                if(row2>=0 && row2<n && col2>=0 && col2<m && image[row2][col2]==precolor){ 
                    q.add(new pair(row2,col2));
                    image[row2][col2]=newcolor;
                }

            }

        }
        
    }

}
