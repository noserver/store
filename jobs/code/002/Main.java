import java.util.Scanner;
 
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String line = in.nextLine();
        char[] charArr = line.toCharArray();
        int len=charArr.length;
         
        long res=0;
        //len-1位
        for(int i=0;i<len-1;i++){
            // len-1 -> 1
            res=(res+powMod(2,len-i-1,1000000007))%1000000007;
        }

        //len位
        for(int i=0;i<len;i++){
            if(charArr[i]>'4' && charArr[i]<'7'){
                res=(res+(powMod(2,len-i-1,1000000007))%1000000007)%1000000007;
                break;
            }else if(charArr[i]>'7'){
                res=(res+(2*powMod(2,len-i-1,1000000007))%1000000007)%1000000007;
                break;
            }else if(charArr[i]=='4'){
                if(i==len-1)//最后一位，
                    res=(res+1)%1000000007;
            }else if(charArr[i]=='7'){
                if(i==len-1)
                    res=(res+2)%1000000007;
                else
                    res=(res+powMod(2,len-i-1,1000000007))%1000000007;
            }else{
                break;
            }
        }
         
        System.out.println(res);
         
    }
    private static long powMod(long  a,long  b,long m){
        long res=1;
        a%=m;
        while(b!=0){
            if((b&1 )== 1)//奇数
            res=(res*a)%m;//
            a=(a*a)%m;
            b>>=1;
        }
        return res;
    }
}