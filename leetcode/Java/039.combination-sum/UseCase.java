import java.util.*;
public class UseCase{
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] cand = {7, 3, 6, 2};
        List<List<Integer>> list = sol.combinationSum(cand,7);
        System.out.println(list);
    }
}