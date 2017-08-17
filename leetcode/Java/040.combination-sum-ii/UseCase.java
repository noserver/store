import java.util.*;
public class UseCase{
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] cand = {1,7,1};
        List<List<Integer>> list = sol.combinationSum2(cand,8);
        System.out.println(list);
    }
}