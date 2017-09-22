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
        //从左下角开始查找
        //起点
        int x = h-1;
        int y = 0;
        int sign = 0;
        while((x>=0)&&(y<w)){
            if(arr[x][y]>target){
                //大于向上找
                x--;
            }else if(arr[x][y]<target){
                //小于向右找
                y++;
            }else{
                
                return true;
            }
        }
        return false;
    }
}