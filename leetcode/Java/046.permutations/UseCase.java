import java.util.*;
public class UseCase{
    public static void main(String args[]){
        int[] arr = {1,2,3};
        Solution sol = new Solution();
        List<List<Integer>> res = sol.permute(arr);
        System.out.println(res);
    }
}