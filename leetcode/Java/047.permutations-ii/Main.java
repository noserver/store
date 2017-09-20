import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();//手串数量
        int contin = sc.nextInt();//连续数量
        int color = sc.nextInt();//颜色种类
        int res = 0;//记录有问题的颜色，也就是返回结果
        //将每条手串信息读入到数组中
        int[][] arr = new int[num][];
        for(int i = 0;i<num;i++){
            int length = sc.nextInt();
            arr[i] = new int[length];
            for(int j = 0;j<length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //然后依次对每种颜色进行判断
        for(int m = 1;m<=color;m++){
            //对于每种颜色来说需要
            int begin = 0;//是否开始包含
            int count = 0;//开始计数
            //遍历每个手串
            for(int n = 0;n<num;n++){
                int sign = 0;//标记是否包含m颜色
                for(int k = 0;k<arr[n].length;k++){
                    if(arr[n][k]==m){
                        sign = 1;
                        break;
                    }
                }
                //跳出后判断是否包含该颜色
                if(sign ==1){
                    if(begin ==0){
                        begin = 1;
                        count = 1;
                    }else{
                        //这里不是第一，则进行判断
                        if(++count>=contin){
                            res++;
                            break;
                        }
                    }
                }else{
                    if(begin==1){
                        count++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}