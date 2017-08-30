/**
 * 通配符，?匹配单个字符，*匹配任意多个字符
 * p为正则符号，s为被检验符号，返回是否可以匹配
 **/
class Solution {
    public boolean isMatch(String s, String p) {
        //discuss：思路是这样的，碰到*的处理是0，1，n
        int is = 0;
        int ip = 0;
        int marks = 0;
        int start = -1;

        while(is<s.length()){
            if(ip<p.length()&&((p.charAt(ip)=='?')||(p.charAt(ip)==s.charAt(is)))){
                ip++;
                is++;
            }
            else if(ip<p.length()&&p.charAt(ip)=='*'){
                marks = is;
                start = ip;
                ip++;
            }else if(start!=-1){
                //有*，跳过后不匹配，跳回处理
                is = ++marks;
                ip = start+1;
            }else{
                //无匹配情况
                return false;
            }
        }
        //s遍历完后，检查p剩下的是不是全部是*，不是返回false
        while(ip<p.length()){
            if(p.charAt(ip)!='*') return false;
            ip++;
        }
        return true;
    }
}