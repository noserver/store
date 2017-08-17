import java.util.*;
/**
 * 对于candidates中的数组，返回和为target的组合,可以重复使用
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //使用递归解决
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        solver(list,new ArrayList<Integer>(),candidates,target,0);
        return list;
    }
    public void solver(List<List<Integer>> list,List<Integer> curList,int[] arr,int target,int sum) {
        //System.out.println("sum is:"+sum);
        //System.out.println("target is:"+target);
        //先进行判断
        if(sum==target){
            list.add(curList);
            return;
        }
        else if(sum>target){
            return;//这里存在问题
        }
        else{
            //小于情况，需要递归
            for(int i=0;i<arr.length;i++){
                //递归中curList,arr都有可能在下次循环中使用
                //所以这里重复创建一份进行递归
                int[] newArray = Arrays.copyOfRange(arr,i,arr.length);
                List<Integer> newList = new ArrayList<Integer>(curList);
                newList.add(arr[i]);
                //System.out.println(newList);
                int newSum = sum +arr[i];
                solver(list,newList,newArray,target,newSum);
            }
        }
    }

}