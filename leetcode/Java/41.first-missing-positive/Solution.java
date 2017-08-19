public class Solution {
    public int firstMissingPositive(int[] nums) {
        int temp = 0;
        //第一遍循环，进行排序
        for(int i=0;i<nums.length;i++){
            //正数，
            if(nums[i]>0&&nums[i]<nums.length){
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp-1] = temp;
            }
        }
        //遍历一遍，第一个nums[i]!=i的就是第一个缺失的正数
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }
}
/**
 * 这个题目关键在于通过一遍遍历找出缺失的正数
 * 并且使用常熟个空间
 * 应该需要构造一个专门的数据结构才能够解决
 */

/**
 * 题目想好好久没思路，看了下discusshttps://discuss.leetcode.com/topic/8293/my-short-c-solution-o-1-space-and-o-n-time/18
 * 这个先用交换，将每个数字交换到对应位置，避免了额外的空间，
 * 然后遍历一遍，找出第一个位置不合适的
 * 感觉这个做法效率未必高
 * 所有都在做进行排序，感觉还应该有其他思路
 */