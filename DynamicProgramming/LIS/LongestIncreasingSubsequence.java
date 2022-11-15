// problem -- https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < dp.length;i++){
            int max = 0;
            
            for(int j = i-1; j >= 0;j--){
                if(nums[i] > nums[j]){
                    // this means that we can append nums[i] in the LIS ending at nums[j]
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp[i] = max + 1;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < dp.length;i++){
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}


// ROUGH WORK




