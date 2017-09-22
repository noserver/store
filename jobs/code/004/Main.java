import java.util.Scanner;
import java.util.Stack;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //按字符依次压入栈，字母调整顺序后压入
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> temp = new Stack<Character>();//保存单词
        int len = str.length();
        for(int i = 0;i<len;i++){
            char current = str.charAt(i);
            if((current=='\'')||(current>='a'&&current<='z')||(current>='A'&&current<='Z')){
                //单词压入temp
                temp.push(current);
            }else{
                //符号
                while(!temp.empty()){
                    stack.push(temp.pop());
                }
                stack.push(current);
            }
        }
        while(!temp.empty()){
                    stack.push(temp.pop());
        }
        while(!stack.empty()){
            System.out.print(stack.pop());
        }
        System.out.println("");
    }
}