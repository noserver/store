import java.util.*;
public class UseCase{
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] cand = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> list = sol.combinationSum(cand,8);
        System.out.println(list);
    }
}