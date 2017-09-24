import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int step = sc.nextInt();
        //构建城市树
        TreeNode[] arr = new TreeNode[total];
        for(int i = 1;i<total;i++){
            int parent = sc.nextInt();
            if(arr[parent]==null){
                arr[parent] = new TreeNode();
            }
            if(arr[i]==null){
                arr[i]=new TreeNode();
            }
            arr[parent].list.add(arr[i]);
        }
        //遍历树，设置size大小
        setStep(arr[0]);
        //找出最大值
        int max = 0;
        for(int i=0;i<total;i++){
            if(arr[i].step>max){
                max = arr[i].step;
            }
        }
        //比较分析结果
        if(step<=max){
            System.out.println(step+1);
            return;
        }
        //
        int res = (step-max)/2;//剩余可游城市数
        int left = total-max-1;//剩余城市
        if(res>left){
            System.out.println(total);
        }else{
            System.out.println(max+res+1);
        }
    }
    public static void setStep(TreeNode node){
        //设置step
        for(int i =0;i<node.list.size();i++){
            node.list.get(i).step = node.step+1;
            setStep(node.list.get(i)); 
        }
    }
}
class TreeNode{
    int step = 0;
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
}