import java.util.*;
/**
 * 对于candidates中的数组，返回和为target的组合
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //递归
        //构造一个集合，存储candidates
        //递归步骤，如果当前和为target则存入最终结果，并且返回
        //如果当前和>target或者当前集合没有值了，则返回
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> curList = new ArrayList<Integer>();
        if(target==0) return list;
        for(int num:candidates){
            System.out.println(num);
            stack.push(num);
        }
        getResult(stack,curList,list,0,target);
        return list;
    }
    public void getResult(Stack<Integer> stack,List curList,List list,int sum,int target){
        //传入当前栈，当前列表curList，结果list，当前和sum，目标和target
        //如果当前栈为空，直接返回
        if(stack.empty()){
            return;
        }
        //循环遍历栈
        while(!stack.empty()){
            int temp = stack.pop();
            sum = sum + temp;
            //判断
            if(sum==target){
                curList.add(temp);
                //target达成
                list.add(curList);
            }
            else if(sum<target){
                curList.add(temp);
                //小于target时，进行递归
                List<Integer> newList = new ArrayList<Integer>(curList);
                Stack<Integer> newStack = (Stack<Integer>)stack.clone();
                getResult(newStack,newList,list,sum,target);
            }
            else{
                //大于target情况,过掉当前，进入下一次
                sum = sum - temp;
            }
        }
    }

}