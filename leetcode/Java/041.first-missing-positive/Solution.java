public class Solution {
    public int firstMissingPositive(int[] nums) {
        int temp = 0;
        int max = nums.length;//最大值
        //第一遍循环，进行排序
        for(int i=0;i<max;){
            //几种抛弃值的可能：小于0，大于最大值，小于已排序值，或者相同
            if(nums[i]==i+1){
                i++;
            }
            else if(nums[i]<=0||nums[i]>max||nums[i]<i+1||nums[i]==nums[nums[i]-1]){
                //交换nums[i]和nums[max-1]
                temp = nums[i];
                nums[i]=nums[max-1];
                nums[max-1] = temp;
                max--;
            }
            else{
                //交换nums[i]和nums[nums[i]-1]
                temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        return max+1;
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

/**
 * 之前做法有问题，一遍循环就可以解决的
 */
/**
 * 最终解决思路：
 * 还是交换，但是一遍就可以解决的交换
 * 负数或大于nums.length交换到nums.length-1-i位置
 * 其余交换到nums[nums[i]-1]位置
 * 交换结束后，如果不满足nums[i]==i+1,则返回i+1
 * 这样不用第二遍循环了
 **/