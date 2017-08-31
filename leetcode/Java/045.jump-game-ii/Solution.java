/**
 * 思路是这样的，走一步+下一步能够覆盖最远的就是
 * 两个量max记录当前最长范围，last记录上次最长范围，当遍历到last时说明步数该+1了
 * 这样遍历一次即可
 */
class Solution {
    public int jump(int[] nums) {
        int last = 0;
        int max = 0;
        int step = 0;

        for(int i=0;i<nums.length-1;i++){//因为在最后一个之前一定是可以到达最后，也就是说最差也是nums.length-1的时候max到nums.length-1，所以不用遍历最后一个位置
            max = Math.max(max,i+nums[i]);
            if(i==last){
                step++;
                last = max;
            }
        }
        return step;
    }
}