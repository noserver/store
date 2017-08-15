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
}