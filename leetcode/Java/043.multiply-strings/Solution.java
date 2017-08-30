/**
 * 返回两个字符串的乘积
 */
class Solution {
    public String multiply(String num1, String num2) {
        //两位两位的相乘，然后依次叠加
        //参考discuss
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1+len2];

        //遍历两个数字，做乘积
        for(int i = len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int left = i+j;
                int right = i+j+1;
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = mul +  res[right];
                //
                res[left] = res[left]+sum/10;
                res[right] = sum%10;
            }
        }

        //返回字符串，任务是去掉字符串首位的0
        String res_str = "";
        for(int x:res){
            if(res_str.length()==0&&x==0){
                continue;
            }
            res_str = res_str+x;
        }
        if(res_str.length()==0){
            res_str="0";
        }
        return res_str;
    }
}