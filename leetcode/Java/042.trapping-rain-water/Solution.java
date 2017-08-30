/*
 * 求储水问题
 * [0,1,0,2,1,0,1,3,2,1,2,1]
 */
/*
 * 忍不住看了一眼discuss，想起来好像以前在nowcoder做过
 * 思路还有印象，自己来实现一遍
 */
class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        //总体思路就是从两边向中间走，小的进一步
        int left = 0;
        int right = height.length-1;
        int max_l = height[left];
        int max_r = height[right];
        int sum = 0;
        while(left<right){
            if(height[left]<height[right]){
                //左值小于右值
                if(height[left]>=max_l){
                    //如果值变大，则替换最大值
                    max_l = height[left];
                }
                else{
                    sum = sum + (max_l-height[left]);
                }
                left++;
            }
            else{
                if(height[right]>=max_r){
                    max_r = height[right];
                }
                else{
                    sum = sum + (max_r-height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}