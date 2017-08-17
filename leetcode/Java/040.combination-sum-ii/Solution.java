import java.util.*;
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        solver2(list,new ArrayList<Integer>(),candidates,target,0);
        return list;
    }
    public void solver2(List<List<Integer>> list,List<Integer> curList, int[] num,int target,int sum){
        //和第一个思路相似，限制一下重复问题就可以了
        if(sum==target){
            list.add(curList);
        }
        else if(sum>target){
            return;            
        }
        else{                       
            //
            for(int i=0;i<num.length;i++){
                List<Integer> newList = new ArrayList<Integer>(curList);
                newList.add(num[i]);
                int[] newNum = Arrays.copyOfRange(num,i+1,num.length);
                int newSum = sum+num[i];
                solver2(list,newList,newNum,target,newSum);
                //这里处理重复问题，应该还有更好的方法
                while(i+1<num.length&&num[i]==num[i+1]){
                    i++;
                }
            }
        }
    }
}