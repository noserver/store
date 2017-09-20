import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
public class Main {
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
        for(int i = 1;i<data.size();i++){
            String[] all = data.get(i).split(":");
            int root = Integer.parseInt(all[0]);
            String[] other = all[1].split("\\|");
            int left = Integer.parseInt(other[0]);
            int right = Integer.parseInt(other[1]);
            //
            if(left!=-1){
                TreeNode leftNode = new TreeNode(left);
                list.get(i-1).left = leftNode;
                list.add(leftNode);
            }
            if(right!=-1){
                TreeNode rightNode = new TreeNode(right);
                list.get(i-1).right = rightNode;
                list.add(rightNode);
            }
        }
        //pan duan
        for(TreeNode temp :list){
            if(temp.left!=null){
                Stack<TreeNode> stack = new Stack<TreeNode>();
                stack.push(temp.left);
                int max = Integer.MIN_VALUE;
                while(!stack.isEmpty()){
                    TreeNode current = stack.pop();
                    if(max<current.val){
                        max = current.val;
                    }
                    if(current.left!=null){
                        stack.push(current.left);
                    }
                    if(current.right!=null){
                        stack.push(current.right);
                    }
                }
                if(temp.val<max){
                    res = 0;
                    break;
                }
            }
            //right
            if(temp.right!=null){
                Stack<TreeNode> stack = new Stack<TreeNode>();
                stack.push(temp.right);
                int min = Integer.MAX_VALUE;
                while(!stack.isEmpty()){
                    TreeNode current = stack.pop();
                    if(min>current.val){
                        min = current.val;
                    }
                    if(current.left!=null){
                        stack.push(current.left);
                    }
                    if(current.right!=null){
                        stack.push(current.right);
                    }
                }
                if(temp.val>min){
                    res = 0;
                    break;
                }
            }
        }

        System.out.println(res);
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