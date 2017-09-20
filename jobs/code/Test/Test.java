import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //
        ArrayList<String> data = new ArrayList<String>();
        //while(sc.hasNextLine()){
        //    data.add(sc.nextLine());
        //}
        while(true){
            String str = sc.nextLine();
            if(str.length()==0){
                break;
            }else{
                data.add(str);
            }
        }
        int res = 1;
        TreeNode head = new TreeNode(Integer.parseInt(data.get(0)));
        TreeNode node = head;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(node);
        System.out.println("size is:"+data.size());
        String test = data.get(1);
        String[] arr =test.split(":");
        System.out.println(arr[1]);
        System.out.println("first is:"+arr[1].split("|")[0]);
        System.out.println("second is:"+arr[1].split("|")[1]);
        System.out.println("second is:"+arr[1].split("|")[2]);
        System.out.println("second is:"+arr[1].split("|")[3]);
        
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}