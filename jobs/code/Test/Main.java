import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i =1;i<=1000;i++){
            if(check(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean check(int num){
        int sum = 0;
        while(num>0){
            sum = sum +num%10;
            num = num/10;
        }
        if(sum%10==0){
            return true;
        }else{
            return false;
        }
    }
}