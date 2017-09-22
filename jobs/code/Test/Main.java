import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] arr = new int[h][w];
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        int x = h-1;
        int y = 0;
        int sign = 0;
        while((x>=0)&&(y<w)){
            if(arr[x][y]>target){
                
                x--;
            }else if(arr[x][y]<target){
                
                y++;
            }else{
                System.out.println(x+" "+y);
                return;
            }
        }
        System.out.println("-1 -1");
    }
}