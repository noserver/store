import java.util.*;
/*给一个数组，返回数组的全排列*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //这种问题最适合递归解决
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> num_list = new ArrayList<Integer>();
        for(int x:nums){
            num_list.add(x);
        }
        //1,2,3,6
        tools(res,new ArrayList<Integer>(),num_list);
        return res;
    }
    public void tools(List<List<Integer>> result,List<Integer> current,List<Integer> num){
        //如果nums为空，完成直接添加到result中
        if(num.size()==1){
            current.add(num.get(0));
            result.add(current);
        }
        //如果包含多个，则将数字加入后然后剩余的加入递归中
        for(int i=0;i<num.size();i++){
            List<Integer> newCurrent = new ArrayList<Integer>(current);
            newCurrent.add(num.get(i));
            List<Integer> newNum = new ArrayList<Integer>(num);
            newNum.remove(i);
            tools(result,newCurrent,newNum);
        }
    }
}