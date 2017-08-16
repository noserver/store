public class Solution {
    public String countAndSay(int n) {
        //感觉不用递归效率会更高些
        if(n==1){
            return "1";
        }else{
            String str = countAndSay(n-1);
            String read = "";
            for(int i=0;i<str.length();i++){
                char cur = str.charAt(i);
                int count = 1;
                while(i+1<str.length()&&str.charAt(i+1)==cur){
                    i++;
                    count++;
                }
                read = read+Integer.toString(count)+String.valueOf(cur);
            }
            return read;
        }
    }
    //直接循环无递归
    public String countAndSay2(int n){
        String res = "1";
        for(int i=1;i<n;i++){
            String current = res;
            res = "";
            for(int j=0;j<current.length();j++){
                char cur = current.charAt(j);
                int  count = 1;
                while(j+1<current.length()&&current.charAt(j+1)==cur){
                    j++;
                    count++;
                }
                res = res+Integer.toString(count)+String.valueOf(cur);
            }
        }
        return res;
    }
}